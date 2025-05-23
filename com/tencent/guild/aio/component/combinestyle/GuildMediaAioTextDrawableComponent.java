package com.tencent.guild.aio.component.combinestyle;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.ImageNode;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\b\b\u0002\u0010%\u001a\u00020\u0015\u0012:\b\u0002\u0010/\u001a4\u0012\u0013\u0012\u00110'\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u000e\u0018\u00010&\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0010\u00120\b\u0002\u00109\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u000104j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u0001`5\u00a2\u0006\u0004\b:\u0010;J8\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\t\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010 \u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010%\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$RI\u0010/\u001a4\u0012\u0013\u0012\u00110'\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u000e\u0018\u00010&8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b!\u0010.R\u0019\u00103\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b,\u00102R?\u00109\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u000104j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u0001`58\u0006\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b0\u00108\u00a8\u0006<"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/k;", "Lcom/tencent/guild/aio/component/combinestyle/ac;", "Landroid/widget/ImageView;", "imageView", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Landroid/text/SpannableStringBuilder;", "spannedString", "Landroid/widget/TextView;", "textView", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "combineStyleAioItem", "", WadlProxyConsts.FLAGS, "", "b", "", "toString", "hashCode", "", "other", "", "equals", "Lcom/tencent/guild/aio/component/combinestyle/ah;", "a", "Lcom/tencent/guild/aio/component/combinestyle/ah;", "getLoadImageStrategy", "()Lcom/tencent/guild/aio/component/combinestyle/ah;", "loadImageStrategy", "I", "getVerticalAlignment", "()I", ImageNode.PROP_VERTICAL_ALIGNMENT, "c", "Z", "getEnableClick", "()Z", "enableClick", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "handleText", "d", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "callback", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "reportElementId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "f", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "reportParamMap", "<init>", "(Lcom/tencent/guild/aio/component/combinestyle/ah;IZLkotlin/jvm/functions/Function2;Ljava/lang/String;Ljava/util/HashMap;)V", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.guild.aio.component.combinestyle.k, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class GuildMediaAioTextDrawableComponent implements ac {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ah loadImageStrategy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int verticalAlignment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enableClick;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Function2<View, aa, Unit> callback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String reportElementId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final HashMap<String, Object> reportParamMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/component/combinestyle/k$a", "Lcom/tencent/guild/aio/component/combinestyle/ag;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "onLoaded", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.component.combinestyle.k$a */
    /* loaded from: classes6.dex */
    public static final class a implements ag {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.media.aio.ac f110258a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f110259b;

        a(com.tencent.mobileqq.guild.media.aio.ac acVar, TextView textView) {
            this.f110258a = acVar;
            this.f110259b = textView;
        }

        @Override // com.tencent.guild.aio.component.combinestyle.ag
        public void onLoaded(@NotNull Drawable drawable) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            this.f110258a.a(drawable);
            this.f110259b.invalidate();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/component/combinestyle/k$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.component.combinestyle.k$b */
    /* loaded from: classes6.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ aa f110261e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextView f110262f;

        b(aa aaVar, TextView textView) {
            this.f110261e = aaVar;
            this.f110262f = textView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            if (GuildMediaAioTextDrawableComponent.this.getReportElementId() != null) {
                TextView textView = this.f110262f;
                GuildMediaAioTextDrawableComponent guildMediaAioTextDrawableComponent = GuildMediaAioTextDrawableComponent.this;
                IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
                String reportElementId = guildMediaAioTextDrawableComponent.getReportElementId();
                HashMap<String, Object> e16 = guildMediaAioTextDrawableComponent.e();
                if (e16 == null) {
                    e16 = new HashMap<>();
                }
                iGuildDTReportApi.reportDtEventManual(textView, reportElementId, "clck", e16);
            }
            Function2<View, aa, Unit> c16 = GuildMediaAioTextDrawableComponent.this.c();
            if (c16 != null) {
                c16.invoke(widget, this.f110261e);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildMediaAioTextDrawableComponent(@NotNull ah loadImageStrategy, int i3, boolean z16, @Nullable Function2<? super View, ? super aa, Unit> function2, @Nullable String str, @Nullable HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(loadImageStrategy, "loadImageStrategy");
        this.loadImageStrategy = loadImageStrategy;
        this.verticalAlignment = i3;
        this.enableClick = z16;
        this.callback = function2;
        this.reportElementId = str;
        this.reportParamMap = hashMap;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.ac
    public void b(@NotNull ImageView imageView, @NotNull GuildMsgItem msgItem, @NotNull SpannableStringBuilder spannedString, @NotNull TextView textView, @NotNull aa combineStyleAioItem, int flags) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(spannedString, "spannedString");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(combineStyleAioItem, "combineStyleAioItem");
        int length = spannedString.length();
        spannedString.insert(length, "dr");
        Drawable defaultDrawable = this.loadImageStrategy.getDefaultDrawable();
        if (defaultDrawable == null) {
            defaultDrawable = ResourcesCompat.getDrawable(BaseApplication.context.getResources(), R.color.ajr, null);
        }
        com.tencent.mobileqq.guild.media.aio.ac acVar = new com.tencent.mobileqq.guild.media.aio.ac(defaultDrawable, this.verticalAlignment);
        spannedString.setSpan(acVar, length, spannedString.length(), 17);
        if (this.enableClick) {
            spannedString.setSpan(new b(combineStyleAioItem, textView), length, spannedString.length(), 17);
        }
        ah ahVar = this.loadImageStrategy;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "textView.context");
        ahVar.a(context, new a(acVar, textView));
    }

    @Nullable
    public final Function2<View, aa, Unit> c() {
        return this.callback;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getReportElementId() {
        return this.reportElementId;
    }

    @Nullable
    public final HashMap<String, Object> e() {
        return this.reportParamMap;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMediaAioTextDrawableComponent)) {
            return false;
        }
        GuildMediaAioTextDrawableComponent guildMediaAioTextDrawableComponent = (GuildMediaAioTextDrawableComponent) other;
        if (Intrinsics.areEqual(this.loadImageStrategy, guildMediaAioTextDrawableComponent.loadImageStrategy) && this.verticalAlignment == guildMediaAioTextDrawableComponent.verticalAlignment && this.enableClick == guildMediaAioTextDrawableComponent.enableClick && Intrinsics.areEqual(this.callback, guildMediaAioTextDrawableComponent.callback) && Intrinsics.areEqual(this.reportElementId, guildMediaAioTextDrawableComponent.reportElementId) && Intrinsics.areEqual(this.reportParamMap, guildMediaAioTextDrawableComponent.reportParamMap)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = ((this.loadImageStrategy.hashCode() * 31) + this.verticalAlignment) * 31;
        boolean z16 = this.enableClick;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode3 + i3) * 31;
        Function2<View, aa, Unit> function2 = this.callback;
        int i17 = 0;
        if (function2 == null) {
            hashCode = 0;
        } else {
            hashCode = function2.hashCode();
        }
        int i18 = (i16 + hashCode) * 31;
        String str = this.reportElementId;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i19 = (i18 + hashCode2) * 31;
        HashMap<String, Object> hashMap = this.reportParamMap;
        if (hashMap != null) {
            i17 = hashMap.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "GuildMediaAioTextDrawableComponent(loadImageStrategy=" + this.loadImageStrategy + ", verticalAlignment=" + this.verticalAlignment + ", enableClick=" + this.enableClick + ", callback=" + this.callback + ", reportElementId=" + this.reportElementId + ", reportParamMap=" + this.reportParamMap + ")";
    }

    public /* synthetic */ GuildMediaAioTextDrawableComponent(ah ahVar, int i3, boolean z16, Function2 function2, String str, HashMap hashMap, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(ahVar, (i16 & 2) != 0 ? 1 : i3, (i16 & 4) != 0 ? false : z16, (i16 & 8) != 0 ? null : function2, (i16 & 16) != 0 ? null : str, (i16 & 32) != 0 ? null : hashMap);
    }
}
