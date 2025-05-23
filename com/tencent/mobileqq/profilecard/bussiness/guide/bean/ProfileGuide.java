package com.tencent.mobileqq.profilecard.bussiness.guide.bean;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide;", "", "()V", "guideId", "", "getGuideId", "()I", "setGuideId", "(I)V", "guideMainMsg", "", "getGuideMainMsg", "()Ljava/lang/String;", "setGuideMainMsg", "(Ljava/lang/String;)V", "guideSecondaryMsg", "getGuideSecondaryMsg", "setGuideSecondaryMsg", "guideType", "getGuideType", "setGuideType", AppConstants.Key.COLUMN_IS_VALID, "", "toString", "Companion", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfileGuide {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int INVALID_ID = -1;
    public static final int TYPE_FILL = 1;
    public static final int TYPE_UPDATE = 2;

    @NotNull
    private static final Integer[] VALID_GUIDE_ID;

    @NotNull
    private static final Integer[] VALID_GUIDE_TYPE;
    private int guideId;

    @Nullable
    private String guideMainMsg;

    @Nullable
    private String guideSecondaryMsg;
    private int guideType;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide$Companion;", "", "()V", "INVALID_ID", "", "TYPE_FILL", "TYPE_UPDATE", "VALID_GUIDE_ID", "", "getVALID_GUIDE_ID", "()[Ljava/lang/Integer;", "[Ljava/lang/Integer;", "VALID_GUIDE_TYPE", "getVALID_GUIDE_TYPE", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final Integer[] getVALID_GUIDE_ID() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return ProfileGuide.VALID_GUIDE_ID;
            }
            return (Integer[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @NotNull
        public final Integer[] getVALID_GUIDE_TYPE() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return ProfileGuide.VALID_GUIDE_TYPE;
            }
            return (Integer[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18511);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        INSTANCE = new Companion(null);
        VALID_GUIDE_TYPE = new Integer[]{1, 2};
        VALID_GUIDE_ID = new Integer[]{1, 2, 3, 4, 5, 7, 8, 9};
    }

    public ProfileGuide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.guideId = -1;
            this.guideType = -1;
        }
    }

    public final int getGuideId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.guideId;
    }

    @Nullable
    public final String getGuideMainMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.guideMainMsg;
    }

    @Nullable
    public final String getGuideSecondaryMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.guideSecondaryMsg;
    }

    public final int getGuideType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.guideType;
    }

    public final boolean isValid() {
        boolean contains;
        boolean contains2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            contains = ArraysKt___ArraysKt.contains(VALID_GUIDE_ID, Integer.valueOf(this.guideId));
            if (contains) {
                contains2 = ArraysKt___ArraysKt.contains(VALID_GUIDE_TYPE, Integer.valueOf(this.guideType));
                if (contains2 && !TextUtils.isEmpty(this.guideMainMsg)) {
                    return true;
                }
            }
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
    }

    public final void setGuideId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.guideId = i3;
        }
    }

    public final void setGuideMainMsg(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.guideMainMsg = str;
        }
    }

    public final void setGuideSecondaryMsg(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.guideSecondaryMsg = str;
        }
    }

    public final void setGuideType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.guideType = i3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "ProfileGuide {guideId=" + this.guideId + ", guideType=" + this.guideType + ", guideMainMsg=" + this.guideMainMsg + ", guideSecondaryMsg=" + this.guideSecondaryMsg + "}";
    }
}
