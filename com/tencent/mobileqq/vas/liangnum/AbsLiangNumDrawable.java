package com.tencent.mobileqq.vas.liangnum;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasLiangNum;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.mobileqq.vas.image.d;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0003`abB;\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010&\u001a\u00020\b\u0012\u0006\u0010*\u001a\u00020\u001b\u0012\n\u0010.\u001a\u0006\u0012\u0002\b\u00030+\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u00104\u001a\u00020\b\u00a2\u0006\u0004\b^\u0010_J\u0012\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J,\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0006\u0010\u0013\u001a\u00020\bJ\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\fH&J\u001c\u0010\u0016\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u000bH\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001eH&R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010&\u001a\u00020\b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010*\u001a\u00020\u001b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b'\u0010!\u001a\u0004\b(\u0010)R\u0018\u0010.\u001a\u0006\u0012\u0002\b\u00030+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00104\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010#R0\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010B\u001a\u0004\u0018\u00010\f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010E\u001a\u0004\u0018\u00010\f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010=\u001a\u0004\b!\u0010?\"\u0004\bD\u0010AR(\u0010L\u001a\b\u0012\u0004\u0012\u00020\f0F8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010!R\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010PR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010PR\"\u0010V\u001a\u00020\u001b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010!\u001a\u0004\bS\u0010)\"\u0004\bT\u0010UR\"\u0010Y\u001a\u00020\u001b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010!\u001a\u0004\bW\u0010)\"\u0004\bX\u0010UR \u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u00106R\u0018\u0010]\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010\\\u00a8\u0006c"}, d2 = {"Lcom/tencent/mobileqq/vas/liangnum/AbsLiangNumDrawable;", "Lcom/tencent/mobileqq/vas/image/c;", "Lcom/tencent/mobileqq/vas/api/IVasLiangNum$a;", "", "isAsync", "", BdhLogUtil.LogTag.Tag_Req, "W", "", "imgPath", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "block", "V", "T", "X", "Lcom/tencent/mobileqq/vas/liangnum/AbsLiangNumDrawable$b;", UserInfo.SEX_FEMALE, "J", "U", "N", "setLoadedListener", "isLoadSucess", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "callback", "doLoadTask", "", "id", "k", "Lkotlin/Pair;", "O", "d", "I", "e", "Ljava/lang/String;", "P", "()Ljava/lang/String;", "uin", "f", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()I", "viewHeight", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", h.F, "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "business", "Landroid/view/View;", "i", "Landroid/view/View;", "targetView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "scene", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "getLoadCallback", "()Lkotlin/jvm/functions/Function1;", "setLoadCallback", "(Lkotlin/jvm/functions/Function1;)V", "loadCallback", "D", "Landroid/graphics/drawable/Drawable;", "H", "()Landroid/graphics/drawable/Drawable;", "Y", "(Landroid/graphics/drawable/Drawable;)V", "bgImg", "E", "Z", "fgImg", "", "[Landroid/graphics/drawable/Drawable;", "M", "()[Landroid/graphics/drawable/Drawable;", "a0", "([Landroid/graphics/drawable/Drawable;)V", "letterImgs", "G", "totalImgSize", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "loadNum", "playNum", "L", "setIconW", "(I)V", "iconW", "K", "setIconH", "iconH", "loadedListener", "Lcom/tencent/mobileqq/vas/api/IVasLiangNum$c;", "Lcom/tencent/mobileqq/vas/api/IVasLiangNum$c;", "outLoadedListener", "<init>", "(ILjava/lang/String;ILcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;Landroid/view/View;Ljava/lang/String;)V", "a", "b", "c", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class AbsLiangNumDrawable extends com.tencent.mobileqq.vas.image.c implements IVasLiangNum.a {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final HashMap<Integer, Pair<Integer, Integer>> P = new HashMap<>();

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function1<? super AbsLiangNumDrawable, Unit> loadCallback;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Drawable bgImg;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Drawable fgImg;

    /* renamed from: F, reason: from kotlin metadata */
    protected Drawable[] letterImgs;

    /* renamed from: G, reason: from kotlin metadata */
    private int totalImgSize;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final AtomicInteger loadNum;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final AtomicInteger playNum;

    /* renamed from: J, reason: from kotlin metadata */
    private int iconW;

    /* renamed from: K, reason: from kotlin metadata */
    private int iconH;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Function1<com.tencent.mobileqq.vas.image.c, Unit> loadedListener;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private IVasLiangNum.c outLoadedListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int id;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int viewHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQVasUpdateBusiness<?> business;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View targetView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String scene;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010RK\u0010\u0006\u001a6\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00040\u0002j\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0004`\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/liangnum/AbsLiangNumDrawable$a;", "", "Ljava/util/HashMap;", "", "Lkotlin/Pair;", "Lkotlin/collections/HashMap;", "w2HCache", "Ljava/util/HashMap;", "a", "()Ljava/util/HashMap;", "", "NAME_ICON", "Ljava/lang/String;", "NAME_NUM_BG", "TAG", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HashMap<Integer, Pair<Integer, Integer>> a() {
            return AbsLiangNumDrawable.P;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\u0018\b\u0002\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000fj\b\u0012\u0004\u0012\u00020\u0002`\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR'\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000fj\b\u0012\u0004\u0012\u00020\u0002`\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0016\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/liangnum/AbsLiangNumDrawable$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "bgPath", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "letterPaths", "e", "fgPath", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable$b, reason: from toString */
    /* loaded from: classes20.dex */
    public static final /* data */ class ImageFileData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String bgPath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ArrayList<String> letterPaths;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String fgPath;

        public ImageFileData() {
            this(null, null, null, 7, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getBgPath() {
            return this.bgPath;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getFgPath() {
            return this.fgPath;
        }

        @NotNull
        public final ArrayList<String> c() {
            return this.letterPaths;
        }

        public final void d(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bgPath = str;
        }

        public final void e(@Nullable String str) {
            this.fgPath = str;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImageFileData)) {
                return false;
            }
            ImageFileData imageFileData = (ImageFileData) other;
            if (Intrinsics.areEqual(this.bgPath, imageFileData.bgPath) && Intrinsics.areEqual(this.letterPaths, imageFileData.letterPaths) && Intrinsics.areEqual(this.fgPath, imageFileData.fgPath)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.bgPath.hashCode() * 31) + this.letterPaths.hashCode()) * 31;
            String str = this.fgPath;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "ImageFileData(bgPath=" + this.bgPath + ", letterPaths=" + this.letterPaths + ", fgPath=" + this.fgPath + ")";
        }

        public ImageFileData(@NotNull String bgPath, @NotNull ArrayList<String> letterPaths, @Nullable String str) {
            Intrinsics.checkNotNullParameter(bgPath, "bgPath");
            Intrinsics.checkNotNullParameter(letterPaths, "letterPaths");
            this.bgPath = bgPath;
            this.letterPaths = letterPaths;
            this.fgPath = str;
        }

        public /* synthetic */ ImageFileData(String str, ArrayList arrayList, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? new ArrayList() : arrayList, (i3 & 4) != 0 ? null : str2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001\u000fB'\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0014\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\tH&J(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016R\u0017\u0010\u0013\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/vas/liangnum/AbsLiangNumDrawable$c;", "Lcom/tencent/mobileqq/vas/image/d;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "e", "Landroid/graphics/Rect;", "b", "c", "Lcom/tencent/mobileqq/vas/liangnum/AbsLiangNumDrawable$c$a;", "d", "", "Landroid/graphics/drawable/Drawable;", "drawableStack", "bounds", "a", "Landroid/graphics/drawable/Drawable;", "getBg", "()Landroid/graphics/drawable/Drawable;", VasProfileTemplatePreloadHelper.BACKGROUND, "", "[Landroid/graphics/drawable/Drawable;", "getLetters", "()[Landroid/graphics/drawable/Drawable;", "letters", "f", "getFg", "fg", "g", "Lcom/tencent/mobileqq/vas/liangnum/AbsLiangNumDrawable$c$a;", "numInfo", h.F, "Landroid/graphics/Rect;", "iconBounds", "i", "numBgBounds", "", "j", "I", "preCanvasW", "k", "preCanvasH", "<init>", "(Landroid/graphics/drawable/Drawable;[Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static abstract class c extends d {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Drawable bg;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Drawable[] letters;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Drawable fg;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private NumInfo numInfo;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Rect iconBounds;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Rect numBgBounds;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private int preCanvasW;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private int preCanvasH;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0016\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0012\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/liangnum/AbsLiangNumDrawable$c$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "d", "()F", "w", "b", "getH", h.F, "c", "delX", "delY", "e", "start", "<init>", "(FFFFF)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable$c$a, reason: from toString */
        /* loaded from: classes20.dex */
        public static final /* data */ class NumInfo {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            private final float w;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            private final float h;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            private final float delX;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
            private final float delY;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
            private final float start;

            public NumInfo(float f16, float f17, float f18, float f19, float f26) {
                this.w = f16;
                this.h = f17;
                this.delX = f18;
                this.delY = f19;
                this.start = f26;
            }

            /* renamed from: a, reason: from getter */
            public final float getDelX() {
                return this.delX;
            }

            /* renamed from: b, reason: from getter */
            public final float getDelY() {
                return this.delY;
            }

            /* renamed from: c, reason: from getter */
            public final float getStart() {
                return this.start;
            }

            /* renamed from: d, reason: from getter */
            public final float getW() {
                return this.w;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NumInfo)) {
                    return false;
                }
                NumInfo numInfo = (NumInfo) other;
                if (Float.compare(this.w, numInfo.w) == 0 && Float.compare(this.h, numInfo.h) == 0 && Float.compare(this.delX, numInfo.delX) == 0 && Float.compare(this.delY, numInfo.delY) == 0 && Float.compare(this.start, numInfo.start) == 0) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return (((((((Float.floatToIntBits(this.w) * 31) + Float.floatToIntBits(this.h)) * 31) + Float.floatToIntBits(this.delX)) * 31) + Float.floatToIntBits(this.delY)) * 31) + Float.floatToIntBits(this.start);
            }

            @NotNull
            public String toString() {
                return "NumInfo(w=" + this.w + ", h=" + this.h + ", delX=" + this.delX + ", delY=" + this.delY + ", start=" + this.start + ")";
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c(@NotNull Drawable bg5, @NotNull Drawable[] letters, @Nullable Drawable drawable) {
            super(r0);
            Intrinsics.checkNotNullParameter(bg5, "bg");
            Intrinsics.checkNotNullParameter(letters, "letters");
            ArrayList arrayList = new ArrayList();
            arrayList.add(bg5);
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, letters);
            if (drawable != null) {
                arrayList.add(drawable);
            }
            this.bg = bg5;
            this.letters = letters;
            this.fg = drawable;
            this.preCanvasW = -1;
            this.preCanvasH = -1;
        }

        private final void e(Canvas canvas) {
            if (this.numInfo == null) {
                this.numInfo = d();
            }
            if (this.iconBounds == null) {
                this.iconBounds = c(canvas);
            }
            if (this.numBgBounds == null) {
                this.numBgBounds = b(canvas);
            }
        }

        @Override // com.tencent.mobileqq.vas.image.d
        public void a(@NotNull Canvas canvas, @NotNull List<? extends Drawable> drawableStack, @Nullable Rect bounds) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(drawableStack, "drawableStack");
            if (canvas.getWidth() != this.preCanvasW || canvas.getHeight() != this.preCanvasH) {
                this.numInfo = null;
                this.iconBounds = null;
                this.numBgBounds = null;
                this.preCanvasW = canvas.getWidth();
                this.preCanvasH = canvas.getHeight();
            }
            canvas.save();
            ColorFilter colorFilter = getColorFilter();
            setColorFilter(null);
            e(canvas);
            int i3 = 0;
            for (Drawable drawable : drawableStack) {
                if (Intrinsics.areEqual(drawable, this.bg)) {
                    Rect rect = this.numBgBounds;
                    Intrinsics.checkNotNull(rect);
                    drawable.setBounds(rect);
                    drawable.draw(canvas);
                } else if (Intrinsics.areEqual(drawable, this.fg)) {
                    Rect rect2 = this.iconBounds;
                    Intrinsics.checkNotNull(rect2);
                    drawable.setBounds(rect2);
                    drawable.draw(canvas);
                } else {
                    NumInfo numInfo = this.numInfo;
                    if (numInfo != null) {
                        float start = numInfo.getStart() + (i3 * (numInfo.getW() + numInfo.getDelX()));
                        drawable.setBounds((int) start, (int) numInfo.getDelY(), (int) (start + numInfo.getW()), (int) (canvas.getHeight() - numInfo.getDelY()));
                        drawable.draw(canvas);
                        i3++;
                    }
                }
            }
            canvas.restore();
            setColorFilter(colorFilter);
        }

        @NotNull
        public abstract Rect b(@NotNull Canvas canvas);

        @NotNull
        public abstract Rect c(@NotNull Canvas canvas);

        @NotNull
        public abstract NumInfo d();
    }

    public AbsLiangNumDrawable(int i3, @NotNull String uin, int i16, @NotNull QQVasUpdateBusiness<?> business, @NotNull View targetView, @NotNull String scene) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.id = i3;
        this.uin = uin;
        this.viewHeight = i16;
        this.business = business;
        this.targetView = targetView;
        this.scene = scene;
        this.loadNum = new AtomicInteger(0);
        this.playNum = new AtomicInteger(0);
        this.loadedListener = new Function1<com.tencent.mobileqq.vas.image.c, Unit>() { // from class: com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable$loadedListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.vas.image.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.mobileqq.vas.image.c drawable) {
                IVasLiangNum.c cVar;
                Intrinsics.checkNotNullParameter(drawable, "drawable");
                cVar = AbsLiangNumDrawable.this.outLoadedListener;
                if (cVar != null) {
                    cVar.a();
                }
                AbsLiangNumDrawable.this.T();
                AbsLiangNumDrawable.this.X();
            }
        };
    }

    private final ImageFileData F() {
        b bVar = (b) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(b.class);
        if (!bVar.isFileExists(this.id)) {
            QLog.w("LiangNumDrawable", 1, this.id + " exists=false");
            bVar.addDownLoadListener(this.id, new Runnable() { // from class: com.tencent.mobileqq.vas.liangnum.a
                @Override // java.lang.Runnable
                public final void run() {
                    AbsLiangNumDrawable.G(AbsLiangNumDrawable.this);
                }
            });
            bVar.startDownload(this.id);
            return null;
        }
        ImageFileData imageFileData = new ImageFileData(null, null, null, 7, null);
        String savePath = bVar.getSavePath(this.id);
        String absolutePath = new File(savePath, "background.png").getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "File(root, NAME_NUM_BG).absolutePath");
        imageFileData.d(absolutePath);
        imageFileData.e(new File(savePath, "icon.png").getAbsolutePath());
        String str = this.uin;
        for (int i3 = 0; i3 < str.length(); i3++) {
            int charAt = str.charAt(i3) - '0';
            imageFileData.c().add(new File(savePath, charAt + ".png").getAbsolutePath());
        }
        return imageFileData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(AbsLiangNumDrawable this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U();
        this$0.R(false);
    }

    private final void R(boolean isAsync) {
        if (isAsync) {
            postSubTask(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable$initData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AbsLiangNumDrawable.this.W();
                }
            });
        } else {
            W();
        }
    }

    static /* synthetic */ void S(AbsLiangNumDrawable absLiangNumDrawable, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            absLiangNumDrawable.R(z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T() {
        if (this.iconW > 0 && this.iconH > 0) {
            return;
        }
        String str = J() + "/icon.png";
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        this.iconW = options.outWidth;
        this.iconH = options.outHeight;
    }

    private final void V(final String imgPath, final boolean reuse, final Function1<? super Drawable, Unit> block) {
        FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(imgPath).i(this.scene).h(new Function1<k, Unit>() { // from class: com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable$preloadImg$drawable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(k kVar) {
                invoke2(kVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull k it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!reuse) {
                    it.I(false);
                }
                it.y(1);
            }
        }).a();
        a16.I(false);
        a16.c0(new Function1<com.tencent.cachedrawable.dynamicdrawable.d, Unit>() { // from class: com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable$preloadImg$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.cachedrawable.dynamicdrawable.d it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (QLog.isDebugVersion()) {
                    QLog.d("LetterSwitchDrawable", 1, "load " + imgPath + " end [" + Thread.currentThread() + "]");
                }
                block.invoke((Drawable) it);
                it.d(new a(this));
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/vas/liangnum/AbsLiangNumDrawable$preloadImg$1$a", "Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "", "onEnd", "onStart", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes20.dex */
            public static final class a implements d.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ AbsLiangNumDrawable f309982a;

                a(AbsLiangNumDrawable absLiangNumDrawable) {
                    this.f309982a = absLiangNumDrawable;
                }

                @Override // com.tencent.cachedrawable.dynamicdrawable.d.a
                public void onEnd() {
                    AtomicInteger atomicInteger;
                    int i3;
                    AtomicInteger atomicInteger2;
                    com.tencent.cachedrawable.dynamicdrawable.d dVar;
                    atomicInteger = this.f309982a.playNum;
                    int incrementAndGet = atomicInteger.incrementAndGet();
                    i3 = this.f309982a.totalImgSize;
                    if (incrementAndGet == i3) {
                        atomicInteger2 = this.f309982a.playNum;
                        atomicInteger2.set(0);
                        Object bgImg = this.f309982a.getBgImg();
                        Intrinsics.checkNotNull(bgImg, "null cannot be cast to non-null type com.tencent.cachedrawable.dynamicdrawable.IDynamicDrawable");
                        ((com.tencent.cachedrawable.dynamicdrawable.d) bgImg).restart();
                        Object fgImg = this.f309982a.getFgImg();
                        if (fgImg instanceof com.tencent.cachedrawable.dynamicdrawable.d) {
                            dVar = (com.tencent.cachedrawable.dynamicdrawable.d) fgImg;
                        } else {
                            dVar = null;
                        }
                        if (dVar != null) {
                            dVar.restart();
                        }
                        for (Object obj : this.f309982a.M()) {
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.cachedrawable.dynamicdrawable.IDynamicDrawable");
                            ((com.tencent.cachedrawable.dynamicdrawable.d) obj).restart();
                        }
                    }
                }

                @Override // com.tencent.cachedrawable.dynamicdrawable.d.a
                public void onStart() {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W() {
        ImageFileData F = F();
        if (F == null) {
            return;
        }
        this.totalImgSize = F.c().size() + 1;
        setFailedDrawableBuild(new Function0() { // from class: com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable$realInit$1
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Void invoke() {
                return null;
            }
        });
        int size = F.c().size();
        Drawable[] drawableArr = new Drawable[size];
        final int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            drawableArr[i16] = com.tencent.mobileqq.vas.image.h.INSTANCE.a();
        }
        a0(drawableArr);
        setTargetDrawableBuild(new Function0<Drawable>() { // from class: com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable$realInit$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Drawable invoke() {
                return AbsLiangNumDrawable.this.N();
            }
        });
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable$realInit$refresh$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (AbsLiangNumDrawable.this.getIsLoadSuccess()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("LetterSwitchDrawable", 2, "all image loaded");
                    }
                    AbsLiangNumDrawable.this.load(false);
                }
            }
        };
        for (Object obj : F.c()) {
            int i17 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            V((String) obj, true, new Function1<Drawable, Unit>() { // from class: com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable$realInit$4$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                    invoke2(drawable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Drawable d16) {
                    AtomicInteger atomicInteger;
                    Intrinsics.checkNotNullParameter(d16, "d");
                    AbsLiangNumDrawable.this.M()[i3] = d16;
                    atomicInteger = AbsLiangNumDrawable.this.loadNum;
                    atomicInteger.incrementAndGet();
                    function0.invoke();
                }
            });
            i3 = i17;
        }
        V(F.getBgPath(), true, new Function1<Drawable, Unit>() { // from class: com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable$realInit$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                invoke2(drawable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Drawable it) {
                AtomicInteger atomicInteger;
                Intrinsics.checkNotNullParameter(it, "it");
                AbsLiangNumDrawable.this.Y(it);
                atomicInteger = AbsLiangNumDrawable.this.loadNum;
                atomicInteger.incrementAndGet();
                function0.invoke();
            }
        });
        String fgPath = F.getFgPath();
        if (fgPath != null) {
            V(fgPath, true, new Function1<Drawable, Unit>() { // from class: com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable$realInit$6$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                    invoke2(drawable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Drawable it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    AbsLiangNumDrawable.this.Z(it);
                    function0.invoke();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X() {
        ViewGroup.LayoutParams layoutParams = this.targetView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(0, 0);
        }
        Pair<Integer, Integer> O = O();
        P.put(Integer.valueOf(this.uin.length()), O);
        layoutParams.width = O.getFirst().intValue();
        layoutParams.height = O.getSecond().intValue();
        this.targetView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: H, reason: from getter */
    public final Drawable getBgImg() {
        return this.bgImg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: I, reason: from getter */
    public final Drawable getFgImg() {
        return this.fgImg;
    }

    @NotNull
    public final String J() {
        String savePath = this.business.getSavePath(this.id);
        Intrinsics.checkNotNullExpressionValue(savePath, "business.getSavePath(id)");
        return savePath;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: K, reason: from getter */
    public final int getIconH() {
        return this.iconH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: L, reason: from getter */
    public final int getIconW() {
        return this.iconW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Drawable[] M() {
        Drawable[] drawableArr = this.letterImgs;
        if (drawableArr != null) {
            return drawableArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("letterImgs");
        return null;
    }

    @NotNull
    public abstract Drawable N();

    @NotNull
    public abstract Pair<Integer, Integer> O();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: P, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Q, reason: from getter */
    public final int getViewHeight() {
        return this.viewHeight;
    }

    public void U() {
        this.loadCallback = this.loadedListener;
        T();
        S(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Y(@Nullable Drawable drawable) {
        this.bgImg = drawable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Z(@Nullable Drawable drawable) {
        this.fgImg = drawable;
    }

    protected final void a0(@NotNull Drawable[] drawableArr) {
        Intrinsics.checkNotNullParameter(drawableArr, "<set-?>");
        this.letterImgs = drawableArr;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NotNull ILoaderSucessCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Function1<AbsLiangNumDrawable, Unit> getLoadCallback() {
        return this.loadCallback;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    /* renamed from: isLoadSucess */
    public boolean getIsLoadSuccess() {
        if (this.loadNum.get() == this.totalImgSize) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasLiangNum.a
    public boolean k(int id5) {
        if (this.id == id5) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.vas.image.c
    public void setLoadedListener(@NotNull Function1<? super com.tencent.mobileqq.vas.image.c, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.loadCallback = block;
    }
}
