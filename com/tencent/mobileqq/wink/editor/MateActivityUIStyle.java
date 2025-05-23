package com.tencent.mobileqq.wink.editor;

import android.graphics.Color;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001*B[\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J]\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\u0015\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0016H\u00d6\u0001J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b \u0010\u001eR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b!\u0010\u001eR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\"\u0010\u001eR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010%R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b&\u0010\u001e\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/MateActivityUIStyle;", "Ljava/io/Serializable;", "", "toJson", "", "getBtnPlaceHolderColors", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "templateLibPreviewBtnBg", "templateLibPreviewBtnText", "editNextBtnBg", "editNextBtnText", "publishBtnBg", "publishBtnText", "btnBgColor", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getTemplateLibPreviewBtnBg", "()Ljava/lang/String;", "getTemplateLibPreviewBtnText", "getEditNextBtnBg", "getEditNextBtnText", "getPublishBtnBg", "getPublishBtnText", "setPublishBtnText", "(Ljava/lang/String;)V", "getBtnBgColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class MateActivityUIStyle implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final String btnBgColor;

    @Nullable
    private final String editNextBtnBg;

    @Nullable
    private final String editNextBtnText;

    @Nullable
    private final String publishBtnBg;

    @Nullable
    private String publishBtnText;

    @Nullable
    private final String templateLibPreviewBtnBg;

    @Nullable
    private final String templateLibPreviewBtnText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/MateActivityUIStyle$a;", "", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/wink/editor/MateActivityUIStyle;", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.MateActivityUIStyle$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final MateActivityUIStyle a(@Nullable String s16) {
            Gson gson;
            if (s16 == null) {
                return null;
            }
            try {
                gson = c.f319058a;
                return (MateActivityUIStyle) gson.fromJson(s16, MateActivityUIStyle.class);
            } catch (Throwable th5) {
                w53.b.d("Metamaterial", "deseri activityUIStyle fail " + s16, th5);
                return null;
            }
        }

        Companion() {
        }
    }

    public MateActivityUIStyle() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ MateActivityUIStyle copy$default(MateActivityUIStyle mateActivityUIStyle, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = mateActivityUIStyle.templateLibPreviewBtnBg;
        }
        if ((i3 & 2) != 0) {
            str2 = mateActivityUIStyle.templateLibPreviewBtnText;
        }
        String str8 = str2;
        if ((i3 & 4) != 0) {
            str3 = mateActivityUIStyle.editNextBtnBg;
        }
        String str9 = str3;
        if ((i3 & 8) != 0) {
            str4 = mateActivityUIStyle.editNextBtnText;
        }
        String str10 = str4;
        if ((i3 & 16) != 0) {
            str5 = mateActivityUIStyle.publishBtnBg;
        }
        String str11 = str5;
        if ((i3 & 32) != 0) {
            str6 = mateActivityUIStyle.publishBtnText;
        }
        String str12 = str6;
        if ((i3 & 64) != 0) {
            str7 = mateActivityUIStyle.btnBgColor;
        }
        return mateActivityUIStyle.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @JvmStatic
    @Nullable
    public static final MateActivityUIStyle parseFromString(@Nullable String str) {
        return INSTANCE.a(str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getTemplateLibPreviewBtnBg() {
        return this.templateLibPreviewBtnBg;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getTemplateLibPreviewBtnText() {
        return this.templateLibPreviewBtnText;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getEditNextBtnBg() {
        return this.editNextBtnBg;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getEditNextBtnText() {
        return this.editNextBtnText;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getPublishBtnBg() {
        return this.publishBtnBg;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getPublishBtnText() {
        return this.publishBtnText;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getBtnBgColor() {
        return this.btnBgColor;
    }

    @NotNull
    public final MateActivityUIStyle copy(@Nullable String templateLibPreviewBtnBg, @Nullable String templateLibPreviewBtnText, @Nullable String editNextBtnBg, @Nullable String editNextBtnText, @Nullable String publishBtnBg, @Nullable String publishBtnText, @Nullable String btnBgColor) {
        return new MateActivityUIStyle(templateLibPreviewBtnBg, templateLibPreviewBtnText, editNextBtnBg, editNextBtnText, publishBtnBg, publishBtnText, btnBgColor);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MateActivityUIStyle)) {
            return false;
        }
        MateActivityUIStyle mateActivityUIStyle = (MateActivityUIStyle) other;
        if (Intrinsics.areEqual(this.templateLibPreviewBtnBg, mateActivityUIStyle.templateLibPreviewBtnBg) && Intrinsics.areEqual(this.templateLibPreviewBtnText, mateActivityUIStyle.templateLibPreviewBtnText) && Intrinsics.areEqual(this.editNextBtnBg, mateActivityUIStyle.editNextBtnBg) && Intrinsics.areEqual(this.editNextBtnText, mateActivityUIStyle.editNextBtnText) && Intrinsics.areEqual(this.publishBtnBg, mateActivityUIStyle.publishBtnBg) && Intrinsics.areEqual(this.publishBtnText, mateActivityUIStyle.publishBtnText) && Intrinsics.areEqual(this.btnBgColor, mateActivityUIStyle.btnBgColor)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getBtnBgColor() {
        return this.btnBgColor;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r1, new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null);
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int[] getBtnPlaceHolderColors() {
        List split$default;
        int collectionSizeOrDefault;
        int[] intArray;
        try {
            String str = this.btnBgColor;
            if (str == null || split$default == null) {
                return null;
            }
            List list = split$default;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(Color.parseColor((String) it.next())));
            }
            intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
            return intArray;
        } catch (Exception e16) {
            w53.b.d("Metamaterial", "parse BtnPlaceHolderColors ", e16);
            return null;
        }
    }

    @Nullable
    public final String getEditNextBtnBg() {
        return this.editNextBtnBg;
    }

    @Nullable
    public final String getEditNextBtnText() {
        return this.editNextBtnText;
    }

    @Nullable
    public final String getPublishBtnBg() {
        return this.publishBtnBg;
    }

    @Nullable
    public final String getPublishBtnText() {
        return this.publishBtnText;
    }

    @Nullable
    public final String getTemplateLibPreviewBtnBg() {
        return this.templateLibPreviewBtnBg;
    }

    @Nullable
    public final String getTemplateLibPreviewBtnText() {
        return this.templateLibPreviewBtnText;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        String str = this.templateLibPreviewBtnBg;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.templateLibPreviewBtnText;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.editNextBtnBg;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.editNextBtnText;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str5 = this.publishBtnBg;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str6 = this.publishBtnText;
        if (str6 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str6.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        String str7 = this.btnBgColor;
        if (str7 != null) {
            i3 = str7.hashCode();
        }
        return i27 + i3;
    }

    public final void setPublishBtnText(@Nullable String str) {
        this.publishBtnText = str;
    }

    @Nullable
    public final String toJson() {
        try {
            return new Gson().toJson(this).toString();
        } catch (Exception e16) {
            w53.b.d("Metamaterial", "MateActivityUIStyle toJson ", e16);
            return null;
        }
    }

    @NotNull
    public String toString() {
        return "MateActivityUIStyle(templateLibPreviewBtnBg=" + this.templateLibPreviewBtnBg + ", templateLibPreviewBtnText=" + this.templateLibPreviewBtnText + ", editNextBtnBg=" + this.editNextBtnBg + ", editNextBtnText=" + this.editNextBtnText + ", publishBtnBg=" + this.publishBtnBg + ", publishBtnText=" + this.publishBtnText + ", btnBgColor=" + this.btnBgColor + ")";
    }

    public MateActivityUIStyle(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        this.templateLibPreviewBtnBg = str;
        this.templateLibPreviewBtnText = str2;
        this.editNextBtnBg = str3;
        this.editNextBtnText = str4;
        this.publishBtnBg = str5;
        this.publishBtnText = str6;
        this.btnBgColor = str7;
    }

    public /* synthetic */ MateActivityUIStyle(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : str5, (i3 & 32) != 0 ? null : str6, (i3 & 64) != 0 ? null : str7);
    }
}
