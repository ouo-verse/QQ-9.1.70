package com.tencent.biz.pubaccount.weishi.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stSimpleMetaReply;
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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.weishi.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi.richtext.d;
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
public class WsReplyView extends RelativeLayout implements View.OnClickListener, View.OnLongClickListener {
    private static final String R = HardCodeUtil.qqStr(R.string.t0u);
    TextView C;
    ImageView D;
    TextView E;
    LinearLayout F;
    private TextView G;
    private TextView H;
    private TextView I;
    private stSimpleMetaComment J;
    private stSimpleMetaReply K;
    private m L;
    private int M;
    private Drawable N;
    private boolean P;
    private BitmapDrawable Q;

    /* renamed from: d, reason: collision with root package name */
    private int f80552d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.biz.subscribe.comment.m f80553e;

    /* renamed from: f, reason: collision with root package name */
    RoundCornerImageView f80554f;

    /* renamed from: h, reason: collision with root package name */
    TextView f80555h;

    /* renamed from: i, reason: collision with root package name */
    LinearLayout f80556i;

    /* renamed from: m, reason: collision with root package name */
    FeedRichTextView f80557m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements FeedRichTextView.b {
        b() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView.b
        public void a(ArrayList<d.e> arrayList) {
            WsReplyView.this.h(arrayList);
        }
    }

    public WsReplyView(Context context) {
        this(context, null);
    }

    private void d() {
        this.f80554f.setOnClickListener(this);
        this.f80555h.setOnClickListener(this);
        this.f80556i.setOnClickListener(this);
        this.f80557m.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.f80556i.setOnLongClickListener(this);
        this.f80557m.setOnLongClickListener(this);
        setOnClickListener(this);
        this.f80557m.setOnElementClickListener(new a());
        this.f80557m.setOnParseListener(new b());
    }

    private void e(View view, int i3) {
        com.tencent.biz.subscribe.comment.m mVar = this.f80553e;
        if (mVar != null) {
            mVar.onClick(view, i3, this.f80552d, new Object[]{this.J, this.K});
        }
    }

