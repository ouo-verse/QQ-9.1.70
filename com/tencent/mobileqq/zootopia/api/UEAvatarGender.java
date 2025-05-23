package com.tencent.mobileqq.zootopia.api;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.mobileqq.profilecard.widget.TabContainer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "", "type", "", "index", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getIndex", "()I", "getType", "()Ljava/lang/String;", "toEnumUserGender", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", TabContainer.Tab.MALE, TabContainer.Tab.FEMALE, "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum UEAvatarGender {
    MALE("\u7537", 1),
    FEMALE("\u5973", 2);

    private final int index;

    @NotNull
    private final String type;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f327900a;

        static {
            int[] iArr = new int[UEAvatarGender.values().length];
            try {
                iArr[UEAvatarGender.MALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f327900a = iArr;
        }
    }

    UEAvatarGender(String str, int i3) {
        this.type = str;
        this.index = i3;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final EnumUserGender toEnumUserGender() {
        if (a.f327900a[ordinal()] == 1) {
            return EnumUserGender.GENDER_MALE;
        }
        return EnumUserGender.GENDER_FEMALE;
    }
}
