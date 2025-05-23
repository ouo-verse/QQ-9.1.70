package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.apollo.view.opengl.GLTextureView;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.panorama.callback.OnPanoramaClickListener;
import cooperation.qzone.panorama.callback.OnPanoramaLoadingListener;
import cooperation.qzone.panorama.callback.PanoramaTouchListener;
import cooperation.qzone.panorama.controller.GyroscopeSensorController;
import cooperation.qzone.panorama.controller.PanoramaRenderer;
import cooperation.qzone.panorama.controller.TouchController;
import cooperation.qzone.panorama.util.PanoramaConfig;

/* loaded from: classes38.dex */
public class PanoramaView extends GLTextureView {
    private PanoramaConfig.Builder builder;
    private Context context;
    private GyroscopeSensorController gyroscopeSensorController;
    private OnPanoramaClickListener onPanoramaClickListener;
    private PanoramaRenderer panoramaRenderer;
    private PanoramaTouchListener panoramaTouchListener;
    private GyroscopeSensorController.SensorChangeListener sensorChangeListener;

    public PanoramaView(Context context) {
        super(context);
        this.panoramaTouchListener = new PanoramaTouchListener() { // from class: cooperation.qzone.panorama.widget.PanoramaView.1
            @Override // cooperation.qzone.panorama.callback.PanoramaTouchListener
            public void onClickListener() {
                if (PanoramaView.this.onPanoramaClickListener != null) {
                    PanoramaView.this.onPanoramaClickListener.onPanoramaClick();
                }
            }

            @Override // cooperation.qzone.panorama.callback.PanoramaTouchListener
            public void onTouchMove(float f16, float f17) {
                PanoramaView.this.changeRotate(f16, f17);
            }

            @Override // cooperation.qzone.panorama.callback.PanoramaTouchListener
            public void onTouchScale(float f16) {
                if (PanoramaView.this.panoramaRenderer != null) {
                    PanoramaView.this.panoramaRenderer.setScale(f16);
                }
            }
        };
        this.sensorChangeListener = new GyroscopeSensorController.SensorChangeListener() { // from class: cooperation.qzone.panorama.widget.PanoramaView.2
            @Override // cooperation.qzone.panorama.controller.GyroscopeSensorController.SensorChangeListener
            public void onSensorChange(float f16, float f17, float f18) {
                PanoramaView.this.changeRotate(f16, f17);
            }
        };
        this.context = context;
    }

    public void changeRenderMode(int i3) {
        PanoramaConfig.Builder builder = this.builder;
        if (builder == null) {
            return;
        }
        builder.setRenderMode(i3);
        setRenderMode(i3);
        if (i3 == 0) {
            this.builder.setOpenGyroscopeSensor(false);
        } else {
            this.builder.setOpenGyroscopeSensor(true);
        }
        if (this.gyroscopeSensorController != null && this.builder.isOpenGyroscopeSensor() && QZoneConfigHelper.t()) {
            this.gyroscopeSensorController.registerGyroscopeListener();
        }
    }

    public void changeRotate(float f16, float f17) {
        PanoramaRenderer panoramaRenderer = this.panoramaRenderer;
        if (panoramaRenderer != null) {
            panoramaRenderer.setRotate(f16, f17);
        }
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.GLTextureView
    public String getRenderThreadName() {
        return "PanoramaViewThread";
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.GLTextureView
    public void onPause() {
        if (this.panoramaRenderer == null || this.builder == null) {
            return;
        }
        super.onPause();
        if (this.gyroscopeSensorController == null || !this.builder.isOpenGyroscopeSensor()) {
            return;
        }
        this.gyroscopeSensorController.unregisterGyroscopeListener();
    }

    public void onRecycled() {
        if (this.panoramaRenderer != null) {
            super.onPause();
            GyroscopeSensorController gyroscopeSensorController = this.gyroscopeSensorController;
            if (gyroscopeSensorController != null) {
                gyroscopeSensorController.unregisterGyroscopeListener();
            }
            PanoramaRenderer panoramaRenderer = this.panoramaRenderer;
            if (panoramaRenderer != null) {
                panoramaRenderer.onRecycled();
            }
        }
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.GLTextureView
    public void onResume() {
        PanoramaConfig.Builder builder;
        if (this.panoramaRenderer == null || (builder = this.builder) == null) {
            return;
        }
        builder.setTextureChange(true);
        super.onResume();
        if (this.gyroscopeSensorController != null && this.builder.isOpenGyroscopeSensor() && QZoneConfigHelper.t()) {
            this.gyroscopeSensorController.registerGyroscopeListener();
        }
    }

    public void setOnPanoramaClickListener(OnPanoramaClickListener onPanoramaClickListener) {
        this.onPanoramaClickListener = onPanoramaClickListener;
    }

    public void startShowPanorama(PanoramaConfig.Builder builder, OnPanoramaLoadingListener onPanoramaLoadingListener) {
        if (builder == null) {
            return;
        }
        this.builder = builder;
        setEGLContextClientVersion(2);
        PanoramaRenderer panoramaRenderer = new PanoramaRenderer(builder, onPanoramaLoadingListener);
        this.panoramaRenderer = panoramaRenderer;
        setRenderer(panoramaRenderer);
        setRenderMode(builder.getRenderMode());
        if (builder.isOpenTouchMove()) {
            setOnTouchListener(new TouchController(this, this.context, this.panoramaTouchListener, builder));
        }
        this.gyroscopeSensorController = new GyroscopeSensorController(this.context, this.sensorChangeListener);
    }

    public PanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.panoramaTouchListener = new PanoramaTouchListener() { // from class: cooperation.qzone.panorama.widget.PanoramaView.1
            @Override // cooperation.qzone.panorama.callback.PanoramaTouchListener
            public void onClickListener() {
                if (PanoramaView.this.onPanoramaClickListener != null) {
                    PanoramaView.this.onPanoramaClickListener.onPanoramaClick();
                }
            }

            @Override // cooperation.qzone.panorama.callback.PanoramaTouchListener
            public void onTouchMove(float f16, float f17) {
                PanoramaView.this.changeRotate(f16, f17);
            }

            @Override // cooperation.qzone.panorama.callback.PanoramaTouchListener
            public void onTouchScale(float f16) {
                if (PanoramaView.this.panoramaRenderer != null) {
                    PanoramaView.this.panoramaRenderer.setScale(f16);
                }
            }
        };
        this.sensorChangeListener = new GyroscopeSensorController.SensorChangeListener() { // from class: cooperation.qzone.panorama.widget.PanoramaView.2
            @Override // cooperation.qzone.panorama.controller.GyroscopeSensorController.SensorChangeListener
            public void onSensorChange(float f16, float f17, float f18) {
                PanoramaView.this.changeRotate(f16, f17);
            }
        };
        this.context = context;
    }
}
