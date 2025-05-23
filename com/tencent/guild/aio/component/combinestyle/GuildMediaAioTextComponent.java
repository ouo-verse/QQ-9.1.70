package com.tencent.guild.aio.component.combinestyle;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.media.aio.ab;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u00c7\u0001\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010%\u001a\u00020\u0015\u0012\b\b\u0002\u0010*\u001a\u00020\f\u0012\b\b\u0002\u0010-\u001a\u00020\f\u0012\b\b\u0002\u00100\u001a\u00020\f\u0012:\b\u0002\u0010:\u001a4\u0012\u0013\u0012\u001102\u00a2\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u000e\u0018\u000101\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0010\u0012,\b\u0002\u0010B\u001a&\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010=j\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u0001`>\u0012\b\b\u0002\u0010D\u001a\u00020\u0015\u00a2\u0006\u0004\bE\u0010FJ8\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\t\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010 \u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010%\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010*\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010-\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010)R\u0017\u00100\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b.\u0010'\u001a\u0004\b/\u0010)RI\u0010:\u001a4\u0012\u0013\u0012\u001102\u00a2\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u000e\u0018\u0001018\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b!\u00109R\u0019\u0010<\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b;\u0010\u0018\u001a\u0004\b&\u0010\u001aR;\u0010B\u001a&\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010=j\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u0001`>8\u0006\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b+\u0010AR\u0017\u0010D\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\bC\u0010\"\u001a\u0004\bD\u0010$\u00a8\u0006G"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/j;", "Lcom/tencent/guild/aio/component/combinestyle/ac;", "Landroid/widget/ImageView;", "imageView", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Landroid/text/SpannableStringBuilder;", "spannedString", "Landroid/widget/TextView;", "textView", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "combineStyleAioItem", "", WadlProxyConsts.FLAGS, "", "b", "", "toString", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "content", "Lcom/tencent/guild/aio/component/combinestyle/aj;", "Lcom/tencent/guild/aio/component/combinestyle/aj;", "getClickTextColorStrategy", "()Lcom/tencent/guild/aio/component/combinestyle/aj;", "clickTextColorStrategy", "c", "Z", "getEnableClick", "()Z", "enableClick", "d", "I", "getBgColor", "()I", "bgColor", "e", "getBgRadius", "bgRadius", "f", "getTextSize", "textSize", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "handleText", "g", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "clickCallback", tl.h.F, "reportElementId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "i", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "reportParamMap", "j", "isBoldText", "<init>", "(Ljava/lang/String;Lcom/tencent/guild/aio/component/combinestyle/aj;ZIIILkotlin/jvm/functions/Function2;Ljava/lang/String;Ljava/util/HashMap;Z)V", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.guild.aio.component.combinestyle.j, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class GuildMediaAioTextComponent implements ac {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String content;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final aj clickTextColorStrategy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enableClick;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int bgColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int bgRadius;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int textSize;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Function2<View, aa, Unit> clickCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String reportElementId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final HashMap<String, Object> reportParamMap;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isBoldText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/component/combinestyle/j$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.component.combinestyle.j$a */
    /* loaded from: classes6.dex */
    public static final class a extends ClickableSpan {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ aa f110250e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextView f110251f;

        a(aa aaVar, TextView textView) {
            this.f110250e = aaVar;
            this.f110251f = textView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            if (GuildMediaAioTextComponent.this.getReportElementId() != null) {
                TextView textView = this.f110251f;
                GuildMediaAioTextComponent guildMediaAioTextComponent = GuildMediaAioTextComponent.this;
                IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
                String reportElementId = guildMediaAioTextComponent.getReportElementId();
                HashMap<String, Object> e16 = guildMediaAioTextComponent.e();
                if (e16 == null) {
                    e16 = new HashMap<>();
                }
                iGuildDTReportApi.reportDtEventManual(textView, reportElementId, "clck", e16);
            }
            Function2<View, aa, Unit> c16 = GuildMediaAioTextComponent.this.c();
            if (c16 != null) {
                c16.invoke(widget, this.f110250e);
            }
        }
    }

    public GuildMediaAioTextComponent() {
        this(null, null, false, 0, 0, 0, null, null, null, false, 1023, null);
    }

    @Override // com.tencent.guild.aio.component.combinestyle.ac
    public void b(@NotNull ImageView imageView, @NotNull GuildMsgItem msgItem, @NotNull SpannableStringBuilder spannedString, @NotNull TextView textView, @NotNull aa combineStyleAioItem, int flags) {
        int color;
        int i3;
        int i16;
        Object cVar;
        int i17;
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(spannedString, "spannedString");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(combineStyleAioItem, "combineStyleAioItem");
        int length = spannedString.length();
        String str = this.content;
        if (str == null) {
            str = "";
        }
        spannedString.insert(length, (CharSequence) str);
        aj ajVar = this.clickTextColorStrategy;
        if (ajVar != null) {
            color = ajVar.a(combineStyleAioItem);
        } else {
            color = textView.getResources().getColor(R.color.f157146bq2);
        }
        int i18 = color;
        if (this.enableClick) {
            spannedString.setSpan(new a(combineStyleAioItem, textView), length, spannedString.length(), 17);
            spannedString.setSpan(new NoUnderlineSpan(), length, spannedString.length(), 17);
            if (this.bgColor != -1 && this.bgRadius > 0) {
                int i19 = this.bgColor;
                int i26 = this.bgRadius;
                int i27 = this.textSize;
                if (i27 > 0) {
                    i17 = i27;
                } else {
                    i17 = 0;
                }
                cVar = new com.tencent.mobileqq.guild.media.aio.ab(new ab.SpanBuilder(i19, 0, 0, -1, i26, 0, 0, i17, 102, null));
            } else {
                int i28 = this.bgColor;
                if (i28 != -1) {
                    i3 = i28;
                } else {
                    i3 = 0;
                }
                int i29 = this.bgRadius;
                if (i29 < 0) {
                    i16 = 0;
                } else {
                    i16 = i29;
                }
                cVar = new com.tencent.mobileqq.guild.media.aio.c(i3, i18, i16, textView, length, spannedString.length());
            }
            spannedString.setSpan(cVar, length, spannedString.length(), 17);
        } else {
            spannedString.setSpan(new ForegroundColorSpan(i18), length, spannedString.length(), 17);
        }
        if (this.textSize > 0) {
            spannedString.setSpan(new AbsoluteSizeSpan(this.textSize, false), length, spannedString.length(), 17);
        }
        if (this.isBoldText) {
            spannedString.setSpan(new StyleSpan(1), length, spannedString.length(), 17);
        }
    }

    @Nullable
    public final Function2<View, aa, Unit> c() {
        return this.clickCallback;
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
        if (!(other instanceof GuildMediaAioTextComponent)) {
            return false;
        }
        GuildMediaAioTextComponent guildMediaAioTextComponent = (GuildMediaAioTextComponent) other;
        if (Intrinsics.areEqual(this.content, guildMediaAioTextComponent.content) && Intrinsics.areEqual(this.clickTextColorStrategy, guildMediaAioTextComponent.clickTextColorStrategy) && this.enableClick == guildMediaAioTextComponent.enableClick && this.bgColor == guildMediaAioTextComponent.bgColor && this.bgRadius == guildMediaAioTextComponent.bgRadius && this.textSize == guildMediaAioTextComponent.textSize && Intrinsics.areEqual(this.clickCallback, guildMediaAioTextComponent.clickCallback) && Intrinsics.areEqual(this.reportElementId, guildMediaAioTextComponent.reportElementId) && Intrinsics.areEqual(this.reportParamMap, guildMediaAioTextComponent.reportParamMap) && this.isBoldText == guildMediaAioTextComponent.isBoldText) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        String str = this.content;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        aj ajVar = this.clickTextColorStrategy;
        if (ajVar == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = ajVar.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        boolean z16 = this.enableClick;
        int i18 = 1;
        int i19 = z16;
        if (z16 != 0) {
            i19 = 1;
        }
        int i26 = (((((((i17 + i19) * 31) + this.bgColor) * 31) + this.bgRadius) * 31) + this.textSize) * 31;
        Function2<View, aa, Unit> function2 = this.clickCallback;
        if (function2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = function2.hashCode();
        }
        int i27 = (i26 + hashCode3) * 31;
        String str2 = this.reportElementId;
        if (str2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str2.hashCode();
        }
        int i28 = (i27 + hashCode4) * 31;
        HashMap<String, Object> hashMap = this.reportParamMap;
        if (hashMap != null) {
            i3 = hashMap.hashCode();
        }
        int i29 = (i28 + i3) * 31;
        boolean z17 = this.isBoldText;
        if (!z17) {
            i18 = z17 ? 1 : 0;
        }
        return i29 + i18;
    }

    @NotNull
    public String toString() {
        return "GuildMediaAioTextComponent(content=" + this.content + ", clickTextColorStrategy=" + this.clickTextColorStrategy + ", enableClick=" + this.enableClick + ", bgColor=" + this.bgColor + ", bgRadius=" + this.bgRadius + ", textSize=" + this.textSize + ", clickCallback=" + this.clickCallback + ", reportElementId=" + this.reportElementId + ", reportParamMap=" + this.reportParamMap + ", isBoldText=" + this.isBoldText + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildMediaAioTextComponent(@Nullable String str, @Nullable aj ajVar, boolean z16, int i3, int i16, int i17, @Nullable Function2<? super View, ? super aa, Unit> function2, @Nullable String str2, @Nullable HashMap<String, Object> hashMap, boolean z17) {
        this.content = str;
        this.clickTextColorStrategy = ajVar;
        this.enableClick = z16;
        this.bgColor = i3;
        this.bgRadius = i16;
        this.textSize = i17;
        this.clickCallback = function2;
        this.reportElementId = str2;
        this.reportParamMap = hashMap;
        this.isBoldText = z17;
    }

    public /* synthetic */ GuildMediaAioTextComponent(String str, aj ajVar, boolean z16, int i3, int i16, int i17, Function2 function2, String str2, HashMap hashMap, boolean z17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? null : str, (i18 & 2) != 0 ? null : ajVar, (i18 & 4) != 0 ? false : z16, (i18 & 8) != 0 ? -1 : i3, (i18 & 16) != 0 ? 0 : i16, (i18 & 32) == 0 ? i17 : -1, (i18 & 64) != 0 ? null : function2, (i18 & 128) != 0 ? null : str2, (i18 & 256) == 0 ? hashMap : null, (i18 & 512) == 0 ? z17 : false);
    }
}
