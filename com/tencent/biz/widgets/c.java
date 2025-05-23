package com.tencent.biz.widgets;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.LinkSpan;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends QQText {

    /* renamed from: d, reason: collision with root package name */
    public String f97765d;

    /* renamed from: e, reason: collision with root package name */
    public String f97766e;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends LinkSpan {
        public a(String str) {
            super(str);
        }

        @Override // com.tencent.mobileqq.text.style.LinkSpan
        protected void g(View view, String str) {
            String str2;
            Context context = view.getContext();
            Intent intent = new Intent();
            intent.putExtra("uin", c.this.f97765d);
            int lastIndexOf = str.lastIndexOf("#");
            if (lastIndexOf > 0) {
                str2 = str.substring(lastIndexOf);
            } else {
                str2 = null;
            }
            String guessUrl = URLUtil.guessUrl(str);
            if (str2 != null) {
                guessUrl = guessUrl + str2;
            }
            intent.putExtra("url", guessUrl);
            intent.putExtra(IPublicAccountBrowser.KEY_BACK_TEXT, context.getResources().getString(R.string.button_back));
            intent.putExtra(IPublicAccountBrowser.KEY_PUB_UIN, c.this.f97766e);
            intent.putExtra("key_isReadModeEnabled", true);
            intent.putExtra("fromAio", true);
            intent.putExtra("fromPublicAccount", true);
            intent.putExtra("articalChannelId", 1);
            intent.putExtra("big_brother_source_key", ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(c.this.f97766e));
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(intent, str);
            if (intent.getComponent() != null) {
                context.startActivity(intent);
            } else {
                ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, IPublicAccountBrowser.ROUTE_NAME);
                activityURIRequest.extra().putAll(intent.getExtras());
                QRoute.startUri(activityURIRequest, (o) null);
            }
            ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, guessUrl, "", "", "");
        }
    }

    public c(CharSequence charSequence, int i3) {
        super(charSequence, i3);
    }

    @Override // com.tencent.mobileqq.text.QQText, com.tencent.mobileqq.text.processor.ISpanCallback
    public void addSpan(Object obj, int i3, int i16, int i17) {
        if (obj instanceof LinkSpan) {
            obj = new a(((LinkSpan) obj).f292710d);
        }
        super.addSpan(obj, i3, i16, i17);
    }
}
