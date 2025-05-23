package com.tencent.biz.pubaccount.weishi.comment;

import UserGrowth.stSimpleMetaComment;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi.richtext.d;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WsCommentView extends RelativeLayout implements View.OnClickListener, View.OnLongClickListener {
    WsReplyContainer C;
    View D;
    ImageView E;
    TextView F;
    View G;
    private stSimpleMetaComment H;
    private Drawable I;
    private int J;
    private m K;
    d L;
    private Drawable M;
    private boolean N;

    /* renamed from: d, reason: collision with root package name */
    private int f80531d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.biz.subscribe.comment.m f80532e;

    /* renamed from: f, reason: collision with root package name */
    RelativeLayout f80533f;

    /* renamed from: h, reason: collision with root package name */
    RoundCornerImageView f80534h;

    /* renamed from: i, reason: collision with root package name */
    TextView f80535i;

    /* renamed from: m, reason: collision with root package name */
    FeedRichTextView f80536m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WsCommentView.this.H == null || WsCommentView.this.H.replyList.size() <= 0) {
                return;
            }
            WsCommentView.this.f80532e.onClick(view, 10, WsCommentView.this.f80531d, WsCommentView.this.H);
            WsCommentView.this.L.f80545f.setVisibility(8);
            WsCommentView.this.L.f80544e.setVisibility(8);
            WsCommentView.this.C.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements FeedRichTextView.b {
        c() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView.b
        public void a(ArrayList<d.e> arrayList) {
            WsCommentView.this.i(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public LinearLayout f80540a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f80541b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f80542c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f80543d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f80544e;

        /* renamed from: f, reason: collision with root package name */
        public LinearLayout f80545f;

        d() {
        }
    }

    public WsCommentView(Context context) {
        this(context, null);
    }

    private void f() {
        this.L.f80543d.setOnClickListener(this);
        this.f80533f.setOnClickListener(this);
        this.f80534h.setOnClickListener(this);
        this.f80535i.setOnClickListener(this);
        this.f80536m.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.f80533f.setOnLongClickListener(this);
        this.f80536m.setOnLongClickListener(this);
        this.f80536m.setOnElementClickListener(new b());
        this.f80536m.setOnParseListener(new c());
    }

    private Map<String, String> g() {
        HashMap hashMap = new HashMap();
        hashMap.put("comment_id", this.H.f25128id);
        hashMap.put("comment_reply_id", "");
        hashMap.put(QCircleSchemeAttr.WebView.OPEN_TYPE, String.valueOf(this.K.f()));
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, this.K.getPlayScene());
        hashMap.put("jubao_from", "1");
        return hashMap;
    }

    private void h() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fvm, (ViewGroup) this, true);
        this.f80533f = (RelativeLayout) inflate.findViewById(R.id.b3r);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) inflate.findViewById(R.id.a2o);
        this.f80534h = roundCornerImageView;
        roundCornerImageView.setCorner(ImmersiveUtils.dpToPx(18.0f));
        this.f80535i = (TextView) inflate.findViewById(R.id.fxo);
        this.f80536m = (FeedRichTextView) inflate.findViewById(R.id.fxm);
        this.C = (WsReplyContainer) inflate.findViewById(R.id.i7g);
        this.D = inflate.findViewById(R.id.e9g);
        this.E = (ImageView) inflate.findViewById(R.id.e9c);
        this.F = (TextView) inflate.findViewById(R.id.e9h);
        this.G = inflate.findViewById(R.id.bmt);
        this.f80536m.setOnTouchListener(new com.tencent.biz.pubaccount.weishi.util.m());
        this.f80536m.setRichTextDisplayType(1);
        d dVar = new d();
        this.L = dVar;
        dVar.f80540a = (LinearLayout) inflate.findViewById(R.id.it8);
        this.L.f80541b = (TextView) inflate.findViewById(R.id.b3y);
        this.L.f80542c = (TextView) inflate.findViewById(R.id.f0f);
        this.L.f80545f = (LinearLayout) inflate.findViewById(R.id.aih);
        this.L.f80543d = (TextView) inflate.findViewById(R.id.ajg);
        this.L.f80544e = (ImageView) inflate.findViewById(R.id.f164998bn2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ArrayList<d.e> arrayList) {
        if (this.H == null || arrayList == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            sb5.append(arrayList.get(i3).f81566a);
            sb6.append(arrayList.get(i3).f81568c);
            if (i3 != arrayList.size() - 1) {
                sb5.append(",");
                sb6.append(",");
            }
        }
        m mVar = this.K;
        if (mVar == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.report.b.m(mVar.e(), this.K.getPlayScene(), this.H.f25128id, "", sb5.toString(), sb6.toString(), this.f80531d, this.K.h(), this.K.g());
    }

    private void j(stSimpleMetaComment stsimplemetacomment, boolean z16) {
        d dVar = this.L;
        if (dVar == null || dVar.f80545f == null) {
            return;
        }
        if (z16 && stsimplemetacomment != null && stsimplemetacomment.replyList.size() > 0) {
            String c16 = com.tencent.biz.pubaccount.weishi.util.o.c(stsimplemetacomment.createtime * 1000);
            this.L.f80545f.setVisibility(0);
            this.L.f80544e.setVisibility(0);
            this.L.f80541b.setText(c16);
            if (stsimplemetacomment.replyList.size() > 0) {
                this.L.f80542c.setText(stsimplemetacomment.replyNum + HardCodeUtil.qqStr(R.string.f171763ku4));
                return;
            }
            return;
        }
        this.L.f80545f.setVisibility(8);
        this.L.f80544e.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        stSimpleMetaComment stsimplemetacomment;
        stSimpleMetaComment stsimplemetacomment2;
        switch (view.getId()) {
            case R.id.a2o /* 2131363663 */:
                com.tencent.biz.subscribe.comment.m mVar = this.f80532e;
                if (mVar == null || (stsimplemetacomment = this.H) == null) {
                    return;
                }
                mVar.onClick(view, 1, this.f80531d, stsimplemetacomment.poster);
                return;
            case R.id.ajg /* 2131364695 */:
                com.tencent.biz.subscribe.comment.m mVar2 = this.f80532e;
                if (mVar2 != null) {
                    mVar2.onClick(view, 13, this.f80531d, this.H);
                    return;
                }
                return;
            case R.id.b3r /* 2131365986 */:
            case R.id.fxm /* 2131379164 */:
                com.tencent.biz.subscribe.comment.m mVar3 = this.f80532e;
                if (mVar3 != null) {
                    mVar3.onClick(view, 4, this.f80531d, this.H);
                    return;
                }
                return;
            case R.id.e9g /* 2131374974 */:
                if (this.f80532e != null) {
                    this.N = true;
                    boolean z16 = this.H.isDing == 1;
                    x.l("comment", "\u70b9\u8d5e\u524d isDing\uff1a" + z16 + ",mComment.isDing:" + this.H.isDing);
                    k(z16);
                    if (!z16) {
                        x.l("comment", "\u6267\u884c\u70b9\u8d5e ...............");
                        stSimpleMetaComment stsimplemetacomment3 = this.H;
                        long j3 = stsimplemetacomment3.dingNum + 1;
                        stsimplemetacomment3.dingNum = j3;
                        this.F.setText(com.tencent.biz.subscribe.comment.i.a(j3));
                    } else {
                        stSimpleMetaComment stsimplemetacomment4 = this.H;
                        long j16 = stsimplemetacomment4.dingNum;
                        if (j16 > 1) {
                            x.l("comment", "\u6267\u884c\u70b9\u8d5e-1 ...............");
                            stSimpleMetaComment stsimplemetacomment5 = this.H;
                            long j17 = stsimplemetacomment5.dingNum - 1;
                            stsimplemetacomment5.dingNum = j17;
                            this.F.setText(com.tencent.biz.subscribe.comment.i.a(j17));
                        } else {
                            stsimplemetacomment4.dingNum = j16 - 1;
                            x.l("comment", "\u6267\u884c\u53d6\u6d88\u70b9\u8d5e ...............");
                            this.F.setText("");
                        }
                    }
                    stSimpleMetaComment stsimplemetacomment6 = this.H;
                    stsimplemetacomment6.isDing = (stsimplemetacomment6.isDing + 1) % 2;
                    x.l("comment", "\u70b9\u8d5e\u540e mComment.isDing\uff1a" + this.H.isDing + ",clickPosition:" + this.f80531d);
                    this.f80532e.onClick(view, 6, this.f80531d, this.H);
                    return;
                }
                x.l("comment", "mOnCommentElementClickListener is null ...............");
                return;
            case R.id.fxo /* 2131379181 */:
                com.tencent.biz.subscribe.comment.m mVar4 = this.f80532e;
                if (mVar4 == null || (stsimplemetacomment2 = this.H) == null) {
                    return;
                }
                mVar4.onClick(view, 2, this.f80531d, stsimplemetacomment2.poster);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        int id5 = view.getId();
        if (id5 != R.id.b3r && id5 != R.id.fxm) {
            return false;
        }
        new h(getContext(), this.K, g()).d(this.f80536m, "\u4e3e\u62a5");
        return true;
    }

    public void setData(stSimpleMetaComment stsimplemetacomment, int i3, String str) {
        this.H = stsimplemetacomment;
        if (stsimplemetacomment == null) {
            return;
        }
        if (stsimplemetacomment.poster != null) {
            if (BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(stsimplemetacomment.poster.f25130id) && StringUtil.isEmpty(stsimplemetacomment.poster.avatar)) {
                if (this.M == null) {
                    this.M = new BitmapDrawable(BaseImageUtil.getRoundFaceBitmap(com.tencent.biz.subscribe.comment.k.a(com.tencent.biz.subscribe.comment.k.b(null, 1, stsimplemetacomment.poster.f25130id, 0)).f306778a, 50, 50));
                }
                UIUtils.q(this.f80534h, "", UIUtils.b(getContext(), 35.0f), UIUtils.b(getContext(), 35.0f), UIUtils.b(getContext(), 18.0f), this.M, null);
            } else {
                UIUtils.q(this.f80534h, stsimplemetacomment.poster.avatar, UIUtils.b(getContext(), 35.0f), UIUtils.b(getContext(), 35.0f), UIUtils.b(getContext(), 18.0f), BaseImageUtil.getDefaultFaceDrawable(), null);
            }
            this.f80535i.setText(stsimplemetacomment.poster.nick);
            if (stsimplemetacomment.poster.f25130id.equals(str)) {
                if (this.I == null) {
                    Drawable drawable = getResources().getDrawable(R.drawable.gng);
                    this.I = drawable;
                    drawable.setBounds(0, ImmersiveUtils.dpToPx(1.0f), ImmersiveUtils.dpToPx(24.0f), ImmersiveUtils.dpToPx(13.0f));
                }
                this.f80535i.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(6.0f));
                this.f80535i.setCompoundDrawables(null, null, this.I, null);
            } else {
                this.f80535i.setCompoundDrawables(null, null, null, null);
            }
        }
        this.f80536m.setText(stsimplemetacomment.wording);
        this.L.f80541b.setText(com.tencent.biz.pubaccount.weishi.util.o.c(stsimplemetacomment.createtime * 1000));
        j(stsimplemetacomment, false);
        if (this.H.replyList.size() == 0) {
            this.C.setVisibility(8);
        } else if (this.H.replyList.size() <= 0) {
            this.C.setVisibility(8);
        } else if (i3 == 0) {
            this.C.c(this.H, i3, str, this.K);
            this.C.setVisibility(8);
            j(stsimplemetacomment, true);
        } else {
            this.C.c(this.H, i3, str, this.K);
            this.C.setVisibility(0);
        }
        k(this.H.isDing == 0);
        long j3 = stsimplemetacomment.dingNum;
        if (j3 > 0) {
            this.F.setText(com.tencent.biz.subscribe.comment.i.a(j3));
        } else {
            this.F.setText("");
        }
        this.N = false;
        this.D.setVisibility(0);
    }

    public void setDisplayNum(int i3) {
        this.J = i3;
        this.C.setDisplayNum(i3);
    }

    public void setOnCommentElementClickListener(com.tencent.biz.subscribe.comment.m mVar) {
        LinearLayout linearLayout;
        this.f80532e = mVar;
        this.C.setOnCommentElementClickListener(mVar);
        d dVar = this.L;
        if (dVar == null || (linearLayout = dVar.f80545f) == null) {
            return;
        }
        linearLayout.setOnClickListener(new a());
    }

    public void setPosition(int i3) {
        this.f80531d = i3;
        this.C.setPosition(i3);
    }

    public void setReportParams(m mVar) {
        this.K = mVar;
    }

    public WsCommentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WsCommentView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.N = false;
        h();
        f();
    }

    public void k(boolean z16) {
        if (!z16) {
            this.E.setImageResource(R.drawable.gnw);
            this.F.setTextColor(getResources().getColor(R.color.f157675wg));
        } else {
            this.E.setImageResource(R.drawable.weishi_ic_follow_feed_like_un);
            this.F.setTextColor(getResources().getColor(R.color.weishi_color_skin_comment_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements FeedRichTextView.a {
        b() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView.a
        public void b(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            WSProfileFragment.ri(WsCommentView.this.getContext(), str, "at_nick");
            if (WsCommentView.this.K == null) {
                return;
            }
            com.tencent.biz.pubaccount.weishi.report.b.v("comment_at_user", WsCommentView.this.K.e(), WsCommentView.this.K.getPlayScene(), str, WsCommentView.this.f80531d, WsCommentView.this.K.h(), WsCommentView.this.K.g());
        }

        @Override // com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView.a
        public void a(String str) {
        }
    }
}
