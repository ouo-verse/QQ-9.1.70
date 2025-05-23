package com.tencent.hippy.qq.utils.screenshot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.utils.HippyViewUtils;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerListAdapter;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001(\u0018\u0000 C2\u00020\u0001:\u0002CDB\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0016H\u0002J\u001c\u00100\u001a\u00020+2\n\u00101\u001a\u0006\u0012\u0002\b\u0003022\u0006\u0010-\u001a\u00020.H\u0002J$\u00103\u001a\u00020+2\n\u00101\u001a\u0006\u0012\u0002\b\u0003022\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0016H\u0002J2\u00104\u001a\u00020+2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u00106\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00162\n\u00101\u001a\u0006\u0012\u0002\b\u000302H\u0002J\u0016\u00107\u001a\b\u0012\u0002\b\u0003\u0018\u0001022\u0006\u00108\u001a\u00020\"H\u0002J\u0010\u00109\u001a\u00020\u00162\u0006\u00108\u001a\u00020\"H\u0002J\u0010\u0010:\u001a\u00020+2\u0006\u00108\u001a\u00020\"H\u0002J\u0010\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020\nH\u0002J\u0016\u0010=\u001a\u00020+2\u0006\u00108\u001a\u00020\"2\u0006\u0010>\u001a\u00020\u0010J\u0010\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020+H\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u00020(X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010)\u00a8\u0006E"}, d2 = {"Lcom/tencent/hippy/qq/utils/screenshot/ScreenShotHelper;", "", "()V", "FAVORITE_FILE_DIR", "", "kotlin.jvm.PlatformType", "getFAVORITE_FILE_DIR", "()Ljava/lang/String;", "mBitmapList", "Ljava/util/LinkedList;", "Landroid/graphics/Bitmap;", "getMBitmapList", "()Ljava/util/LinkedList;", "mBitmapList$delegate", "Lkotlin/Lazy;", "mCallBack", "Lcom/tencent/hippy/qq/utils/screenshot/ScreenShotHelper$ScreenShotResultCallBack;", "getMCallBack", "()Lcom/tencent/hippy/qq/utils/screenshot/ScreenShotHelper$ScreenShotResultCallBack;", "setMCallBack", "(Lcom/tencent/hippy/qq/utils/screenshot/ScreenShotHelper$ScreenShotResultCallBack;)V", "mCurrentPos", "", "getMCurrentPos", "()I", "setMCurrentPos", "(I)V", "mItemCount", "getMItemCount", "setMItemCount", "mRecyclerViewHeight", "getMRecyclerViewHeight", "setMRecyclerViewHeight", "mRootView", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "mScrollListener", "com/tencent/hippy/qq/utils/screenshot/ScreenShotHelper$mScrollListener$1", "Lcom/tencent/hippy/qq/utils/screenshot/ScreenShotHelper$mScrollListener$1;", "drawBackgroundColor", "", "view", PM.CANVAS, "Landroid/graphics/Canvas;", "height", "drawOtherView", "recyclerViewWrapper", "Lcom/tencent/mtt/hippy/views/hippylist/HippyRecyclerViewWrapper;", "drawRecyclerViewBackgroundColor", "drawScreenShot", "bitmapList", "width", "findRecyclerViewWrapper", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "getTotalHeight", "normalScreenShot", "saveScreenShot", MimeHelper.IMAGE_SUBTYPE_BITMAP, "screenShot", "callBack", "scrollAndCaptureRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "startScreenShot", "Companion", "ScreenShotResultCallBack", "hippy-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class ScreenShotHelper {

    @NotNull
    public static final String BACKGROUND_COLOR = "backgroundColor";
    public static final int RESULT_FAILURE = -1;
    public static final int RESULT_SUCCESS = 0;
    public static final long SCREENTSHOT_DELAY = 100;

    @NotNull
    public static final String SCREEN_HIDDEN = "screenHidden";
    public static final int SCROLL_FINISHED = 1;

    @NotNull
    public static final String TAG = "Hippy.ScreenShotUtil";

    /* renamed from: mBitmapList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mBitmapList;

    @Nullable
    private ScreenShotResultCallBack mCallBack;
    private int mCurrentPos;
    private int mItemCount;
    private int mRecyclerViewHeight;

    @Nullable
    private View mRootView;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String SCREENSHOT_SAVE_PATH = AppConstants.SDCARD_FILE_SAVE_PATH + "Hippy/screenShot/";
    private final String FAVORITE_FILE_DIR = AppConstants.SDCARD_FILE_SAVE_PATH;

    @NotNull
    private final ScreenShotHelper$mScrollListener$1 mScrollListener = new ScreenShotHelper$mScrollListener$1(this);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/hippy/qq/utils/screenshot/ScreenShotHelper$Companion;", "", "()V", "BACKGROUND_COLOR", "", "RESULT_FAILURE", "", "RESULT_SUCCESS", "SCREENSHOT_SAVE_PATH", "getSCREENSHOT_SAVE_PATH", "()Ljava/lang/String;", "SCREENTSHOT_DELAY", "", "SCREEN_HIDDEN", "SCROLL_FINISHED", "TAG", "hippy-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getSCREENSHOT_SAVE_PATH() {
            return ScreenShotHelper.SCREENSHOT_SAVE_PATH;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/hippy/qq/utils/screenshot/ScreenShotHelper$ScreenShotResultCallBack;", "", "callback", "", QzoneIPCModule.RESULT_CODE, "", "filePath", "", "hippy-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public interface ScreenShotResultCallBack {
        void callback(int resultCode, @NotNull String filePath);
    }

    public ScreenShotHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinkedList<Bitmap>>() { // from class: com.tencent.hippy.qq.utils.screenshot.ScreenShotHelper$mBitmapList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinkedList<Bitmap> invoke() {
                return new LinkedList<>();
            }
        });
        this.mBitmapList = lazy;
    }

    private final void drawBackgroundColor(View view, Canvas canvas, int height) {
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        while (view.getParent() != null) {
            Object parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            view = (View) parent;
            HippyViewUtils hippyViewUtils = HippyViewUtils.INSTANCE;
            if (hippyViewUtils.hasBackgroundColor(view)) {
                stack.add(Long.valueOf(hippyViewUtils.getBackgroundColor(view)));
                stack2.add(new Rect(view.getLeft(), view.getTop(), view.getRight(), height));
            }
            if (Intrinsics.areEqual(view, this.mRootView)) {
                break;
            }
        }
        while (!stack.isEmpty() && !stack2.isEmpty()) {
            Paint paint = new Paint();
            paint.setColor((int) ((Number) stack.pop()).longValue());
            canvas.drawRect((Rect) stack2.pop(), paint);
        }
    }

    private final void drawOtherView(HippyRecyclerViewWrapper<?> recyclerViewWrapper, Canvas canvas) {
        if (!(recyclerViewWrapper.getParent() instanceof ViewGroup)) {
            return;
        }
        ViewParent parent = recyclerViewWrapper.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt instanceof HippyRecyclerViewWrapper) {
                return;
            }
            childAt.setDrawingCacheEnabled(true);
            childAt.buildDrawingCache();
            if (childAt.getDrawingCache() != null) {
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(childAt.getDrawingCache());
                    canvas.drawBitmap(createBitmap, (Rect) null, new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom()), (Paint) null);
                    createBitmap.recycle();
                } catch (OutOfMemoryError e16) {
                    QLog.e(TAG, 1, "drawOtherView drawBitmap failed, oom : ", e16);
                }
                childAt.setDrawingCacheEnabled(false);
            }
        }
    }

    private final void drawRecyclerViewBackgroundColor(HippyRecyclerViewWrapper<?> recyclerViewWrapper, Canvas canvas, int height) {
        HippyViewUtils hippyViewUtils = HippyViewUtils.INSTANCE;
        if (hippyViewUtils.hasBackgroundColor(recyclerViewWrapper)) {
            Rect rect = new Rect(recyclerViewWrapper.getLeft(), recyclerViewWrapper.getTop(), recyclerViewWrapper.getRight(), height);
            Paint paint = new Paint();
            paint.setColor((int) hippyViewUtils.getBackgroundColor(recyclerViewWrapper));
            canvas.drawRect(rect, paint);
        }
    }

    private final void drawScreenShot(LinkedList<Bitmap> bitmapList, int width, int height, HippyRecyclerViewWrapper<?> recyclerViewWrapper) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawBackgroundColor(recyclerViewWrapper, canvas, height);
            drawOtherView(recyclerViewWrapper, canvas);
            drawRecyclerViewBackgroundColor(recyclerViewWrapper, canvas, height);
            int top = recyclerViewWrapper.getTop();
            while (!bitmapList.isEmpty()) {
                Bitmap pollFirst = bitmapList.pollFirst();
                if (pollFirst != null) {
                    Rect rect = new Rect(recyclerViewWrapper.getLeft(), top, recyclerViewWrapper.getRight(), pollFirst.getHeight() + top);
                    if (!pollFirst.isRecycled()) {
                        try {
                            canvas.drawBitmap(pollFirst, (Rect) null, rect, (Paint) null);
                            top += pollFirst.getHeight();
                        } catch (Exception e16) {
                            QLog.e(TAG, 1, "drawScreenShot canvas.drawBitmap error, " + e16);
                        }
                        pollFirst.recycle();
                    }
                }
            }
            saveScreenShot(createBitmap);
            createBitmap.recycle();
        } catch (OutOfMemoryError e17) {
            QLog.e(TAG, 1, "drawScreenShot createBitmap failed ,oom : ", e17);
            ScreenShotResultCallBack screenShotResultCallBack = this.mCallBack;
            if (screenShotResultCallBack != null) {
                screenShotResultCallBack.callback(-1, "");
            }
        }
    }

    private final HippyRecyclerViewWrapper<?> findRecyclerViewWrapper(View rootView) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(rootView);
        while (!linkedList.isEmpty()) {
            View view = (View) linkedList.poll();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (viewGroup.getChildAt(i3) instanceof HippyRecyclerViewWrapper) {
                        View childAt = viewGroup.getChildAt(i3);
                        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewWrapper<*>");
                        return (HippyRecyclerViewWrapper) childAt;
                    }
                    linkedList.add(viewGroup.getChildAt(i3));
                }
            }
        }
        return null;
    }

    private final int getTotalHeight(View rootView) {
        ViewParent viewParent;
        HippyRecyclerViewWrapper<?> findRecyclerViewWrapper = findRecyclerViewWrapper(rootView);
        if (findRecyclerViewWrapper != null) {
            viewParent = findRecyclerViewWrapper.getParent();
        } else {
            viewParent = null;
        }
        int i3 = 0;
        if (viewParent instanceof ViewGroup) {
            ViewParent parent = findRecyclerViewWrapper.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            int childCount = viewGroup.getChildCount();
            int i16 = 0;
            while (i3 < childCount && viewGroup.getChildAt(i3).getId() != findRecyclerViewWrapper.getId()) {
                i16 = viewGroup.getChildAt(i3).getBottom();
                i3++;
            }
            i3 = i16;
        }
        return i3 + this.mRecyclerViewHeight;
    }

    private final void normalScreenShot(View rootView) {
        rootView.setDrawingCacheEnabled(true);
        rootView.buildDrawingCache();
        if (rootView.getDrawingCache() == null) {
            ScreenShotResultCallBack screenShotResultCallBack = this.mCallBack;
            if (screenShotResultCallBack != null) {
                screenShotResultCallBack.callback(-1, "");
                return;
            }
            return;
        }
        try {
            Bitmap bitmap = Bitmap.createBitmap(rootView.getDrawingCache());
            Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
            saveScreenShot(bitmap);
            bitmap.recycle();
        } catch (OutOfMemoryError e16) {
            QLog.e(TAG, 1, "normalScreenShot createBitmap failed ,oom : ", e16);
            ScreenShotResultCallBack screenShotResultCallBack2 = this.mCallBack;
            if (screenShotResultCallBack2 != null) {
                screenShotResultCallBack2.callback(-1, "");
            }
        }
    }

    private final void saveScreenShot(Bitmap bitmap) {
        StringBuilder sb5 = new StringBuilder();
        String str = SCREENSHOT_SAVE_PATH;
        sb5.append(str);
        sb5.append("screenshot_");
        sb5.append(System.currentTimeMillis());
        sb5.append(".png");
        String sb6 = sb5.toString();
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(sb6);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            ScreenShotResultCallBack screenShotResultCallBack = this.mCallBack;
            if (screenShotResultCallBack != null) {
                screenShotResultCallBack.callback(0, sb6);
            }
        } catch (Exception e16) {
            ScreenShotResultCallBack screenShotResultCallBack2 = this.mCallBack;
            if (screenShotResultCallBack2 != null) {
                screenShotResultCallBack2.callback(-1, "");
            }
            QLog.e(TAG, 1, "saveScreenShot to file error, " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scrollAndCaptureRecyclerView(RecyclerView recyclerView) {
        View view;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        int i3 = findLastVisibleItemPosition + 1;
        for (int i16 = this.mCurrentPos; i16 < i3; i16++) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i16);
            if (findViewHolderForAdapterPosition != null) {
                view = findViewHolderForAdapterPosition.itemView;
            } else {
                view = null;
            }
            if (view != null && !HippyViewUtils.INSTANCE.isViewScreenHidden(view)) {
                view.setDrawingCacheEnabled(true);
                view.buildDrawingCache();
                if (view.getDrawingCache() != null) {
                    try {
                        getMBitmapList().add(Bitmap.createBitmap(view.getDrawingCache()));
                        this.mRecyclerViewHeight += view.getHeight();
                    } catch (OutOfMemoryError e16) {
                        QLog.e(TAG, 1, "normalScreenShot createBitmap failed ,oom : ", e16);
                    }
                    view.setDrawingCacheEnabled(false);
                }
            }
        }
        this.mCurrentPos = i3;
        if (i3 >= this.mItemCount) {
            recyclerView.removeOnScrollListener(this.mScrollListener);
            startScreenShot();
        } else {
            recyclerView.smoothScrollBy(0, ImmersiveUtils.getScreenHeight() / 2);
        }
    }

    private final void startScreenShot() {
        View view = this.mRootView;
        if (view != null) {
            int totalHeight = getTotalHeight(view);
            HippyRecyclerViewWrapper<?> findRecyclerViewWrapper = findRecyclerViewWrapper(view);
            if (findRecyclerViewWrapper != null) {
                drawScreenShot(getMBitmapList(), view.getWidth(), totalHeight, findRecyclerViewWrapper);
            }
        }
    }

    public final String getFAVORITE_FILE_DIR() {
        return this.FAVORITE_FILE_DIR;
    }

    @NotNull
    public final LinkedList<Bitmap> getMBitmapList() {
        return (LinkedList) this.mBitmapList.getValue();
    }

    @Nullable
    public final ScreenShotResultCallBack getMCallBack() {
        return this.mCallBack;
    }

    public final int getMCurrentPos() {
        return this.mCurrentPos;
    }

    public final int getMItemCount() {
        return this.mItemCount;
    }

    public final int getMRecyclerViewHeight() {
        return this.mRecyclerViewHeight;
    }

    @Nullable
    public final View getMRootView() {
        return this.mRootView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void screenShot(@NotNull View rootView, @NotNull ScreenShotResultCallBack callBack) {
        HippyRecyclerView hippyRecyclerView;
        int i3;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        this.mCallBack = callBack;
        this.mRootView = rootView;
        this.mCurrentPos = 0;
        HippyRecyclerViewWrapper<?> findRecyclerViewWrapper = findRecyclerViewWrapper(rootView);
        Unit unit = null;
        if (findRecyclerViewWrapper != null) {
            hippyRecyclerView = findRecyclerViewWrapper.getRecyclerView();
        } else {
            hippyRecyclerView = null;
        }
        if (hippyRecyclerView != null) {
            HippyRecyclerListAdapter adapter = hippyRecyclerView.getAdapter();
            if (adapter != null) {
                i3 = adapter.getItemCount();
            } else {
                i3 = 0;
            }
            this.mItemCount = i3;
            this.mRecyclerViewHeight = 0;
            hippyRecyclerView.addOnScrollListener(this.mScrollListener);
            if (!hippyRecyclerView.canScrollVertically(-1)) {
                scrollAndCaptureRecyclerView(hippyRecyclerView);
            } else {
                hippyRecyclerView.scrollToTop();
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            normalScreenShot(rootView);
        }
    }

    public final void setMCallBack(@Nullable ScreenShotResultCallBack screenShotResultCallBack) {
        this.mCallBack = screenShotResultCallBack;
    }

    public final void setMCurrentPos(int i3) {
        this.mCurrentPos = i3;
    }

    public final void setMItemCount(int i3) {
        this.mItemCount = i3;
    }

    public final void setMRecyclerViewHeight(int i3) {
        this.mRecyclerViewHeight = i3;
    }

    public final void setMRootView(@Nullable View view) {
        this.mRootView = view;
    }
}
