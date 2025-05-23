package com.tencent.mobileqq.troop.homework.album;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.util.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.filter.MediaFilter;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PickerInitBean;
import com.tencent.qqnt.qbasealbum.model.TabType;
import com.tencent.qqnt.qbasealbum.utils.MediaTypeHelper;
import com.tencent.util.QQToastUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0016B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002J$\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0014j\b\u0012\u0004\u0012\u00020\u0002`\u00152\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/album/a;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "", "c", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "d", "maxMediaSize", "Landroid/content/Context;", "context", "", "onlyPic", "Landroid/content/Intent;", "e", "mediaInfo", "", "a", "", "oriInfoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/album/a$a;", "", "", "DEFAULT_CHOOSE_VIDEO_DURATION", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.album.a$a, reason: collision with other inner class name and from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/album/a$b;", "", "mediaInfoModel", "", "b", "a", "<init>", "(Lcom/tencent/mobileqq/troop/homework/album/a;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class b {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        public final boolean a(@NotNull Object mediaInfoModel) {
            LocalMediaInfo localMediaInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, mediaInfoModel)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(mediaInfoModel, "mediaInfoModel");
            if (mediaInfoModel instanceof LocalMediaInfo) {
                localMediaInfo = (LocalMediaInfo) mediaInfoModel;
            } else {
                localMediaInfo = null;
            }
            if (localMediaInfo == null) {
                return false;
            }
            if (localMediaInfo.getMediaWidth() > 0 && localMediaInfo.getMediaHeight() > 0) {
                return true;
            }
            QQToastUtil.showQQToast(0, R.string.f144380om);
            return false;
        }

        public final boolean b(@NotNull Object mediaInfoModel) {
            LocalMediaInfo localMediaInfo;
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, mediaInfoModel)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(mediaInfoModel, "mediaInfoModel");
            if (mediaInfoModel instanceof LocalMediaInfo) {
                localMediaInfo = (LocalMediaInfo) mediaInfoModel;
            } else {
                localMediaInfo = null;
            }
            if (localMediaInfo == null) {
                return false;
            }
            Long videoDuration = localMediaInfo.getVideoDuration();
            if (videoDuration != null) {
                j3 = videoDuration.longValue();
            } else {
                j3 = 0;
            }
            if (j3 > 600000) {
                QQToastUtil.showQQToast(0, "\u8bf7\u9009\u62e9\u65f6\u957f\u572810\u5206\u949f\u4ee5\u5185\u7684\u89c6\u9891");
                return false;
            }
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40287);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int c(LocalMediaInfo info) {
        return MediaTypeHelper.f361628a.a(info);
    }

    private final MediaFilter d() {
        MediaFilter.Companion companion = MediaFilter.INSTANCE;
        MediaFilter.a aVar = new MediaFilter.a();
        aVar.f(600000L);
        return aVar.a();
    }

    public final void a(@NotNull LocalMediaInfo mediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) mediaInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        String path = mediaInfo.getPath();
        if (path != null && !TextUtils.isEmpty(path) && c(mediaInfo) == 0) {
            if (new File(path).exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(path, options);
                mediaInfo.setMediaWidth(options.outWidth);
                mediaInfo.setMediaHeight(options.outHeight);
                mediaInfo.setMMimeType(options.outMimeType);
                return;
            }
            QLog.d("HW.AlbumUtils", 1, "Error File does not exist");
        }
    }

    @NotNull
    public final ArrayList<LocalMediaInfo> b(@NotNull List<LocalMediaInfo> oriInfoList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) oriInfoList);
        }
        Intrinsics.checkNotNullParameter(oriInfoList, "oriInfoList");
        ArrayList<LocalMediaInfo> arrayList = new ArrayList<>(oriInfoList);
        Iterator<LocalMediaInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            LocalMediaInfo next = it.next();
            if (c(next) == 1) {
                d.a aVar = new d.a();
                d.a(next.getPath(), aVar);
                next.setRotation(aVar.f288248a[2]);
                next.setMediaWidth(aVar.f288248a[0]);
                next.setMediaHeight(aVar.f288248a[1]);
            }
        }
        return arrayList;
    }

    @NotNull
    public final Intent e(int maxMediaSize, @NotNull Context context, boolean onlyPic) {
        TabType tabType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Intent) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(maxMediaSize), context, Boolean.valueOf(onlyPic));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.qqnt.qbasealbum.a aVar = com.tencent.qqnt.qbasealbum.a.f360732a;
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar2 = new Config.a();
        aVar2.g(maxMediaSize);
        if (onlyPic) {
            tabType = TabType.TAB_IMAGE;
        } else {
            tabType = TabType.TAB_MEDIA;
        }
        aVar2.f(tabType);
        aVar2.b(new ArrayList());
        aVar2.d(false);
        aVar2.l(false);
        aVar2.e(6);
        aVar2.o(new HashMap<>());
        aVar2.p(d());
        aVar2.j(true);
        Unit unit = Unit.INSTANCE;
        Config a16 = aVar2.a();
        PickerInitBean.Companion companion2 = PickerInitBean.INSTANCE;
        PickerInitBean.a aVar3 = new PickerInitBean.a();
        String string = context.getString(R.string.b9f);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026roop.api.R.string.finish)");
        aVar3.b(string);
        return aVar.d(context, a16, aVar3.a(), HWPickerCustomization.class, HWPreviewCustomization.class);
    }
}
