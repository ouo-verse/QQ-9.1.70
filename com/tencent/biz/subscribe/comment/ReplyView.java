package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StReply;
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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ReplyView extends RelativeLayout implements View.OnClickListener, View.OnLongClickListener {
    private static final String M = "com.tencent.biz.subscribe.comment.ReplyView";
    AsyncRichTextView C;
    TextView D;
    ImageView E;
    TextView F;
    LinearLayout G;
    private CertifiedAccountMeta$StComment H;
    private CertifiedAccountMeta$StReply I;
    private Drawable J;
    private boolean K;
    private BitmapDrawable L;

    /* renamed from: d, reason: collision with root package name */
    private final String f95949d;

    /* renamed from: e, reason: collision with root package name */
    private int f95950e;

    /* renamed from: f, reason: collision with root package name */
    private m f95951f;

    /* renamed from: h, reason: collision with root package name */
    RoundCornerImageView f95952h;

    /* renamed from: i, reason: collision with root package name */
    TextView f95953i;

    /* renamed from: m, reason: collision with root package name */
    TextView f95954m;

    public ReplyView(Context context) {
        this(context, null);
    }

    private void a() {
        this.f95952h.setOnClickListener(this);
        this.f95953i.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.f95954m.setOnClickListener(this);
        this.G.setOnClickListener(this);
        setOnClickListener(this);
        this.C.setOnLongClickListener(this);
        setOnLongClickListener(this);
    }

    private String b(String str, String str2) {
        try {
            str2 = URLEncoder.encode(str2, "UTF-8");
        } catch (Exception e16) {
            QLog.e(M, 1, "build nickname partially failed" + e16);
        }
        return "<uin:" + str + ",nickname:" + str2 + ">";
    }

    private void c() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f167716ew, (ViewGroup) this, true);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) inflate.findViewById(R.id.f165909du3);
        this.f95952h = roundCornerImageView;
        roundCornerImageView.setCorner(ImmersiveUtils.dpToPx(18.0f));
        this.f95953i = (TextView) inflate.findViewById(R.id.i7u);
        AsyncRichTextView asyncRichTextView = (AsyncRichTextView) inflate.findViewById(R.id.i7s);
        this.C = asyncRichTextView;
        asyncRichTextView.setNeedParseColor(true);
        this.D = (TextView) inflate.findViewById(R.id.i7t);
        this.f95954m = (TextView) inflate.findViewById(R.id.ajf);
        this.G = (LinearLayout) inflate.findViewById(R.id.i7o);
        this.E = (ImageView) inflate.findViewById(R.id.i7n);
        this.F = (TextView) inflate.findViewById(R.id.i7p);
        setPadding(0, 0, 0, Utils.dp2px(5.0d));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m mVar;
        CertifiedAccountMeta$StReply certifiedAccountMeta$StReply;
        CertifiedAccountMeta$StReply certifiedAccountMeta$StReply2;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f165909du3) {
            m mVar2 = this.f95951f;
            if (mVar2 != null && (certifiedAccountMeta$StReply2 = this.I) != null) {
                mVar2.onClick(view, 1, this.f95950e, certifiedAccountMeta$StReply2.postUser);
            }
        } else if (id5 == R.id.i7u) {
            m mVar3 = this.f95951f;
            if (mVar3 != null && (certifiedAccountMeta$StReply = this.I) != null) {
                mVar3.onClick(view, 2, this.f95950e, certifiedAccountMeta$StReply.postUser);
            }
        } else if (id5 == R.id.i7s) {
            m mVar4 = this.f95951f;
            if (mVar4 != null) {
                mVar4.onClick(view, 7, this.f95950e, new Object[]{this.H, this.I});
            }
        } else if (id5 != R.id.i7o && (((view instanceof ReplyView) || view.getId() == R.id.ajf) && (mVar = this.f95951f) != null)) {
            mVar.onClick(view, 7, this.f95950e, new Object[]{this.H, this.I});
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        boolean z16 = false;
        if (view.getId() == R.id.i7s) {
            m mVar = this.f95951f;
            if (mVar != null) {
                mVar.onLongClick(view, 8, this.f95950e, new Object[]{this.H, this.I});
            }
            z16 = true;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    public void setData(CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply, String str) {
        this.H = certifiedAccountMeta$StComment;
        this.I = certifiedAccountMeta$StReply;
        if (certifiedAccountMeta$StComment != null && certifiedAccountMeta$StReply != null) {
            int i3 = 0;
            if (certifiedAccountMeta$StReply.postUser != null) {
                if (BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(certifiedAccountMeta$StReply.postUser.f24929id.get()) && StringUtil.isEmpty(certifiedAccountMeta$StReply.postUser.icon.get())) {
                    if (this.L == null) {
                        this.L = new BitmapDrawable(BaseImageUtil.getRoundFaceBitmap(k.a(k.b(null, 1, certifiedAccountMeta$StReply.postUser.f24929id.get(), 0)).f306778a, 50, 50));
                    }
                    UIUtils.q(this.f95952h, "", UIUtils.b(getContext(), 35.0f), UIUtils.b(getContext(), 35.0f), UIUtils.b(getContext(), 18.0f), this.L, null);
                } else {
                    UIUtils.q(this.f95952h, certifiedAccountMeta$StReply.postUser.icon.get(), UIUtils.b(getContext(), 22.0f), UIUtils.b(getContext(), 22.0f), UIUtils.b(getContext(), 11.0f), BaseImageUtil.getDefaultFaceDrawable(), null);
                }
                this.f95953i.setText(certifiedAccountMeta$StReply.postUser.nick.get());
                if (certifiedAccountMeta$StReply.postUser.f24929id.get().equals(str)) {
                    if (this.J == null) {
                        Drawable drawable = getResources().getDrawable(R.drawable.h8k);
                        this.J = drawable;
                        drawable.setBounds(0, 0, ImmersiveUtils.dpToPx(21.0f), ImmersiveUtils.dpToPx(12.0f));
                    }
                    this.f95953i.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(2.0f));
                    this.f95953i.setCompoundDrawables(null, null, this.J, null);
                } else {
                    this.f95953i.setCompoundDrawables(null, null, null, null);
                }
            }
            StringBuilder sb5 = new StringBuilder();
            if (certifiedAccountMeta$StReply.targetUser != null && !certifiedAccountMeta$StComment.postUser.f24929id.get().equals(certifiedAccountMeta$StReply.targetUser.f24929id.get())) {
                sb5.append("{text:");
                sb5.append(this.f95949d);
                sb5.append(",color:");
                sb5.append(Integer.toHexString(getResources().getColor(R.color.ahl)));
                sb5.append(",useDefaultFont:1,useSuperFont:0}");
                sb5.append(b(certifiedAccountMeta$StReply.targetUser.f24929id.get(), certifiedAccountMeta$StReply.targetUser.nick.get()));
                sb5.append("{text:");
                sb5.append("\uff1a");
                sb5.append(",color:");
                sb5.append(Integer.toHexString(getResources().getColor(R.color.ahm)));
                sb5.append(",useDefaultFont:1,useSuperFont:0}");
            }
            sb5.append(certifiedAccountMeta$StReply.content.get());
            this.C.setText(sb5);
            this.D.setText(f.a(certifiedAccountMeta$StReply.createTime.get() * 1000));
            this.K = false;
            LinearLayout linearLayout = this.G;
            if (e.a()) {
                i3 = 8;
            }
            linearLayout.setVisibility(i3);
        }
    }

    public void setOnCommentElementClickListener(m mVar) {
        this.f95951f = mVar;
    }

    public void setPosition(int i3) {
        this.f95950e = i3;
    }

    public ReplyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ReplyView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f95949d = HardCodeUtil.qqStr(R.string.t0u);
        this.K = false;
        c();
        a();
    }
}
