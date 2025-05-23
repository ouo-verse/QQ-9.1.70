package com.tencent.qqnt.qbasealbum.customization.common;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 .*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\u00020\u0003:\u0001\tB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b1\u00102J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0017\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\b\u001a\u00028\u0000\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000bR>\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014RB\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u0018\u0010\u001b\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010#\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010%\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\"R\u0011\u0010'\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010&R\u0011\u0010(\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\"R\u0011\u0010*\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b)\u0010\"R\u0011\u0010,\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b+\u0010\"R\u0011\u00100\u001a\u00020-8F\u00a2\u0006\u0006\u001a\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "O", "", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "k", "other", "a", "(Lcom/tencent/qqnt/qbasealbum/customization/common/a;)Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "Landroidx/fragment/app/FragmentActivity;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "c", "()Ljava/util/HashMap;", "setEditPathMap", "(Ljava/util/HashMap;)V", "editPathMap", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "publishPlayGameParams", "d", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "mOtherCommonData", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", h.F, "()Ljava/util/List;", "selectedPhotoList", "j", "()Z", "isQualityRaw", "i", "isFlashPic", "()Ljava/lang/String;", "comment", "flashPicEnable", "g", "qualityRawShow", "l", "isSingleMode", "", "e", "()I", "minSendMediaSize", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class b<O extends a> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FragmentActivity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, String> editPathMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HashMap<String, String> publishPlayGameParams;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private O mOtherCommonData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/customization/common/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.customization.common.b$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35843);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        } else {
            this.activity = activity;
            this.editPathMap = new HashMap<>();
        }
    }

    @Nullable
    public final O a(O other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (O) iPatchRedirector.redirect((short) 15, (Object) this, (Object) other);
        }
        if (this.mOtherCommonData == null) {
            synchronized (a.class) {
                if (this.mOtherCommonData == null) {
                    this.mOtherCommonData = other;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return this.mOtherCommonData;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return com.tencent.qqnt.qbasealbum.album.b.h(this.activity).L1();
    }

    @NotNull
    public final HashMap<String, String> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.editPathMap;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return QAlbumPickerContext.f361201a.n();
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return QAlbumPickerContext.f361201a.h();
    }

    @Nullable
    public final HashMap<String, String> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (HashMap) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.publishPlayGameParams;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return QAlbumPickerContext.f361201a.o();
    }

    @NotNull
    public final List<LocalMediaInfo> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return com.tencent.qqnt.qbasealbum.album.b.g(this.activity).getSelectedMedia();
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return com.tencent.qqnt.qbasealbum.album.b.h(this.activity).M1();
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return com.tencent.qqnt.qbasealbum.album.b.h(this.activity).O1();
    }

    public final boolean k(@NotNull FragmentActivity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        return Intrinsics.areEqual(this.activity, activity);
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return QAlbumPickerContext.f361201a.p();
    }

    public final void m(@Nullable HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) hashMap);
        } else {
            this.publishPlayGameParams = hashMap;
        }
    }
}
