package bz;

import UserGrowth.stMsgContent;
import UserGrowth.stMsgContentPersonInfo;
import UserGrowth.stNotifyMsg;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
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
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yy.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b3\u00104J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u001c\u0010'\u001a\n $*\u0004\u0018\u00010#0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0014\u0010.\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010)\u00a8\u00065"}, d2 = {"Lbz/d;", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "Lyy/c;", "Landroid/content/Context;", "context", "Lyy/c$a;", "showStyle", "", "i", "", "radiusArray", "j", "data", tl.h.F, "d", "Lyy/c;", "getMsgData", "()Lyy/c;", "setMsgData", "(Lyy/c;)V", AppConstants.Key.COLUMN_MSG_DATA, "Lcom/tencent/biz/pubaccount/weishi/view/WSRoundedImageView;", "e", "Lcom/tencent/biz/pubaccount/weishi/view/WSRoundedImageView;", "rivAvatar", "Lcom/tencent/biz/pubaccount/weishi/richtext/FeedRichTextView;", "f", "Lcom/tencent/biz/pubaccount/weishi/richtext/FeedRichTextView;", "tvName", "tvContent", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tvTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "tvMedal", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/drawable/Drawable;", "placeHolderDrawable", "D", "[F", "allCornerRadius", "E", "topCornerRadius", UserInfo.SEX_FEMALE, "bottomCornerRadius", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "resId", "<init>", "(Landroid/view/ViewGroup;I)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public class d extends BaseViewHolder<yy.c> {

    /* renamed from: C, reason: from kotlin metadata */
    private final Drawable placeHolderDrawable;

    /* renamed from: D, reason: from kotlin metadata */
    private final float[] allCornerRadius;

    /* renamed from: E, reason: from kotlin metadata */
    private final float[] topCornerRadius;

    /* renamed from: F, reason: from kotlin metadata */
    private final float[] bottomCornerRadius;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private yy.c msgData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private WSRoundedImageView rivAvatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FeedRichTextView tvName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FeedRichTextView tvContent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView tvTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView tvMedal;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ViewGroup parent, int i3) {
        super(parent, i3);
        Intrinsics.checkNotNullParameter(parent, "parent");
        View findViewById = this.itemView.findViewById(R.id.p5s);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.ric_msg_avatar)");
        this.rivAvatar = (WSRoundedImageView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.p7p);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_msg_name)");
        this.tvName = (FeedRichTextView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R.id.p7j);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tv_msg_content)");
        this.tvContent = (FeedRichTextView) findViewById3;
        View findViewById4 = this.itemView.findViewById(R.id.p7u);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tv_msg_time)");
        this.tvTime = (TextView) findViewById4;
        View findViewById5 = this.itemView.findViewById(R.id.f163254p44);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.item_msg_medal)");
        this.tvMedal = (TextView) findViewById5;
        this.placeHolderDrawable = getContext().getResources().getDrawable(R.drawable.f160830com);
        int i16 = ba.f81734i;
        this.allCornerRadius = new float[]{i16, i16, i16, i16, i16, i16, i16, i16};
        this.topCornerRadius = new float[]{i16, i16, i16, i16, 0.0f, 0.0f, 0.0f, 0.0f};
        this.bottomCornerRadius = new float[]{0.0f, 0.0f, 0.0f, 0.0f, i16, i16, i16, i16};
        this.rivAvatar.setOnClickListener(new View.OnClickListener() { // from class: bz.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.e(d.this, view);
            }
        });
        this.tvName.setOnClickListener(new View.OnClickListener() { // from class: bz.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.f(d.this, view);
            }
        });
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: bz.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.g(d.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(d this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        xy.h hVar = xy.h.f449023a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        hVar.e(context, this$0.msgData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(d this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        xy.h hVar = xy.h.f449023a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        hVar.e(context, this$0.msgData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(d this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        yy.c cVar = this$0.msgData;
        if (cVar != null) {
            xy.h hVar = xy.h.f449023a;
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            hVar.a(context, cVar);
        }
    }

    private final void i(Context context, c.a showStyle) {
        if (showStyle.e() && showStyle.f() && showStyle.a() && showStyle.b()) {
            j(context, this.allCornerRadius);
        } else if (showStyle.e() && showStyle.f()) {
            j(context, this.topCornerRadius);
        } else if (showStyle.a() && showStyle.b()) {
            j(context, this.bottomCornerRadius);
        } else {
            this.itemView.setBackgroundColor(context.getResources().getColor(R.color.weishi_color_skin_f9f9f9));
        }
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        int d16 = showStyle.d();
        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = LayoutAttrsKt.getDp(d16);
        }
    }

    private final void j(Context context, float[] radiusArray) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(radiusArray);
        gradientDrawable.setColor(context.getResources().getColor(R.color.weishi_color_skin_f9f9f9));
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        com.tencent.mobileqq.mvvm.g.a(itemView, gradientDrawable);
    }

    public void h(yy.c data) {
        c.a b16;
        stNotifyMsg a16;
        super.bindData(data);
        this.msgData = data;
        if (data != null && (a16 = data.a()) != null) {
            WSPicLoader g16 = WSPicLoader.g();
            WSRoundedImageView wSRoundedImageView = this.rivAvatar;
            stMsgContent stmsgcontent = a16.content;
            g16.w(wSRoundedImageView, stmsgcontent != null ? stmsgcontent.icon : null, this.placeHolderDrawable);
            FeedRichTextView feedRichTextView = this.tvName;
            stMsgContent stmsgcontent2 = a16.content;
            feedRichTextView.setText(stmsgcontent2 != null ? stmsgcontent2.title : null);
            FeedRichTextView feedRichTextView2 = this.tvContent;
            stMsgContent stmsgcontent3 = a16.content;
            feedRichTextView2.setText(stmsgcontent3 != null ? stmsgcontent3.content : null);
            this.tvTime.setText(r.z((int) a16.createTime));
            stMsgContentPersonInfo stmsgcontentpersoninfo = a16.oper;
            Boolean valueOf = stmsgcontentpersoninfo != null ? Boolean.valueOf(r.s(stmsgcontentpersoninfo.isFriend)) : null;
            if (valueOf != null) {
                boolean booleanValue = valueOf.booleanValue();
                stMsgContentPersonInfo stmsgcontentpersoninfo2 = a16.oper;
                r.x(this.tvMedal, stmsgcontentpersoninfo2 != null ? stmsgcontentpersoninfo2.metaPersonMedal : 0, booleanValue);
            }
        }
        yy.c cVar = this.msgData;
        if (cVar == null || (b16 = cVar.b()) == null) {
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        i(context, b16);
    }
}