    private Map<String, String> f() {
        HashMap hashMap = new HashMap();
        hashMap.put("comment_id", this.J.f25128id);
        hashMap.put("comment_reply_id", this.K.f25131id);
        hashMap.put(QCircleSchemeAttr.WebView.OPEN_TYPE, String.valueOf(this.L.f()));
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, this.L.getPlayScene());
        hashMap.put("jubao_from", "1");
        return hashMap;
    }

    private void g() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fvr, (ViewGroup) this, true);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) inflate.findViewById(R.id.f165909du3);
        this.f80554f = roundCornerImageView;
        roundCornerImageView.setCorner(ImmersiveUtils.dpToPx(10.0f));
        this.f80555h = (TextView) inflate.findViewById(R.id.i7u);
        this.f80556i = (LinearLayout) inflate.findViewById(R.id.i7j);
        this.f80557m = (FeedRichTextView) inflate.findViewById(R.id.i7s);
        this.C = (TextView) inflate.findViewById(R.id.i7t);
        this.F = (LinearLayout) inflate.findViewById(R.id.i7o);
        this.D = (ImageView) inflate.findViewById(R.id.i7n);
        this.E = (TextView) inflate.findViewById(R.id.i7p);
        this.G = (TextView) inflate.findViewById(R.id.f73293t6);
        this.H = (TextView) inflate.findViewById(R.id.f73273t4);
        this.I = (TextView) inflate.findViewById(R.id.ajf);
        setPadding(0, 0, 0, Utils.dp2px(5.0d));
        this.f80557m.setOnTouchListener(new com.tencent.biz.pubaccount.weishi.util.m());
        this.f80557m.setRichTextDisplayType(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ArrayList<d.e> arrayList) {
        if (this.J == null || this.K == null) {
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
        com.tencent.biz.pubaccount.weishi.report.b.m(this.L.e(), this.L.getPlayScene(), this.J.f25128id, this.K.f25131id, sb5.toString(), sb6.toString(), this.M, this.L.h(), this.L.g());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        stSimpleMetaReply stsimplemetareply;
        switch (view.getId()) {
            case R.id.ajf /* 2131364694 */:
                e(view, 14);
                return;
            case R.id.f165909du3 /* 2131373951 */:
                e(view, 15);
                return;
            case R.id.i7j /* 2131385646 */:
            case R.id.i7s /* 2131385669 */:
                e(view, 7);
                return;
            case R.id.i7u /* 2131385671 */:
                com.tencent.biz.subscribe.comment.m mVar = this.f80553e;
                if (mVar == null || (stsimplemetareply = this.K) == null) {
                    return;
                }
                mVar.onClick(view, 2, this.f80552d, stsimplemetareply.poster);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        int id5 = view.getId();
        if (id5 != R.id.i7j && id5 != R.id.i7s) {
            return false;
        }
        new h(getContext(), this.L, f()).d(this.f80557m, "\u4e3e\u62a5");
        return true;
    }

    public void setData(stSimpleMetaComment stsimplemetacomment, stSimpleMetaReply stsimplemetareply, String str) {
        this.J = stsimplemetacomment;
        this.K = stsimplemetareply;
        if (stsimplemetacomment == null || stsimplemetareply == null) {
            return;
        }
        if (stsimplemetareply.poster != null) {
            if (BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(stsimplemetareply.poster.f25130id) && StringUtil.isEmpty(stsimplemetareply.poster.avatar)) {
                if (this.Q == null) {
                    this.Q = new BitmapDrawable(BaseImageUtil.getRoundFaceBitmap(com.tencent.biz.subscribe.comment.k.a(com.tencent.biz.subscribe.comment.k.b(null, 1, stsimplemetareply.poster.f25130id, 0)).f306778a, 50, 50));
                }
                UIUtils.q(this.f80554f, "", UIUtils.b(getContext(), 20.0f), UIUtils.b(getContext(), 20.0f), UIUtils.b(getContext(), 10.0f), this.Q, null);
            } else {
                UIUtils.q(this.f80554f, stsimplemetareply.poster.avatar, UIUtils.b(getContext(), 20.0f), UIUtils.b(getContext(), 20.0f), UIUtils.b(getContext(), 10.0f), BaseImageUtil.getDefaultFaceDrawable(), null);
            }
            this.f80555h.setText(stsimplemetareply.poster.nick);
            if (stsimplemetareply.poster.f25130id.equals(str)) {
                if (this.N == null) {
                    Drawable drawable = getResources().getDrawable(R.drawable.gng);
                    this.N = drawable;
                    drawable.setBounds(0, ImmersiveUtils.dpToPx(1.0f), ImmersiveUtils.dpToPx(24.0f), ImmersiveUtils.dpToPx(13.0f));
                }
                this.f80555h.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(6.0f));
                this.f80555h.setCompoundDrawables(null, null, this.N, null);
            } else {
                this.f80555h.setCompoundDrawables(null, null, null, null);
            }
            stSimpleMetaPerson stsimplemetaperson = stsimplemetareply.receiver;
            if (stsimplemetaperson != null) {
                String str2 = stsimplemetaperson.nick;
                if (!TextUtils.isEmpty(str2) && !TextUtils.equals(stsimplemetacomment.poster.f25130id, stsimplemetareply.receiver.f25130id)) {
                    this.H.setVisibility(0);
                    this.H.setText(str2);
                    this.G.setVisibility(0);
                } else {
                    this.G.setVisibility(8);
                    this.H.setVisibility(8);
                }
            }
        }
        this.f80557m.setText(stsimplemetareply.wording);
        this.C.setText(com.tencent.biz.pubaccount.weishi.util.o.c(stsimplemetareply.createtime * 1000));
        this.P = false;
        this.F.setVisibility(com.tencent.biz.subscribe.comment.e.a() ? 8 : 0);
    }

    public void setOnCommentElementClickListener(com.tencent.biz.subscribe.comment.m mVar) {
        this.f80553e = mVar;
    }

    public void setPosition(int i3) {
        this.f80552d = i3;
    }

    public void setReportParams(m mVar, int i3) {
        this.L = mVar;
        this.M = i3;
    }

    public WsReplyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WsReplyView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.P = false;
        g();
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements FeedRichTextView.a {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView.a
        public void b(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            WSProfileFragment.ri(WsReplyView.this.getContext(), str, "at_nick");
            if (WsReplyView.this.L == null) {
                return;
            }
            com.tencent.biz.pubaccount.weishi.report.b.v("comment_at_user", WsReplyView.this.L.e(), WsReplyView.this.L.getPlayScene(), str, WsReplyView.this.M, WsReplyView.this.L.h(), WsReplyView.this.L.g());
        }

        @Override // com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView.a
        public void a(String str) {
        }
    }
}
