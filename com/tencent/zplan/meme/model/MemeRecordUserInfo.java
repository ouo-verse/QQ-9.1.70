package com.tencent.zplan.meme.model;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.model.MemeRecordParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0016B+\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010+\u00a2\u0006\u0004\b6\u00107J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\t\u0010\u0011\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0018\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\"\u0010#\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0019\u0010'\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010&R\u0016\u0010*\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R$\u00101\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b(\u0010.\"\u0004\b/\u00100R\u0016\u00102\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010&R\u0013\u00103\u001a\u0004\u0018\u00010\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010&R\u0011\u00105\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b,\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/zplan/meme/model/d;", "", "", "checkUin", "checkAppearanceKey", "", "i", "(Ljava/lang/String;Ljava/lang/String;)Z", "changeUin", "changeAppearanceKey", "", "c", "(Ljava/lang/String;Ljava/lang/String;)V", "k", "j", "Lcom/tencent/zplan/meme/model/MemeRecordParams$User;", DomainData.DOMAIN_NAME, "toString", "", "hashCode", "other", "equals", "a", "Z", "customAvatarCharacterFlag", "b", "Ljava/lang/String;", "_appearanceKeyByUin", "I", "_gender", "d", "getResourceReady$record_debug", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "resourceReady", "e", h.F, "()Ljava/lang/String;", "uin", "f", "Ljava/lang/Integer;", "expectGender", "Lcom/tencent/zplan/meme/model/a;", "g", "Lcom/tencent/zplan/meme/model/a;", "()Lcom/tencent/zplan/meme/model/a;", "l", "(Lcom/tencent/zplan/meme/model/a;)V", "avatarCharacter", "appearanceKeyByUin", "appearanceKey", "()I", "gender", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/zplan/meme/model/a;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.zplan.meme.model.d, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class MemeRecordUserInfo {

    /* renamed from: h, reason: collision with root package name */
    private static final lx4.a f385913h;

    /* renamed from: i, reason: collision with root package name */
    private static final yx4.c f385914i;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean customAvatarCharacterFlag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String _appearanceKeyByUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int _gender;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile boolean resourceReady;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String uin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final Integer expectGender;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private AvatarCharacterInfo avatarCharacter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/zplan/meme/model/d$a;", "", "", "userId", "c", "uin", "", "d", "Llx4/a;", "commonProxy", "Llx4/a;", "Lyx4/c;", "memeProxy", "Lyx4/c;", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.meme.model.d$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String c(String userId) {
            if (!TextUtils.isEmpty(userId) && MemeRecordUserInfo.f385914i != null) {
                yx4.c cVar = MemeRecordUserInfo.f385914i;
                Intrinsics.checkNotNull(userId);
                return cVar.f(userId);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(String uin) {
            if (uin != null && Meme.f385754h.k().getGenRecordKeyWithGender() && MemeRecordUserInfo.f385913h != null) {
                return MemeRecordUserInfo.f385913h.getGender(uin);
            }
            return 0;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        mx4.a aVar = mx4.a.f417748a;
        f385913h = (lx4.a) aVar.a(lx4.a.class);
        f385914i = (yx4.c) aVar.a(yx4.c.class);
    }

    public MemeRecordUserInfo() {
        this(null, null, null, 7, null);
    }

    /* renamed from: e, reason: from getter */
    private final String get_appearanceKeyByUin() {
        return this._appearanceKeyByUin;
    }

    public final void c(@NotNull String changeUin, @NotNull String changeAppearanceKey) {
        boolean z16;
        Intrinsics.checkNotNullParameter(changeUin, "changeUin");
        Intrinsics.checkNotNullParameter(changeAppearanceKey, "changeAppearanceKey");
        String str = this.uin;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !(!Intrinsics.areEqual(this.uin, changeUin)) && !this.customAvatarCharacterFlag) {
            this._appearanceKeyByUin = changeAppearanceKey;
            this._gender = INSTANCE.d(this.uin);
            this.resourceReady = false;
        }
    }

    @Nullable
    public final String d() {
        boolean z16;
        AvatarCharacterInfo avatarCharacterInfo = this.avatarCharacter;
        if (avatarCharacterInfo == null) {
            return get_appearanceKeyByUin();
        }
        Intrinsics.checkNotNull(avatarCharacterInfo);
        String dressKey = avatarCharacterInfo.getDressKey();
        if (dressKey.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return String.valueOf(System.currentTimeMillis());
        }
        return dressKey;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof MemeRecordUserInfo) {
                MemeRecordUserInfo memeRecordUserInfo = (MemeRecordUserInfo) other;
                if (!Intrinsics.areEqual(this.uin, memeRecordUserInfo.uin) || !Intrinsics.areEqual(this.expectGender, memeRecordUserInfo.expectGender) || !Intrinsics.areEqual(this.avatarCharacter, memeRecordUserInfo.avatarCharacter)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final AvatarCharacterInfo getAvatarCharacter() {
        return this.avatarCharacter;
    }

    /* renamed from: g, reason: from getter */
    public final int get_gender() {
        return this._gender;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.uin;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        Integer num = this.expectGender;
        if (num != null) {
            i16 = num.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        AvatarCharacterInfo avatarCharacterInfo = this.avatarCharacter;
        if (avatarCharacterInfo != null) {
            i17 = avatarCharacterInfo.hashCode();
        }
        return i19 + i17;
    }

    public final boolean i(@NotNull String checkUin, @NotNull String checkAppearanceKey) {
        boolean z16;
        Intrinsics.checkNotNullParameter(checkUin, "checkUin");
        Intrinsics.checkNotNullParameter(checkAppearanceKey, "checkAppearanceKey");
        String str = this.uin;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || (!Intrinsics.areEqual(this.uin, checkUin)) || this.customAvatarCharacterFlag) {
            return true;
        }
        return Intrinsics.areEqual(get_appearanceKeyByUin(), checkAppearanceKey);
    }

    public final boolean j() {
        boolean z16;
        if (this.resourceReady) {
            return false;
        }
        String str = this.uin;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || this.avatarCharacter != null) {
            return false;
        }
        return true;
    }

    public final boolean k() {
        boolean z16;
        if (this.resourceReady) {
            return false;
        }
        String str = this.uin;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && this.avatarCharacter == null) {
            return false;
        }
        return true;
    }

    public final void l(@Nullable AvatarCharacterInfo avatarCharacterInfo) {
        this.avatarCharacter = avatarCharacterInfo;
    }

    public final void m(boolean z16) {
        this.resourceReady = z16;
    }

    @Nullable
    public final MemeRecordParams.User n() {
        boolean z16;
        JSONObject jSONObject;
        gx4.a character;
        String str = this.uin;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        String str2 = null;
        if (z16 && this.avatarCharacter == null) {
            return null;
        }
        String str3 = this.uin;
        Integer valueOf = Integer.valueOf(get_gender());
        AvatarCharacterInfo avatarCharacterInfo = this.avatarCharacter;
        if (avatarCharacterInfo != null && (character = avatarCharacterInfo.getCharacter()) != null) {
            jSONObject = fx4.a.m(character);
        } else {
            jSONObject = null;
        }
        String valueOf2 = String.valueOf(jSONObject);
        AvatarCharacterInfo avatarCharacterInfo2 = this.avatarCharacter;
        if (avatarCharacterInfo2 != null) {
            str2 = avatarCharacterInfo2.getDressKey();
        }
        return new MemeRecordParams.User(str3, valueOf, valueOf2, str2);
    }

    @NotNull
    public String toString() {
        return "MemeRecordUserInfo(uin=" + this.uin + ", expectGender=" + this.expectGender + ", avatarCharacter=" + this.avatarCharacter + ")";
    }

    public MemeRecordUserInfo(@Nullable String str, @Nullable Integer num, @Nullable AvatarCharacterInfo avatarCharacterInfo) {
        int d16;
        this.uin = str;
        this.expectGender = num;
        this.avatarCharacter = avatarCharacterInfo;
        this.customAvatarCharacterFlag = avatarCharacterInfo != null;
        Companion companion = INSTANCE;
        this._appearanceKeyByUin = companion.c(str);
        if (num == null) {
            d16 = companion.d(str);
        } else {
            d16 = num.intValue();
        }
        this._gender = d16;
    }

    public /* synthetic */ MemeRecordUserInfo(String str, Integer num, AvatarCharacterInfo avatarCharacterInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : avatarCharacterInfo);
    }
}
