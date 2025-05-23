package com.tencent.state.square.chatland.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.Location;
import com.tencent.state.service.ImageService;
import com.tencent.state.service.UniqueImageDisplayer;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.template.data.ClickArea;
import com.tencent.state.template.data.CommonRoomInfo;
import com.tencent.state.template.data.RoomConfig;
import com.tencent.state.template.data.RoomThemeData;
import com.tencent.state.view.SquareImageView;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0096\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012K\u0010\u0004\u001aG\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0005\u0012:\b\u0002\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0011J\u001e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0016J\u000e\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0013J\u0016\u0010&\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010'\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fR@\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000RS\u0010\u0004\u001aG\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/tencent/state/square/chatland/view/ChatLandBackgroundView;", "Lcom/tencent/state/view/SquareImageView;", "context", "Landroid/content/Context;", NodeProps.ON_CLICK, "Lkotlin/Function3;", "Landroid/graphics/Point;", "Lkotlin/ParameterName;", "name", "screenPoint", "mapPoint", "Lcom/tencent/state/square/chatland/view/AreaType;", "areaType", "", "clickInterceptor", "Lkotlin/Function2;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;)V", "preBackgroundScale", "", "preClickMapPoint", "preClickScreenPoint", "roomInfo", "Lcom/tencent/state/template/data/CommonRoomInfo;", "checkPointAreaType", "point", "clickAreas", "", "Lcom/tencent/state/template/data/ClickArea;", "getBackgroundScale", "zoomLevel", "", "isTransparentPixel", "onTouchEvent", "event", "Landroid/view/MotionEvent;", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "scale", "update", "updateZoomLevel", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandBackgroundView extends SquareImageView {
    private static final String TAG = "ChatLandBackgroundView";
    private final Function2<Point, Point, Boolean> clickInterceptor;
    private final Function3<Point, Point, AreaType, Unit> onClick;
    private float preBackgroundScale;
    private Point preClickMapPoint;
    private Point preClickScreenPoint;
    private CommonRoomInfo roomInfo;

    public /* synthetic */ ChatLandBackgroundView(Context context, Function3 function3, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, function3, (i3 & 4) != 0 ? null : function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AreaType checkPointAreaType(Point point, List<ClickArea> clickAreas) {
        for (ClickArea clickArea : clickAreas) {
            if (clickArea.contains(point)) {
                if (clickArea.isClickable()) {
                    return AreaType.CLICKABLE;
                }
                return AreaType.UNCLICKABLE;
            }
        }
        return AreaType.CLICKABLE;
    }

    private final float getBackgroundScale(int zoomLevel) {
        if (zoomLevel == 0 || zoomLevel == 1 || zoomLevel == 2) {
            return 0.25f;
        }
        if (zoomLevel == 3 || zoomLevel != 4) {
            return 0.5f;
        }
        return 0.75f;
    }

    private final boolean isTransparentPixel(Point point) {
        RoomConfig config;
        Location backgroundLocation;
        CommonRoomInfo commonRoomInfo = this.roomInfo;
        if (commonRoomInfo == null || (config = commonRoomInfo.getConfig()) == null || (backgroundLocation = config.getBackgroundLocation()) == null) {
            return true;
        }
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return false;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        return bitmap == null || bitmap.getPixel((int) ((((double) bitmap.getWidth()) * ((double) point.x)) / ((double) backgroundLocation.getWidth())), (int) ((((double) bitmap.getHeight()) * ((double) point.y)) / ((double) backgroundLocation.getHeight()))) == 0;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Point point = new Point((int) event.getX(), (int) event.getY());
        this.preClickMapPoint = point;
        this.preClickScreenPoint = new Point((int) event.getRawX(), (int) event.getRawY());
        if (isTransparentPixel(point)) {
            return false;
        }
        return super.onTouchEvent(event);
    }

    public final void render(float scale) {
        RoomConfig config;
        CommonRoomInfo commonRoomInfo;
        RoomThemeData theme;
        Location backgroundLocation;
        SquareBaseKt.getSquareLog().d(TAG, "render, scale=" + scale);
        this.preBackgroundScale = scale;
        CommonRoomInfo commonRoomInfo2 = this.roomInfo;
        if (commonRoomInfo2 == null || (config = commonRoomInfo2.getConfig()) == null || (commonRoomInfo = this.roomInfo) == null || (theme = commonRoomInfo.getTheme()) == null || (backgroundLocation = config.getBackgroundLocation()) == null) {
            return;
        }
        String background = theme.getBackground();
        if (background.length() == 0) {
            background = config.getBackground().getUrl();
        }
        String str = background;
        float width = backgroundLocation.getWidth() * scale;
        float height = backgroundLocation.getHeight() * scale;
        DisplayImageOptions build = new DisplayImageOptions.Builder().cacheOnDisk(true).displayer(new UniqueImageDisplayer(str)).build();
        ImageService.Companion companion = ImageService.INSTANCE;
        ImageLoader loader = companion.getLoader();
        if (loader != null) {
            loader.cancelDisplayTask(this);
        }
        ImageLoader loader2 = companion.getLoader();
        if (loader2 != null) {
            loader2.displayImage(str, new ImageViewAware(this), build, new ImageSize((int) width, (int) height), null, null);
        }
    }

    public final void update(CommonRoomInfo roomInfo, int zoomLevel) {
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        this.roomInfo = roomInfo;
        final Location backgroundLocation = roomInfo.getConfig().getBackgroundLocation();
        if (backgroundLocation != null) {
            ViewExtensionsKt.updateLayoutParams(this, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandBackgroundView$update$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FrameLayout.LayoutParams receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    receiver.width = Location.this.getWidth();
                    receiver.height = Location.this.getHeight();
                    receiver.topMargin = Location.this.getY();
                    receiver.leftMargin = Location.this.getX();
                }
            });
        }
        render(getBackgroundScale(zoomLevel));
    }

    public final void updateZoomLevel(int zoomLevel) {
        float backgroundScale = getBackgroundScale(zoomLevel);
        if (backgroundScale == this.preBackgroundScale) {
            SquareBaseKt.getSquareLog().d(TAG, "updateZoomLevel, scale not change, scale=" + backgroundScale + ", zoomLevel=" + zoomLevel);
            return;
        }
        render(backgroundScale);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChatLandBackgroundView(Context context, Function3<? super Point, ? super Point, ? super AreaType, Unit> onClick, Function2<? super Point, ? super Point, Boolean> function2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
        this.clickInterceptor = function2;
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.view.ChatLandBackgroundView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Point point;
                List<ClickArea> emptyList;
                RoomConfig config;
                Location backgroundLocation;
                RoomConfig config2;
                Location backgroundLocation2;
                RoomThemeData theme;
                Point point2 = ChatLandBackgroundView.this.preClickMapPoint;
                if (point2 == null || (point = ChatLandBackgroundView.this.preClickScreenPoint) == null) {
                    return;
                }
                Function2 function22 = ChatLandBackgroundView.this.clickInterceptor;
                if (function22 == null || !((Boolean) function22.invoke(point, point2)).booleanValue()) {
                    if (ChatLandBackgroundView.this.roomInfo != null) {
                        CommonRoomInfo commonRoomInfo = ChatLandBackgroundView.this.roomInfo;
                        if (commonRoomInfo == null || (theme = commonRoomInfo.getTheme()) == null || (emptyList = theme.getBackgroundClickAreas()) == null) {
                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                        }
                        AreaType checkPointAreaType = ChatLandBackgroundView.this.checkPointAreaType(point2, emptyList);
                        Function3 function3 = ChatLandBackgroundView.this.onClick;
                        Point point3 = new Point();
                        int i3 = point2.x;
                        CommonRoomInfo commonRoomInfo2 = ChatLandBackgroundView.this.roomInfo;
                        int i16 = 0;
                        point3.x = i3 + ((commonRoomInfo2 == null || (config2 = commonRoomInfo2.getConfig()) == null || (backgroundLocation2 = config2.getBackgroundLocation()) == null) ? 0 : backgroundLocation2.getX());
                        int i17 = point2.y;
                        CommonRoomInfo commonRoomInfo3 = ChatLandBackgroundView.this.roomInfo;
                        if (commonRoomInfo3 != null && (config = commonRoomInfo3.getConfig()) != null && (backgroundLocation = config.getBackgroundLocation()) != null) {
                            i16 = backgroundLocation.getY();
                        }
                        point3.y = i17 + i16;
                        Unit unit = Unit.INSTANCE;
                        function3.invoke(point, point3, checkPointAreaType);
                        return;
                    }
                    SquareBaseKt.getSquareLog().d(ChatLandBackgroundView.TAG, "onClick, roomInfo is null");
                }
            }
        });
    }
}
