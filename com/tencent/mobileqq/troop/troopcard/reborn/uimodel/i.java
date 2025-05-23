package com.tencent.mobileqq.troop.troopcard.reborn.uimodel;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0007B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\rR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\n \u0015*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/i;", "", "", "index", "Landroid/graphics/Bitmap;", "d", "", "a", "c", "b", "I", "grade", "", "J", WidgetCacheConstellationData.NUM, "total", "Landroid/graphics/Bitmap;", "icon", "e", "Ljava/lang/String;", "gradeDesc", "kotlin.jvm.PlatformType", "f", QzoneZipCacheHelper.DIR, "<init>", "(IJJ)V", "g", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int grade;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long num;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long total;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap icon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String gradeDesc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String dir;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/i$a;", "", "", "COLUMN_BITMAP_ICON_NAME_PREFIX", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.uimodel.i$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57307);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public i(int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.grade = i3;
        this.num = j3;
        this.total = j16;
        this.gradeDesc = "";
        this.dir = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getTroopGameCardResDownloadPath();
    }

    @NotNull
    public final String a() {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            isBlank = StringsKt__StringsJVMKt.isBlank(this.gradeDesc);
            if (isBlank) {
                String majorGradeTagById = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getMajorGradeTagById(this.grade);
                if (majorGradeTagById == null) {
                    majorGradeTagById = "";
                }
                this.gradeDesc = majorGradeTagById;
            }
            return this.gradeDesc;
        }
        return (String) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        switch (this.grade / 100000) {
            case 2:
                return Color.parseColor("#7ED3E4");
            case 3:
                return Color.parseColor("#C3D5FA");
            case 4:
                return Color.parseColor("#ECBF84");
            case 5:
                return Color.parseColor("#7EC2F1");
            case 6:
                return Color.parseColor("#C6BFF8");
            case 7:
                return Color.parseColor("#C8BCC5");
            case 8:
                return Color.parseColor("#EFA793");
            default:
                return 0;
        }
    }

    public final int c() {
        int roundToInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        long j3 = this.total;
        if (j3 != 0) {
            roundToInt = MathKt__MathJVMKt.roundToInt(((float) (this.num * 100)) / ((float) j3));
            return roundToInt;
        }
        return 0;
    }

    @Nullable
    public final Bitmap d(int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, index);
        }
        if (this.icon == null) {
            this.icon = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap(this.dir + "column_game_grade_" + (index + 1) + ".png");
        }
        return this.icon;
    }
}
