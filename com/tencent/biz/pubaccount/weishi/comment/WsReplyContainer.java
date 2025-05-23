package com.tencent.biz.pubaccount.weishi.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaReply;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WsReplyContainer extends LinearLayout implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: d, reason: collision with root package name */
    private int f80546d;

    /* renamed from: e, reason: collision with root package name */
    private int f80547e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.biz.subscribe.comment.m f80548f;

    /* renamed from: h, reason: collision with root package name */
    private WSReplyActionView f80549h;

    /* renamed from: i, reason: collision with root package name */
    private stSimpleMetaComment f80550i;

    /* renamed from: m, reason: collision with root package name */
    private int f80551m;

    public WsReplyContainer(Context context) {
        this(context, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.tencent.biz.subscribe.comment.m mVar;
        int id5 = view.getId();
        if (id5 == R.id.e8b) {
            if (this.f80548f != null) {
                this.f80548f.onClick(view, 11, this.f80546d, new Object[]{this.f80550i, Integer.valueOf(getHeight() / this.f80551m)});
            }
        } else if (id5 == R.id.f0o && (mVar = this.f80548f) != null) {
            mVar.onClick(view, 10, this.f80546d, this.f80550i);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return false;
    }

    public void setDisplayNum(int i3) {
        this.f80547e = i3;
    }

    public void setOnCommentElementClickListener(com.tencent.biz.subscribe.comment.m mVar) {
        this.f80548f = mVar;
    }

    public void setPosition(int i3) {
        this.f80546d = i3;
    }

    public WsReplyContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WsReplyContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(stSimpleMetaComment stsimplemetacomment, int i3, String str, m mVar) {
        if (stsimplemetacomment != null && stsimplemetacomment.replyList.size() != 0) {
            this.f80550i = stsimplemetacomment;
            ArrayList<stSimpleMetaReply> arrayList = stsimplemetacomment.replyList;
            int size = arrayList.size();
            int min = i3 > 0 ? Math.min(size, i3) : size;
            this.f80551m = min;
            setVisibility(0);
            removeAllViews();
            for (int i16 = 0; i16 < min; i16++) {
                stSimpleMetaReply stsimplemetareply = arrayList.get(i16);
                WsReplyView wsReplyView = new WsReplyView(getContext());
                wsReplyView.setPosition(i16);
                wsReplyView.setOnCommentElementClickListener(this.f80548f);
                wsReplyView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                wsReplyView.setClickable(true);
                wsReplyView.setFocusable(true);
                wsReplyView.setReportParams(mVar, this.f80546d);
                wsReplyView.setData(stsimplemetacomment, stsimplemetareply, str);
                addView(wsReplyView);
            }
            if (min <= size) {
                if (this.f80549h == null) {
                    WSReplyActionView wSReplyActionView = new WSReplyActionView(getContext());
                    this.f80549h = wSReplyActionView;
                    wSReplyActionView.setClickable(true);
                    this.f80549h.b().setOnClickListener(this);
                    this.f80549h.a().setOnClickListener(this);
                }
                if (min > this.f80547e) {
                    if (min == size) {
                        this.f80549h.b().setVisibility(8);
                        this.f80549h.a().setVisibility(0);
                    } else {
                        this.f80549h.b().setText(HardCodeUtil.qqStr(R.string.t0g));
                        this.f80549h.b().setVisibility(0);
                        this.f80549h.a().setVisibility(0);
                    }
                } else if (size > min) {
                    int i17 = size - min;
                    if (i17 > 0) {
                        this.f80549h.b().setText(HardCodeUtil.qqStr(R.string.t0e) + i17 + HardCodeUtil.qqStr(R.string.t0f));
                        this.f80549h.b().setVisibility(0);
                        this.f80549h.a().setVisibility(8);
                    }
                } else {
                    this.f80549h.b().setVisibility(8);
                    this.f80549h.a().setVisibility(8);
                }
                addView(this.f80549h);
            }
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    private void a() {
    }

    private void b() {
    }
}
