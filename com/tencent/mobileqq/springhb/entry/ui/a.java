package com.tencent.mobileqq.springhb.entry.ui;

import android.graphics.Bitmap;
import android.util.Size;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.springhb.entry.model.BaseActivityData;
import com.tencent.mobileqq.springhb.entry.model.OnGrabActivityData;
import com.tencent.mobileqq.springhb.entry.worker.DemoteLevel;
import com.tencent.mobileqq.springhb.entry.worker.b;
import com.tencent.mobileqq.springhb.preload.SpringRes;
import com.tencent.mobileqq.springhb.preload.p;
import com.tencent.mobileqq.springhb.preload.s;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004R\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/ui/a;", "", "Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", "imgs", "Landroid/util/Size;", "a", "", "filePath", "", "width", "height", "Landroid/graphics/Bitmap;", "c", "", "d", "imageSize", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isAlive", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isAlive;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR+\u0010\u0012\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\rj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0015\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/ui/a$a;", "", "", "index", "Landroid/graphics/Bitmap;", "d", "", "e", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "key", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "records", "c", "()I", "size", "<init>", "(Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.entry.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C8605a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String key;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<Bitmap> records;

        public C8605a() {
            this(null, 1, 0 == true ? 1 : 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this);
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.key;
        }

        @NotNull
        public final ArrayList<Bitmap> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.records;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.records.size();
        }

        @Nullable
        public final Bitmap d(int index) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Bitmap) iPatchRedirector.redirect((short) 6, (Object) this, index);
            }
            if (index >= this.records.size()) {
                return null;
            }
            return this.records.get(index);
        }

        public final void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            try {
                for (Bitmap bitmap : this.records) {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                }
            } catch (Throwable unused) {
            }
        }

        public C8605a(@NotNull String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) key);
            } else {
                this.key = key;
                this.records = new ArrayList<>();
            }
        }

        public /* synthetic */ C8605a(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "rabbit" : str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isAlive = new AtomicBoolean(true);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x007f, code lost:
    
        if (r13.equals("star_appear") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0088, code lost:
    
        if (r13.equals("gift_fall") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00af, code lost:
    
        if (r13.equals("gift_appear") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0032, code lost:
    
        if (r0.equals("star_appear") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0039, code lost:
    
        if (r0.equals("gift_fall") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
    
        r2 = 160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0060, code lost:
    
        if (r0.equals("gift_appear") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x002b, code lost:
    
        if (r0.equals("star_fall") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0078, code lost:
    
        if (r13.equals("star_fall") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0082, code lost:
    
        r10 = 180;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Size a(C8605a imgs) {
        String a16 = imgs.a();
        int i3 = 120;
        int i16 = 160;
        switch (a16.hashCode()) {
            case -1933268092:
                break;
            case -505665183:
                a16.equals("rabbit_fast");
                i3 = 400;
                break;
            case -383936610:
                a16.equals("rabbit_narmal");
                i3 = 400;
                break;
            case 98262:
                a16.equals("cat");
                i3 = 400;
                break;
            case 3321844:
                if (a16.equals("line")) {
                    i3 = ViewUtils.f352270a.e();
                    break;
                }
                i3 = 400;
                break;
            case 570189098:
                break;
            case 1368155170:
                break;
            case 2146807112:
                break;
            default:
                i3 = 400;
                break;
        }
        String a17 = imgs.a();
        switch (a17.hashCode()) {
            case -1933268092:
                break;
            case -505665183:
                a17.equals("rabbit_fast");
                i16 = 400;
                break;
            case -371007316:
                a17.equals("rabbit_normal");
                i16 = 400;
                break;
            case 98262:
                a17.equals("cat");
                i16 = 400;
                break;
            case 3321844:
                if (a17.equals("line")) {
                    i16 = ViewUtils.f352270a.d();
                    break;
                }
                i16 = 400;
                break;
            case 570189098:
                break;
            case 1368155170:
                break;
            case 2146807112:
                break;
            default:
                i16 = 400;
                break;
        }
        return new Size(i3, i16);
    }

    private final Bitmap c(String filePath, int width, int height) {
        if (!this.isAlive.get()) {
            return null;
        }
        try {
            return p.h(filePath, -1, width, height, false);
        } catch (Exception unused) {
            return null;
        }
    }

    @NotNull
    public final AtomicBoolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AtomicBoolean) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.isAlive;
    }

    public final void d(@NotNull C8605a imgs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) imgs);
        } else {
            Intrinsics.checkNotNullParameter(imgs, "imgs");
            e(imgs, a(imgs));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0101, code lost:
    
        if (r0.equals("line") == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x010f, code lost:
    
        r0 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x010c, code lost:
    
        if (r0.equals("cat") == false) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(@NotNull C8605a imgs, @NotNull Size imageSize) {
        String str;
        String a16;
        String str2;
        String str3;
        String str4;
        boolean z16;
        File[] listFiles;
        int i3;
        IntRange until;
        Iterator<Integer> it;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) imgs, (Object) imageSize);
            return;
        }
        Intrinsics.checkNotNullParameter(imgs, "imgs");
        Intrinsics.checkNotNullParameter(imageSize, "imageSize");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            Manager manager = runtime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager");
            SpringFestivalEntryManager springFestivalEntryManager = (SpringFestivalEntryManager) manager;
            BaseActivityData A = springFestivalEntryManager.A(springFestivalEntryManager.I());
            if (A instanceof OnGrabActivityData) {
                str = ((OnGrabActivityData) A).shuaAnimationResUrl;
                Intrinsics.checkNotNullExpressionValue(str, "baseActivityData.shuaAnimationResUrl");
                SpringRes b16 = s.b(str);
                if (QLog.isColorLevel()) {
                    QLog.d("SpringSysResHelper", 1, "[loadImgList]key: " + str + ", springRes: " + b16);
                }
                a16 = imgs.a();
                switch (a16.hashCode()) {
                    case -1933268092:
                        if (a16.equals("gift_appear")) {
                            str2 = QCircleDaTongConstant.ElementParamValue.GIFT + File.separator + "appear";
                            break;
                        }
                        str2 = "none";
                        break;
                    case -505665183:
                        if (a16.equals("rabbit_fast")) {
                            str2 = "rabbit" + File.separator + VideoConverterConfig.SoftwareConfig.PRESET_FAST;
                            break;
                        }
                        str2 = "none";
                        break;
                    case -371007316:
                        if (a16.equals("rabbit_normal")) {
                            str2 = "rabbit" + File.separator + "normal";
                            break;
                        }
                        str2 = "none";
                        break;
                    case 98262:
                        str3 = "cat";
                        break;
                    case 3321844:
                        str3 = "line";
                        break;
                    case 570189098:
                        if (a16.equals("gift_fall")) {
                            str2 = QCircleDaTongConstant.ElementParamValue.GIFT + File.separator + "fall";
                            break;
                        }
                        str2 = "none";
                        break;
                    case 1368155170:
                        if (a16.equals("star_appear")) {
                            str2 = "star" + File.separator + "appear";
                            break;
                        }
                        str2 = "none";
                        break;
                    case 2146807112:
                        if (a16.equals("star_fall")) {
                            str2 = "star" + File.separator + "fall";
                            break;
                        }
                        str2 = "none";
                        break;
                    default:
                        str2 = "none";
                        break;
                }
                str4 = b16.o() + File.separator + str2;
                if (str4.length() <= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && new File(str4).exists()) {
                    listFiles = new File(str4).listFiles();
                    if (listFiles == null) {
                        i3 = listFiles.length;
                    } else {
                        i3 = 0;
                    }
                    until = RangesKt___RangesKt.until(0, i3);
                    it = until.iterator();
                    while (it.hasNext()) {
                        int nextInt = ((IntIterator) it).nextInt();
                        b bVar = b.f289157a;
                        if (bVar.c() != DemoteLevel.LV3 || nextInt <= 1) {
                            if (bVar.c() != DemoteLevel.LV2 || nextInt % 2 != 1) {
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                String format = String.format("%s/%03d.png", Arrays.copyOf(new Object[]{str4, Integer.valueOf(nextInt)}, 2));
                                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                                Bitmap c16 = c(format, imageSize.getWidth(), imageSize.getHeight());
                                if (c16 != null) {
                                    imgs.b().add(c16);
                                }
                            }
                        }
                    }
                }
                if (imgs.c() != 0) {
                    imgs.b().add(null);
                    return;
                }
                return;
            }
        }
        str = "";
        SpringRes b162 = s.b(str);
        if (QLog.isColorLevel()) {
        }
        a16 = imgs.a();
        switch (a16.hashCode()) {
            case -1933268092:
                break;
            case -505665183:
                break;
            case -371007316:
                break;
            case 98262:
                break;
            case 3321844:
                break;
            case 570189098:
                break;
            case 1368155170:
                break;
            case 2146807112:
                break;
        }
        str4 = b162.o() + File.separator + str2;
        if (str4.length() <= 0) {
        }
        if (z16) {
            listFiles = new File(str4).listFiles();
            if (listFiles == null) {
            }
            until = RangesKt___RangesKt.until(0, i3);
            it = until.iterator();
            while (it.hasNext()) {
            }
        }
        if (imgs.c() != 0) {
        }
    }
}
