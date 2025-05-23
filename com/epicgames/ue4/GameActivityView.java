package com.epicgames.ue4;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GameActivityView extends TextureView implements TextureView.SurfaceTextureListener, View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener, View.OnTouchListener {
    private static final int DEFAULT_FPS = 30;
    private EventHandler _eventHandler;
    private int currentWorldID;
    public int height;
    private Activity mActivity;
    private boolean mAutoAdjustDeviceOrientation;
    private boolean mEnterAvatarShow;
    private boolean mIsResume;
    private Surface mSurface;
    private boolean mSyncResizeWindow;
    public int width;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface EventHandler {
        void onTouch(GameActivityView gameActivityView, MotionEvent motionEvent);
    }

    public GameActivityView(Activity activity, boolean z16, int i3) {
        super(activity);
        this.mIsResume = false;
        this.currentWorldID = -1;
        this.mEnterAvatarShow = false;
        this.width = -1;
        this.height = -1;
        this.mAutoAdjustDeviceOrientation = false;
        this.mSyncResizeWindow = true;
        setSurfaceTextureListener(this);
        setOnClickListener(this);
        setOnFocusChangeListener(this);
        setOnKeyListener(this);
        setOnTouchListener(this);
        setOpaque(false);
        this.mAutoAdjustDeviceOrientation = z16;
        this.mSyncResizeWindow = true;
        this.currentWorldID = i3;
        this.mActivity = activity;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        UE4.inputEvent(keyEvent);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        Surface surface = new Surface(surfaceTexture);
        this.mSurface = surface;
        UE4.initWindow(surface);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        UE4.terminateWindow(this.mSurface);
        this.mSurface = null;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        Surface surface = new Surface(surfaceTexture);
        this.mSurface = surface;
        UE4.resizeWindow(surface, this.mAutoAdjustDeviceOrientation, this.mSyncResizeWindow);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        UE4.inputEvent(motionEvent);
        EventHandler eventHandler = this._eventHandler;
        if (eventHandler != null) {
            eventHandler.onTouch(this, motionEvent);
            return true;
        }
        return true;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this._eventHandler = eventHandler;
    }

    public GameActivityView(Activity activity, boolean z16) {
        this(activity, z16, 0);
    }

    public GameActivityView(Activity activity) {
        this(activity, false, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z16) {
    }
}
