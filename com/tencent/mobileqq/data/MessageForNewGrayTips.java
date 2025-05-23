package com.tencent.mobileqq.data;

import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForNewGrayTips extends ChatMessage {
    public ArrayList<GrayTipsSpan> spans;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GrayTipsSpan f203099d;

        a(GrayTipsSpan grayTipsSpan) {
            this.f203099d = grayTipsSpan;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MessageForNewGrayTips.this.click(view, this.f203099d.url);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public void buildTextView(QQAppInterface qQAppInterface, TextView textView) {
        if (TextUtils.isEmpty(this.f203106msg)) {
            return;
        }
        SpannableString spannableString = new SpannableString(this.f203106msg);
        ArrayList<GrayTipsSpan> arrayList = this.spans;
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<GrayTipsSpan> it = this.spans.iterator();
            while (it.hasNext()) {
                GrayTipsSpan next = it.next();
                try {
                    spannableString.setSpan(new DatingCommentTextView.a(new a(next), -12541697), next.begin, next.end, 33);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void click(View view, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ax c16 = bi.c((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), view.getContext(), str);
        if (c16 != null) {
            c16.b();
        } else {
            Intent intent = new Intent(view.getContext(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", URLUtil.guessUrl(str));
            view.getContext().startActivity(intent);
        }
        if (this.msgtype == -2037 && (view.getContext() instanceof BaseActivity)) {
            ReportController.o(((BaseActivity) view.getContext()).app, "CliOper", "", "", "0X80060B7", "0X80060B7", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        GrayTipsInfo grayTipsInfo;
        try {
            grayTipsInfo = (GrayTipsInfo) MessagePkgUtils.getObjectFromBytes(this.msgData);
        } catch (Exception e16) {
            e16.printStackTrace();
            grayTipsInfo = null;
        }
        if (grayTipsInfo != null) {
            this.f203106msg = grayTipsInfo.text;
            this.spans = grayTipsInfo.spans;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        if (this.f203106msg != null) {
            GrayTipsInfo grayTipsInfo = new GrayTipsInfo();
            grayTipsInfo.text = this.f203106msg;
            grayTipsInfo.spans = this.spans;
            try {
                this.msgData = MessagePkgUtils.getBytesFromObject(grayTipsInfo);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public void updateMsgData() {
        prewrite();
    }
}
