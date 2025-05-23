package com.tencent.mobileqq.guild.widget.menu;

import android.graphics.Color;
import androidx.annotation.ColorRes;
import androidx.annotation.IdRes;
import androidx.annotation.StringRes;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 92\u00020\u0001:\u0004\u0005\u000b:\u0007B\u0093\u0001\b\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u000f\u001a\u00020\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0003\u0010\u001a\u001a\u00020\n\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\n\u0012\b\b\u0003\u0010$\u001a\u00020\n\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\n\u0012\b\b\u0003\u0010)\u001a\u00020\n\u0012\b\b\u0002\u0010,\u001a\u00020\n\u0012\b\b\u0002\u0010.\u001a\u00020\n\u0012\b\b\u0002\u00100\u001a\u00020\u0002\u0012\u0014\b\u0002\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000101\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0019R$\u0010 \u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\f\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0019R$\u0010'\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001b\u001a\u0004\b\u0005\u0010\u001d\"\u0004\b&\u0010\u001fR\"\u0010)\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b(\u0010\u0019R\"\u0010,\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\f\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0019R\"\u0010.\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\f\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b-\u0010\u0019R\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b!\u0010\u0012\"\u0004\b/\u0010\u0014R.\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u00102\u001a\u0004\b%\u00103\"\u0004\b4\u00105\u0082\u0001\u0002;<\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/guild/widget/menu/BaseMenuEntry;", "", "", "toString", "Lcom/tencent/mobileqq/guild/widget/menu/BaseMenuEntry$MenuEntryType;", "a", "Lcom/tencent/mobileqq/guild/widget/menu/BaseMenuEntry$MenuEntryType;", "c", "()Lcom/tencent/mobileqq/guild/widget/menu/BaseMenuEntry$MenuEntryType;", "entryType", "", "b", "I", "e", "()I", "id", "Ljava/lang/String;", h.F, "()Ljava/lang/String;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/String;)V", "text", "d", "k", "setTextId", "(I)V", "textId", "Ljava/lang/Integer;", "i", "()Ljava/lang/Integer;", "setTextColor", "(Ljava/lang/Integer;)V", "textColor", "f", "j", "setTextColorId", "textColorId", "g", "setBgColor", "bgColor", "setBgColorId", "bgColorId", "l", "setWidth", "width", "setHeight", "height", "setReportElementId", "reportElementId", "", "Ljava/util/Map;", "()Ljava/util/Map;", "setReportParams", "(Ljava/util/Map;)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "<init>", "(Lcom/tencent/mobileqq/guild/widget/menu/BaseMenuEntry$MenuEntryType;ILjava/lang/String;ILjava/lang/Integer;ILjava/lang/Integer;IIILjava/lang/String;Ljava/util/Map;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "MenuEntryType", "Lcom/tencent/mobileqq/guild/widget/menu/BaseMenuEntry$b;", "Lcom/tencent/mobileqq/guild/widget/menu/BaseMenuEntry$c;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class BaseMenuEntry {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MenuEntryType entryType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String text;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int textId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer textColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int textColorId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer bgColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int backgroundId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int width;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private int height;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String reportElementId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, ? extends Object> reportParams;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/menu/BaseMenuEntry$MenuEntryType;", "", "(Ljava/lang/String;I)V", PatternUtils.NO_MATCH, "DELETE", "SWITCH_INTERACTION", "CONFIRM_DELETE", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum MenuEntryType {
        EMPTY,
        DELETE,
        SWITCH_INTERACTION,
        CONFIRM_DELETE
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/menu/BaseMenuEntry$b;", "Lcom/tencent/mobileqq/guild/widget/menu/BaseMenuEntry;", "", "", "", "reportExtras", "<init>", "(Ljava/util/Map;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends BaseMenuEntry {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(@Nullable Map<String, ? extends Object> map) {
            super(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, 1978, null);
            MenuEntryType menuEntryType = MenuEntryType.DELETE;
            int i3 = 0;
            String str = "\u5220\u9664";
            int i16 = 0;
            Integer num = null;
            int i17 = 0;
            Integer valueOf = Integer.valueOf(Color.parseColor("#F74C30"));
            int i18 = 0;
            int i19 = 0;
            int i26 = 0;
            String str2 = null;
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_menu_action_item", 3);
            if (map != null) {
                hashMap.putAll(map);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u00a2\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/menu/BaseMenuEntry$c;", "Lcom/tencent/mobileqq/guild/widget/menu/BaseMenuEntry;", "", DomainData.DOMAIN_NAME, "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "setReceiveNotification", "(Z)V", "receiveNotification", "", "", "", "reportExtras", "<init>", "(ZLjava/util/Map;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends BaseMenuEntry {

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        private boolean receiveNotification;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c(boolean z16, @Nullable Map<String, ? extends Object> map) {
            super(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, 1978, null);
            String str;
            int i3;
            MenuEntryType menuEntryType = MenuEntryType.SWITCH_INTERACTION;
            int i16 = 0;
            if (z16) {
                str = "\u63a5\u6536\u901a\u77e5";
            } else {
                str = "\u4e0d\u518d\u901a\u77e5";
            }
            int i17 = 0;
            Integer num = null;
            int i18 = 0;
            Integer valueOf = Integer.valueOf(Color.parseColor("#735E5F62"));
            int i19 = 0;
            int i26 = 0;
            int i27 = 0;
            String str2 = null;
            HashMap hashMap = new HashMap();
            if (z16) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            hashMap.put("sgrp_menu_action_item", Integer.valueOf(i3));
            if (map != null) {
                hashMap.putAll(map);
            }
            Unit unit = Unit.INSTANCE;
            this.receiveNotification = z16;
        }

        /* renamed from: m, reason: from getter */
        public final boolean getReceiveNotification() {
            return this.receiveNotification;
        }
    }

    public /* synthetic */ BaseMenuEntry(MenuEntryType menuEntryType, int i3, String str, int i16, Integer num, int i17, Integer num2, int i18, int i19, int i26, String str2, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(menuEntryType, i3, str, i16, num, i17, num2, i18, i19, i26, str2, map);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Integer getBgColor() {
        return this.bgColor;
    }

    /* renamed from: b, reason: from getter */
    public final int getBackgroundId() {
        return this.backgroundId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final MenuEntryType getEntryType() {
        return this.entryType;
    }

    /* renamed from: d, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: e, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getReportElementId() {
        return this.reportElementId;
    }

    @NotNull
    public final Map<String, Object> g() {
        return this.reportParams;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final Integer getTextColor() {
        return this.textColor;
    }

    /* renamed from: j, reason: from getter */
    public final int getTextColorId() {
        return this.textColorId;
    }

    /* renamed from: k, reason: from getter */
    public final int getTextId() {
        return this.textId;
    }

    /* renamed from: l, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    @NotNull
    public String toString() {
        return "BaseMenuEntry(entryType=" + this.entryType + ", id=" + this.id + ", text='" + this.text + "', textId=" + this.textId + ", textColorId=" + this.textColorId + ", backgroundId=" + this.backgroundId + ", width=" + this.width + ", height=" + this.height + ")";
    }

    BaseMenuEntry(MenuEntryType menuEntryType, @IdRes int i3, String str, @StringRes int i16, Integer num, @ColorRes int i17, Integer num2, @ColorRes int i18, int i19, int i26, String str2, Map<String, ? extends Object> map) {
        this.entryType = menuEntryType;
        this.id = i3;
        this.text = str;
        this.textId = i16;
        this.textColor = num;
        this.textColorId = i17;
        this.bgColor = num2;
        this.backgroundId = i18;
        this.width = i19;
        this.height = i26;
        this.reportElementId = str2;
        this.reportParams = map;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ BaseMenuEntry(MenuEntryType menuEntryType, int i3, String str, int i16, Integer num, int i17, Integer num2, int i18, int i19, int i26, String str2, Map map, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, (i27 & 2) != 0 ? r1.ordinal() + 1985229328 : i3, (i27 & 4) != 0 ? null : str, (i27 & 8) != 0 ? R.string.ajx : i16, (i27 & 16) != 0 ? null : num, (i27 & 32) != 0 ? R.color.qui_common_text_allwhite_primary : i17, (i27 & 64) == 0 ? num2 : null, (i27 & 128) != 0 ? R.color.qui_common_feedback_normal : i18, (i27 & 256) != 0 ? (int) cw.c(80.0f) : i19, (i27 & 512) != 0 ? -1 : i26, (i27 & 1024) != 0 ? "em_sgrp_node_slides_left" : str2, (i27 & 2048) != 0 ? new HashMap() : map, null);
        MenuEntryType menuEntryType2 = (i27 & 1) != 0 ? MenuEntryType.EMPTY : menuEntryType;
    }
}
