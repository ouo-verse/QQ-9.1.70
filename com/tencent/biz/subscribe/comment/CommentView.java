package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StComment;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CommentView extends RelativeLayout implements View.OnClickListener, View.OnLongClickListener {
    ReplyContainer C;
    View D;
    ImageView E;
    TextView F;
    View G;
    private CertifiedAccountMeta$StComment H;
    private Drawable I;
    private int J;
    b K;
    private Drawable L;
    private boolean M;

    /* renamed from: d, reason: collision with root package name */
    private int f95911d;

    /* renamed from: e, reason: collision with root package name */
    private m f95912e;

    /* renamed from: f, reason: collision with root package name */
    RelativeLayout f95913f;

    /* renamed from: h, reason: collision with root package name */
    RoundCornerImageView f95914h;

    /* renamed from: i, reason: collision with root package name */
    TextView f95915i;

    /* renamed from: m, reason: collision with root package name */
    AsyncRichTextView f95916m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (CommentView.this.H != null && CommentView.this.H.vecReply.size() > 0) {
                CommentView.this.f95912e.onClick(view, 10, CommentView.this.f95911d, CommentView.this.H);
                CommentView.this.K.f95923f.setVisibility(8);
                CommentView.this.K.f95922e.setVisibility(8);
                CommentView.this.C.setVisibility(0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public LinearLayout f95918a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f95919b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f95920c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f95921d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f95922e;

        /* renamed from: f, reason: collision with root package name */
        public LinearLayout f95923f;

        b() {
        }
    }

    public CommentView(Context context) {
        this(context, null);
    }

    private void d() {
        this.f95913f.setOnClickListener(this);
        this.f95914h.setOnClickListener(this);
        this.f95915i.setOnClickListener(this);
        this.f95916m.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.f95916m.setOnLongClickListener(this);
        this.f95913f.setOnLongClickListener(this);
    }

    private void g() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f167715ev, (ViewGroup) this, true);
        this.f95913f = (RelativeLayout) inflate.findViewById(R.id.b3r);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) inflate.findViewById(R.id.a2o);
        this.f95914h = roundCornerImageView;
        roundCornerImageView.setCorner(ImmersiveUtils.dpToPx(18.0f));
        this.f95915i = (TextView) inflate.findViewById(R.id.fxo);
        this.f95916m = (AsyncRichTextView) inflate.findViewById(R.id.fxm);
        this.C = (ReplyContainer) inflate.findViewById(R.id.i7g);
        this.D = inflate.findViewById(R.id.e9g);
        this.E = (ImageView) inflate.findViewById(R.id.e9c);
        this.F = (TextView) inflate.findViewById(R.id.e9h);
        this.G = inflate.findViewById(R.id.bmt);
        b bVar = new b();
        this.K = bVar;
        bVar.f95918a = (LinearLayout) inflate.findViewById(R.id.it8);
        this.K.f95919b = (TextView) inflate.findViewById(R.id.b3y);
        this.K.f95920c = (TextView) inflate.findViewById(R.id.f0f);
        this.K.f95923f = (LinearLayout) inflate.findViewById(R.id.aih);
        this.K.f95921d = (TextView) inflate.findViewById(R.id.ajg);
        this.K.f95922e = (ImageView) inflate.findViewById(R.id.f164998bn2);
    }

    private void h(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, boolean z16) {
        b bVar = this.K;
        if (bVar != null && bVar.f95923f != null) {
            if (z16 && certifiedAccountMeta$StComment != null && certifiedAccountMeta$StComment.vecReply.size() > 0) {
                String a16 = f.a(certifiedAccountMeta$StComment.createTime.get() * 1000);
                this.K.f95923f.setVisibility(0);
                this.K.f95922e.setVisibility(0);
                this.K.f95919b.setText(a16);
                if (certifiedAccountMeta$StComment.vecReply.size() > 0) {
                    this.K.f95920c.setText(certifiedAccountMeta$StComment.replyCount + HardCodeUtil.qqStr(R.string.f171763ku4));
                    return;
                }
                return;
            }
            this.K.f95923f.setVisibility(8);
            this.K.f95922e.setVisibility(8);
        }
    }

    public LinearLayout e() {
        return this.C;
    }

    public ReplyView f(String str) {
        return this.C.b(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m mVar;
        CertifiedAccountMeta$StComment certifiedAccountMeta$StComment;
        CertifiedAccountMeta$StComment certifiedAccountMeta$StComment2;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.a2o) {
            m mVar2 = this.f95912e;
            if (mVar2 != null && (certifiedAccountMeta$StComment2 = this.H) != null) {
                mVar2.onClick(view, 1, this.f95911d, certifiedAccountMeta$StComment2.postUser);
            }
        } else if (id5 == R.id.fxo) {
            m mVar3 = this.f95912e;
            if (mVar3 != null && (certifiedAccountMeta$StComment = this.H) != null) {
                mVar3.onClick(view, 2, this.f95911d, certifiedAccountMeta$StComment.postUser);
            }
        } else if ((id5 == R.id.fxm || id5 == R.id.b3r) && (mVar = this.f95912e) != null) {
            mVar.onClick(view, 4, this.f95911d, this.H);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        boolean z16;
        EventCollector.getInstance().onViewLongClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.fxm && id5 != R.id.b3r) {
            z16 = false;
        } else {
            m mVar = this.f95912e;
            if (mVar != null) {
                mVar.onLongClick(view, 5, this.f95911d, this.H);
            }
            z16 = true;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    public void setData(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, int i3, String str) {
        this.H = certifiedAccountMeta$StComment;
        if (certifiedAccountMeta$StComment == null) {
            return;
        }
        int i16 = 0;
        if (certifiedAccountMeta$StComment.postUser != null) {
            if (BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(certifiedAccountMeta$StComment.postUser.f24929id.get()) && StringUtil.isEmpty(certifiedAccountMeta$StComment.postUser.icon.get())) {
                if (this.L == null) {
                    this.L = new BitmapDrawable(BaseImageUtil.getRoundFaceBitmap(k.a(k.b(null, 1, certifiedAccountMeta$StComment.postUser.f24929id.get(), 0)).f306778a, 50, 50));
                }
                UIUtils.q(this.f95914h, "", UIUtils.b(getContext(), 35.0f), UIUtils.b(getContext(), 35.0f), UIUtils.b(getContext(), 18.0f), this.L, null);
            } else {
                UIUtils.q(this.f95914h, certifiedAccountMeta$StComment.postUser.icon.get(), UIUtils.b(getContext(), 35.0f), UIUtils.b(getContext(), 35.0f), UIUtils.b(getContext(), 18.0f), BaseImageUtil.getDefaultFaceDrawable(), null);
            }
            this.f95915i.setText(certifiedAccountMeta$StComment.postUser.nick.get());
            if (certifiedAccountMeta$StComment.postUser.f24929id.get().equals(str)) {
                if (this.I == null) {
                    Drawable drawable = getResources().getDrawable(R.drawable.h8k);
                    this.I = drawable;
                    drawable.setBounds(0, 0, ImmersiveUtils.dpToPx(21.0f), ImmersiveUtils.dpToPx(12.0f));
                }
                this.f95915i.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(2.0f));
                this.f95915i.setCompoundDrawables(null, null, this.I, null);
            } else {
                this.f95915i.setCompoundDrawables(null, null, null, null);
            }
        }
        this.f95916m.setText(certifiedAccountMeta$StComment.content.get());
        this.K.f95919b.setText(f.a(certifiedAccountMeta$StComment.createTime.get() * 1000));
        h(certifiedAccountMeta$StComment, false);
        if (this.H.vecReply.size() == 0) {
            this.C.setVisibility(8);
        } else if (this.H.vecReply.size() > 0) {
            if (i3 == 0) {
                this.C.d(this.H, i3, str);
                this.C.setVisibility(8);
                h(certifiedAccountMeta$StComment, true);
            } else {
                this.C.d(this.H, i3, str);
                this.C.setVisibility(0);
            }
        } else {
            this.C.setVisibility(8);
        }
        this.M = false;
        View view = this.D;
        if (!e.a()) {
            i16 = 8;
        }
        view.setVisibility(i16);
    }

    public void setDisplayNum(int i3) {
        this.J = i3;
        this.C.setDisplayNum(i3);
    }

    public void setOnCommentElementClickListener(m mVar) {
        LinearLayout linearLayout;
        this.f95912e = mVar;
        this.C.setOnCommentElementClickListener(mVar);
        b bVar = this.K;
        if (bVar != null && (linearLayout = bVar.f95923f) != null) {
            linearLayout.setOnClickListener(new a());
        }
    }

    public void setPosition(int i3) {
        this.f95911d = i3;
        this.C.setPosition(i3);
    }

    public CommentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.M = false;
        g();
        d();
    }
}
