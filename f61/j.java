package f61;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.qqnt.aio.utils.ViewUtils;
import f61.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.oidb_0x1250.oidb_0x1250$PartnerInfo;
import tencent.im.oidb.oidb_0x1250.oidb_0x1250$PartnerLightInteraction;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 *2\u00020\u0001:\u0001\u0005Ba\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001a\u0012\b\b\u0002\u0010#\u001a\u00020 \u0012\b\b\u0002\u0010%\u001a\u00020\u0015\u0012\b\b\u0002\u0010'\u001a\u00020\u0004\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010#\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010!\u001a\u0004\b\u001b\u0010\"R\u0017\u0010%\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b$\u0010\u0018R\u0017\u0010'\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0006\u001a\u0004\b&\u0010\b\u00a8\u0006+"}, d2 = {"Lf61/j;", "", "", "toString", "", "a", "J", "c", "()J", "id", "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "name", "iconUrl", "Lf61/k;", "d", "Lf61/k;", "()Lf61/k;", "interactionEntryInfo", "", "Z", tl.h.F, "()Z", "isBind", "", "f", "Ljava/lang/CharSequence;", "g", "()Ljava/lang/CharSequence;", "statusIntro", "", "I", "()I", "status", "i", "isNew", "getNewTime", "newTime", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lf61/k;ZLjava/lang/CharSequence;IZJ)V", "j", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class j {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String iconUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final k interactionEntryInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isBind;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final CharSequence statusIntro;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int status;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isNew;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final long newTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\f"}, d2 = {"Lf61/j$a;", "", "", "statusIntro", "Landroid/text/SpannableStringBuilder;", "b", "Ltencent/im/oidb/oidb_0x1250/oidb_0x1250$PartnerInfo;", "partnerInfo", "Lf61/j;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: f61.j$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SpannableStringBuilder b(String statusIntro) {
            List<String> split$default;
            boolean startsWith$default;
            String removePrefix;
            String removeSuffix;
            Integer intOrNull;
            int i3;
            split$default = StringsKt__StringsKt.split$default((CharSequence) statusIntro, new String[]{"#"}, false, 0, 6, (Object) null);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (String str : split$default) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "qemoji", false, 2, null);
                if (startsWith$default) {
                    spannableStringBuilder.append((CharSequence) " ");
                    removePrefix = StringsKt__StringsKt.removePrefix(str, (CharSequence) "qemoji{");
                    removeSuffix = StringsKt__StringsKt.removeSuffix(removePrefix, (CharSequence) "}");
                    intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(removeSuffix);
                    if (intOrNull != null) {
                        i3 = intOrNull.intValue();
                    } else {
                        i3 = 0;
                    }
                    QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
                    Drawable drawable = resImpl.getDrawable(resImpl.getLocalId(i3));
                    int b16 = ViewUtils.f352270a.b(14);
                    drawable.setBounds(0, 0, b16, b16);
                    spannableStringBuilder.setSpan(new com.tencent.biz.ui.a(drawable), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 0);
                } else {
                    spannableStringBuilder.append((CharSequence) str);
                }
            }
            return spannableStringBuilder;
        }

        @JvmStatic
        @NotNull
        public final j a(@NotNull oidb_0x1250$PartnerInfo partnerInfo) {
            long j3;
            String str;
            String str2;
            k kVar;
            boolean z16;
            CharSequence charSequence;
            int i3;
            long j16;
            Intrinsics.checkNotNullParameter(partnerInfo, "partnerInfo");
            if (partnerInfo.f436013id.has()) {
                j3 = partnerInfo.f436013id.get();
            } else {
                j3 = 0;
            }
            if (!partnerInfo.name.has()) {
                str = "";
            } else {
                str = partnerInfo.name.get();
            }
            Intrinsics.checkNotNullExpressionValue(str, "if (partnerInfo.name.has\u2026erInfo.name.get() else \"\"");
            if (!partnerInfo.icon_url.has()) {
                str2 = "";
            } else {
                str2 = partnerInfo.icon_url.get();
            }
            Intrinsics.checkNotNullExpressionValue(str2, "if (partnerInfo.icon_url\u2026fo.icon_url.get() else \"\"");
            if (partnerInfo.light_interaction.has()) {
                k.Companion companion = k.INSTANCE;
                oidb_0x1250$PartnerLightInteraction oidb_0x1250_partnerlightinteraction = partnerInfo.light_interaction.get();
                Intrinsics.checkNotNullExpressionValue(oidb_0x1250_partnerlightinteraction, "partnerInfo.light_interaction.get()");
                kVar = companion.a(oidb_0x1250_partnerlightinteraction);
            } else {
                kVar = new k(null, null, 3, null);
            }
            k kVar2 = kVar;
            boolean z17 = false;
            if (partnerInfo.is_bind.has()) {
                z16 = partnerInfo.is_bind.get();
            } else {
                z16 = false;
            }
            if (!partnerInfo.status_intro.has()) {
                charSequence = "";
            } else {
                String str3 = partnerInfo.status_intro.get();
                Intrinsics.checkNotNullExpressionValue(str3, "partnerInfo.status_intro.get()");
                charSequence = b(str3);
            }
            if (partnerInfo.status.has()) {
                i3 = partnerInfo.status.get();
            } else {
                i3 = 0;
            }
            if (partnerInfo.is_new.has()) {
                z17 = partnerInfo.is_new.get();
            }
            if (partnerInfo.new_time.has()) {
                j16 = partnerInfo.new_time.get();
            } else {
                j16 = 0;
            }
            return new j(j3, str, str2, kVar2, z16, charSequence, i3, z17, j16);
        }

        Companion() {
        }
    }

    public j() {
        this(0L, null, null, null, false, null, 0, false, 0L, 511, null);
    }

    @JvmStatic
    @NotNull
    public static final j a(@NotNull oidb_0x1250$PartnerInfo oidb_0x1250_partnerinfo) {
        return INSTANCE.a(oidb_0x1250_partnerinfo);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: c, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final k getInteractionEntryInfo() {
        return this.interactionEntryInfo;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: f, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final CharSequence getStatusIntro() {
        return this.statusIntro;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsBind() {
        return this.isBind;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsNew() {
        return this.isNew;
    }

    @NotNull
    public String toString() {
        long j3 = this.id;
        String str = this.name;
        String str2 = this.iconUrl;
        k kVar = this.interactionEntryInfo;
        boolean z16 = this.isBind;
        CharSequence charSequence = this.statusIntro;
        return "{id=" + j3 + ", name=" + str + ", iconUrl=" + str2 + ", interactionEntryInfo=" + kVar + ", isBind=" + z16 + ", statusIntro=" + ((Object) charSequence) + ", status=" + this.status + ", isNew=" + this.isNew + ", newTime=" + this.newTime + "}";
    }

    public j(long j3, @NotNull String name, @NotNull String iconUrl, @NotNull k interactionEntryInfo, boolean z16, @NotNull CharSequence statusIntro, int i3, boolean z17, long j16) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(interactionEntryInfo, "interactionEntryInfo");
        Intrinsics.checkNotNullParameter(statusIntro, "statusIntro");
        this.id = j3;
        this.name = name;
        this.iconUrl = iconUrl;
        this.interactionEntryInfo = interactionEntryInfo;
        this.isBind = z16;
        this.statusIntro = statusIntro;
        this.status = i3;
        this.isNew = z17;
        this.newTime = j16;
    }

    public /* synthetic */ j(long j3, String str, String str2, k kVar, boolean z16, CharSequence charSequence, int i3, boolean z17, long j16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0L : j3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? new k(null, null, 3, null) : kVar, (i16 & 16) != 0 ? false : z16, (i16 & 32) == 0 ? charSequence : "", (i16 & 64) != 0 ? 0 : i3, (i16 & 128) == 0 ? z17 : false, (i16 & 256) == 0 ? j16 : 0L);
    }
}
