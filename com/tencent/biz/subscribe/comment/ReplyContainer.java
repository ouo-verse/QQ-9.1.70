package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StReply;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ReplyContainer extends LinearLayout implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: d, reason: collision with root package name */
    private int f95943d;

    /* renamed from: e, reason: collision with root package name */
    private int f95944e;

    /* renamed from: f, reason: collision with root package name */
    private m f95945f;

    /* renamed from: h, reason: collision with root package name */
    private ReplyActionView f95946h;

    /* renamed from: i, reason: collision with root package name */
    private CertifiedAccountMeta$StComment f95947i;

    /* renamed from: m, reason: collision with root package name */
    private int f95948m;

    public ReplyContainer(Context context) {
        this(context, null);
    }

    public ReplyView b(String str) {
        int size;
        CertifiedAccountMeta$StComment certifiedAccountMeta$StComment = this.f95947i;
        if (certifiedAccountMeta$StComment != null && certifiedAccountMeta$StComment.vecReply.get() != null && (size = this.f95947i.vecReply.get().size()) > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                if (this.f95947i.vecReply.get(i3).f24928id.get().equals(str) && getChildCount() > i3 + 1 && (getChildAt(i3) instanceof ReplyView)) {
                    return (ReplyView) getChildAt(i3);
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, int i3, String str) {
        int i16;
        if (certifiedAccountMeta$StComment != null && certifiedAccountMeta$StComment.vecReply.size() != 0) {
            this.f95947i = certifiedAccountMeta$StComment;
            List<CertifiedAccountMeta$StReply> list = certifiedAccountMeta$StComment.vecReply.get();
            int size = list.size();
            if (size > 0) {
                if (i3 > 0) {
                    i16 = Math.min(size, i3);
                } else {
                    i16 = size;
                }
                this.f95948m = i16;
                setVisibility(0);
                removeAllViews();
                for (int i17 = 0; i17 < i16; i17++) {
                    CertifiedAccountMeta$StReply certifiedAccountMeta$StReply = list.get(i17);
                    ReplyView replyView = new ReplyView(getContext());
                    replyView.setPosition(i17);
                    replyView.setOnCommentElementClickListener(this.f95945f);
                    replyView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                    replyView.setClickable(true);
                    replyView.setFocusable(true);
                    replyView.setData(certifiedAccountMeta$StComment, certifiedAccountMeta$StReply, str);
                    addView(replyView);
                }
                if (i16 <= size) {
                    if (this.f95946h == null) {
                        ReplyActionView replyActionView = new ReplyActionView(getContext());
                        this.f95946h = replyActionView;
                        replyActionView.setClickable(true);
                        this.f95946h.b().setOnClickListener(this);
                        this.f95946h.a().setOnClickListener(this);
                    }
                    if (i16 > this.f95944e) {
                        if (i16 == size) {
                            this.f95946h.b().setVisibility(8);
                            this.f95946h.a().setVisibility(0);
                        } else {
                            this.f95946h.b().setText(HardCodeUtil.qqStr(R.string.t0g));
                            this.f95946h.b().setVisibility(0);
                            this.f95946h.a().setVisibility(8);
                        }
                    } else if (size > i16) {
                        int i18 = size - i16;
                        if (i18 > 0) {
                            this.f95946h.b().setText(HardCodeUtil.qqStr(R.string.t0e) + i18 + HardCodeUtil.qqStr(R.string.t0f));
                            this.f95946h.b().setVisibility(0);
                            this.f95946h.a().setVisibility(8);
                        }
                    } else {
                        this.f95946h.b().setVisibility(8);
                        this.f95946h.a().setVisibility(8);
                    }
                    addView(this.f95946h);
                }
                setVisibility(0);
                return;
            }
            setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f0o) {
            m mVar = this.f95945f;
            if (mVar != null) {
                mVar.onClick(view, 10, this.f95943d, this.f95947i);
            }
        } else if (id5 == R.id.e8b && this.f95945f != null) {
            this.f95945f.onClick(view, 11, this.f95943d, new Object[]{this.f95947i, Integer.valueOf(getHeight() / this.f95948m)});
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        EventCollector.getInstance().onViewLongClicked(view);
        return false;
    }

    public void setDisplayNum(int i3) {
        this.f95944e = i3;
    }

    public void setOnCommentElementClickListener(m mVar) {
        this.f95945f = mVar;
    }

    public void setPosition(int i3) {
        this.f95943d = i3;
    }

    public ReplyContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ReplyContainer(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c();
        a();
    }

    private void a() {
    }

    private void c() {
    }
}
