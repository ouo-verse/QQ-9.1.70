package com.tencent.ad.tangram.views.canvas.components.pictures;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.components.picture.AdCanvasPictureComponentData;
import com.tencent.ad.tangram.views.canvas.components.picture.AdCanvasPictureComponentView;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class AdCanvasMultiPictureComponentView extends AdCanvasComponentView {
    private static final String TAG = "GdtCanvasPictureComponentView";
    private List<AdCanvasPictureComponentView> adCanvasPictureComponentViews;

    @Nullable
    private AdCanvasMultiPictureComponentData data;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class MyOnTouchListener implements View.OnTouchListener {
        private AdCanvasPictureComponentData canvasPictureComponentData;

        @NonNull
        private GestureDetector.OnGestureListener listener = new GestureDetector.OnGestureListener() { // from class: com.tencent.ad.tangram.views.canvas.components.pictures.AdCanvasMultiPictureComponentView.MyOnTouchListener.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }
        };
        private final GestureDetector gestureDetector = new GestureDetector(this.listener);

        public MyOnTouchListener(AdCanvasPictureComponentData adCanvasPictureComponentData) {
            this.canvasPictureComponentData = adCanvasPictureComponentData;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.gestureDetector.onTouchEvent(motionEvent);
        }
    }

    public AdCanvasMultiPictureComponentView(@NonNull Context context, WeakReference<AdCanvasViewListener> weakReference, AdCanvasMultiPictureComponentData adCanvasMultiPictureComponentData) {
        super(context, weakReference);
        init(context, adCanvasMultiPictureComponentData, null);
    }

    private void init(Context context, @Nullable AdCanvasMultiPictureComponentData adCanvasMultiPictureComponentData, Handler handler) {
        if (adCanvasMultiPictureComponentData != null && adCanvasMultiPictureComponentData.isValid()) {
            this.adCanvasPictureComponentViews = new ArrayList();
            this.data = adCanvasMultiPictureComponentData;
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setGravity(1);
            linearLayout.setOrientation(1);
            addView(linearLayout);
            setPadding(getData().paddingLeft, getData().paddingTop, getData().paddingRight, getData().paddingBottom);
            Iterator<AdCanvasPictureComponentData> it = this.data.imageList.iterator();
            while (it.hasNext()) {
                AdCanvasPictureComponentData next = it.next();
                if (next != null) {
                    AdCanvasPictureComponentView adCanvasPictureComponentView = new AdCanvasPictureComponentView(getContext(), this.canvasViewListener, (AdCanvasPictureComponentData) AdCanvasPictureComponentData.class.cast(next), new MyOnTouchListener(next), handler);
                    linearLayout.addView(adCanvasPictureComponentView);
                    this.adCanvasPictureComponentViews.add(adCanvasPictureComponentView);
                }
            }
        }
    }

    public List<AdCanvasPictureComponentView> getAdCanvasPictureComponentViews() {
        return this.adCanvasPictureComponentViews;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdViewStatus getStatus() {
        return this.status;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    public void onLocationChanged() {
        super.onLocationChanged();
        List<AdCanvasPictureComponentView> list = this.adCanvasPictureComponentViews;
        if (list != null) {
            for (AdCanvasPictureComponentView adCanvasPictureComponentView : list) {
                if (adCanvasPictureComponentView != null) {
                    adCanvasPictureComponentView.onLocationChanged();
                }
            }
        }
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdCanvasMultiPictureComponentData getData() {
        return this.data;
    }

    public AdCanvasMultiPictureComponentView(@NonNull Context context, WeakReference<AdCanvasViewListener> weakReference, AdCanvasMultiPictureComponentData adCanvasMultiPictureComponentData, Handler handler) {
        super(context, weakReference);
        init(context, adCanvasMultiPictureComponentData, handler);
    }
}
