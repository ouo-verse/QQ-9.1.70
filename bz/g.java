package bz;

import UserGrowth.stMsgContent;
import UserGrowth.stMsgContentPersonInfo;
import UserGrowth.stNotifyMsg;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.view.WSRoundedImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yy.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\n \"*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lbz/g;", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "Lyy/c;", "", "g", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "i", "j", "k", tl.h.F, "data", "f", "d", "Lyy/c;", AppConstants.Key.COLUMN_MSG_DATA, "Lcom/tencent/biz/pubaccount/weishi/view/WSRoundedImageView;", "e", "Lcom/tencent/biz/pubaccount/weishi/view/WSRoundedImageView;", "avatarView", "Lcom/tencent/biz/pubaccount/weishi/richtext/FeedRichTextView;", "Lcom/tencent/biz/pubaccount/weishi/richtext/FeedRichTextView;", "tvFansName", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tvFansTime", "tvFansHasFollowed", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "tvFansFollow", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "ivRight", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "D", "Landroid/graphics/drawable/Drawable;", "placeHolderDrawable", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class g extends BaseViewHolder<yy.c> {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView ivRight;

    /* renamed from: D, reason: from kotlin metadata */
    private final Drawable placeHolderDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private yy.c msgData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private WSRoundedImageView avatarView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FeedRichTextView tvFansName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView tvFansTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView tvFansHasFollowed;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView tvFansFollow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(ViewGroup parent) {
        super(parent, R.layout.f167384d13);
        Intrinsics.checkNotNullParameter(parent, "parent");
        View findViewById = this.itemView.findViewById(R.id.p5t);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.riv_fans_avatar)");
        this.avatarView = (WSRoundedImageView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.p7b);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_fans_name)");
        this.tvFansName = (FeedRichTextView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R.id.p7c);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tv_fans_time)");
        this.tvFansTime = (TextView) findViewById3;
        View findViewById4 = this.itemView.findViewById(R.id.p7a);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tv_fans_has_followed)");
        this.tvFansHasFollowed = (TextView) findViewById4;
        View findViewById5 = this.itemView.findViewById(R.id.p7_);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.tv_fans_follow)");
        this.tvFansFollow = (TextView) findViewById5;
        View findViewById6 = this.itemView.findViewById(R.id.p48);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.iv_arrow_right)");
        this.ivRight = (ImageView) findViewById6;
        this.placeHolderDrawable = getContext().getResources().getDrawable(R.drawable.f160830com);
        GradientDrawable a16 = ba.a(getContext().getResources().getColor(R.color.f77958), ba.f81736k);
        Intrinsics.checkNotNullExpressionValue(a16, "createRoundRectangleDraw\u2026IUtil.PIX_14DP.toFloat())");
        com.tencent.mobileqq.mvvm.g.a(this.tvFansFollow, a16);
        this.tvFansFollow.setOnClickListener(new View.OnClickListener() { // from class: bz.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.d(g.this, view);
            }
        });
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: bz.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.e(g.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(g this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(g this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        xy.h hVar = xy.h.f449023a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        hVar.e(context, this$0.msgData);
    }

    private final void g() {
        stNotifyMsg a16;
        stMsgContentPersonInfo stmsgcontentpersoninfo;
        stNotifyMsg a17;
        stMsgContentPersonInfo stmsgcontentpersoninfo2;
        if (!com.tencent.biz.common.util.g.b(BaseApplication.getContext())) {
            ToastUtil.a().b(R.string.f242037th);
            return;
        }
        jz.g e16 = jz.g.e();
        yy.c cVar = this.msgData;
        e16.c((cVar == null || (a17 = cVar.a()) == null || (stmsgcontentpersoninfo2 = a17.oper) == null) ? null : stmsgcontentpersoninfo2.PID, 1);
        yy.c cVar2 = this.msgData;
        c.a b16 = cVar2 != null ? cVar2.b() : null;
        if (b16 != null) {
            b16.g(1);
        }
        j();
        yy.c cVar3 = this.msgData;
        String str = (cVar3 == null || (a16 = cVar3.a()) == null || (stmsgcontentpersoninfo = a16.oper) == null) ? null : stmsgcontentpersoninfo.PID;
        if (str == null) {
            str = "";
        }
        yy.c cVar4 = this.msgData;
        xy.b.c(str, String.valueOf(cVar4 != null ? Integer.valueOf(cVar4.f()) : null));
    }

    private final void h() {
        this.tvFansHasFollowed.setVisibility(8);
        this.tvFansFollow.setVisibility(0);
        this.ivRight.setVisibility(8);
    }

    private final void j() {
        this.tvFansHasFollowed.setVisibility(0);
        this.tvFansFollow.setVisibility(8);
        this.ivRight.setVisibility(8);
    }

    private final void k() {
        this.tvFansHasFollowed.setVisibility(8);
        this.tvFansFollow.setVisibility(8);
        this.ivRight.setVisibility(0);
        this.ivRight.setImageDrawable(ba.l(R.drawable.gju));
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void bindData(yy.c data) {
        stMsgContent stmsgcontent;
        stMsgContent stmsgcontent2;
        Intrinsics.checkNotNullParameter(data, "data");
        super.bindData(data);
        this.msgData = data;
        WSPicLoader g16 = WSPicLoader.g();
        WSRoundedImageView wSRoundedImageView = this.avatarView;
        stNotifyMsg a16 = data.a();
        g16.w(wSRoundedImageView, (a16 == null || (stmsgcontent2 = a16.content) == null) ? null : stmsgcontent2.icon, this.placeHolderDrawable);
        FeedRichTextView feedRichTextView = this.tvFansName;
        stNotifyMsg a17 = data.a();
        feedRichTextView.setText((a17 == null || (stmsgcontent = a17.content) == null) ? null : stmsgcontent.title);
        TextView textView = this.tvFansTime;
        stNotifyMsg a18 = data.a();
        textView.setText(a18 != null ? r.z((int) a18.createTime) : null);
        i(data.b().c());
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        int d16 = data.b().d();
        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = LayoutAttrsKt.getDp(d16);
        }
    }

    private final void i(int showType) {
        if (showType == 1) {
            j();
        } else if (showType != 3) {
            k();
        } else {
            h();
        }
    }
}
