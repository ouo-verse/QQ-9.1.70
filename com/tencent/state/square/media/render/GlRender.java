package com.tencent.state.square.media.render;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.media.EglHelper;
import com.tencent.state.square.media.utils.GLUtils;
import com.tencent.state.square.media.utils.GlFloatArray;
import com.tencent.state.square.media.utils.PointRect;
import com.tencent.state.square.media.utils.RenderConfig;
import com.tencent.state.square.media.utils.ShaderUtil;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u001aJ\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0006\u0010\u001f\u001a\u00020\u0006J\b\u0010 \u001a\u00020\u001aH\u0002J\u0006\u0010!\u001a\u00020\u001aJ\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0013J\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020\u001aJ*\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/tencent/state/square/media/render/GlRender;", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "(Landroid/graphics/SurfaceTexture;)V", "aPositionLocation", "", "aTextureAlphaLocation", "aTextureRgbLocation", "alphaArray", "Lcom/tencent/state/square/media/utils/GlFloatArray;", "eglUtil", "Lcom/tencent/state/square/media/EglHelper;", "genTexture", "", "rgbArray", "shaderProgram", "surfaceHeight", "surfaceSizeChanged", "", "surfaceWidth", "uTextureLocation", "vertexArray", HippyTKDListViewAdapter.X, "y", "clearFrame", "", "compileShader", "createTexture", "destroy", "draw", "getExternalTexture", "initGL", "releaseTexture", "renderFrame", "isFirstFrame", "setRenderConfig", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/media/utils/RenderConfig;", "swapBuffers", "updateViewPort", "width", "height", "Companion", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class GlRender {
    private static final String TAG = "Square_GLRender";
    private int aPositionLocation;
    private int aTextureAlphaLocation;
    private int aTextureRgbLocation;
    private final GlFloatArray alphaArray;
    private final EglHelper eglUtil;
    private int[] genTexture;
    private final GlFloatArray rgbArray;
    private int shaderProgram;
    private int surfaceHeight;
    private boolean surfaceSizeChanged;
    private int surfaceWidth;
    private int uTextureLocation;
    private final GlFloatArray vertexArray;
    private int x;
    private int y;

    public GlRender(SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        this.vertexArray = new GlFloatArray();
        this.alphaArray = new GlFloatArray();
        this.rgbArray = new GlFloatArray();
        EglHelper eglHelper = new EglHelper();
        this.eglUtil = eglHelper;
        this.genTexture = new int[1];
        eglHelper.start(surfaceTexture);
        initGL();
    }

    private final void compileShader() {
        String str;
        String str2;
        Resources resources;
        AssetManager assets;
        InputStream open;
        String readText;
        Resources resources2;
        AssetManager assets2;
        InputStream open2;
        SquareBase squareBase = SquareBase.INSTANCE;
        Application app = squareBase.getApp();
        String str3 = "";
        if (app == null || (resources2 = app.getResources()) == null || (assets2 = resources2.getAssets()) == null || (open2 = assets2.open("common_vertex.glsl")) == null || (str = TextStreamsKt.readText(new InputStreamReader(open2, Charsets.UTF_8))) == null) {
            str = "";
        }
        if (squareBase.getConfig().getCommonUtils().getShaderUseMulti()) {
            str2 = "common_frag_with_multi.glsl";
        } else {
            str2 = "common_frag.glsl";
        }
        Application app2 = squareBase.getApp();
        if (app2 != null && (resources = app2.getResources()) != null && (assets = resources.getAssets()) != null && (open = assets.open(str2)) != null && (readText = TextStreamsKt.readText(new InputStreamReader(open, Charsets.UTF_8))) != null) {
            str3 = readText;
        }
        int createProgram = ShaderUtil.INSTANCE.createProgram(str, str3);
        this.shaderProgram = createProgram;
        this.uTextureLocation = GLES20.glGetUniformLocation(createProgram, "texture");
        this.aPositionLocation = GLES20.glGetAttribLocation(this.shaderProgram, "vPosition");
        this.aTextureAlphaLocation = GLES20.glGetAttribLocation(this.shaderProgram, "vTexCoordinateAlpha");
        this.aTextureRgbLocation = GLES20.glGetAttribLocation(this.shaderProgram, "vTexCoordinateRgb");
    }

    private final void initGL() {
        compileShader();
    }

    public final void createTexture() {
        int[] iArr = this.genTexture;
        GLES20.glGenTextures(iArr.length, iArr, 0);
        GLES20.glBindTexture(36197, this.genTexture[0]);
        GLES20.glTexParameterf(36197, 10241, 9728);
        GLES20.glTexParameterf(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
    }

    public final void destroy() {
        releaseTexture();
        this.eglUtil.release();
    }

    public final int getExternalTexture() {
        return this.genTexture[0];
    }

    public final void releaseTexture() {
        int[] iArr = this.genTexture;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
    }

    public final void renderFrame(boolean isFirstFrame) {
        boolean z16 = this.surfaceSizeChanged && this.surfaceWidth > 0 && this.surfaceHeight > 0;
        if (z16) {
            this.surfaceSizeChanged = false;
            GLES20.glViewport(this.x, this.y, this.surfaceWidth, this.surfaceHeight);
            SquareBaseKt.getSquareLog().i(TAG, "renderFrame glViewport: w=" + this.surfaceWidth + ", h=" + this.surfaceHeight);
        }
        if (isFirstFrame || !z16) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            draw();
        }
    }

    public final void setRenderConfig(RenderConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        GLUtils gLUtils = GLUtils.INSTANCE;
        this.vertexArray.setArray(gLUtils.createVertex(config.getWidth(), config.getHeight(), new PointRect(0, 0, config.getWidth(), config.getHeight()), this.vertexArray.getArray()));
        float[] createTextureVertex = gLUtils.createTextureVertex(config.getVideoWidth(), config.getVideoHeight(), config.getAlphaRect(), this.alphaArray.getArray());
        float[] createTextureVertex2 = gLUtils.createTextureVertex(config.getVideoWidth(), config.getVideoHeight(), config.getRgbRect(), this.rgbArray.getArray());
        this.alphaArray.setArray(createTextureVertex);
        this.rgbArray.setArray(createTextureVertex2);
    }

    public final void swapBuffers() {
        this.eglUtil.swapBuffers();
    }

    public final void clearFrame() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        this.eglUtil.swapBuffers();
    }

    private final void draw() {
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        GLES20.glUseProgram(this.shaderProgram);
        this.vertexArray.setVertexAttribPointer(this.aPositionLocation);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.genTexture[0]);
        GLES20.glUniform1i(this.uTextureLocation, 0);
        this.alphaArray.setVertexAttribPointer(this.aTextureAlphaLocation);
        this.rgbArray.setVertexAttribPointer(this.aTextureRgbLocation);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisable(3042);
    }

    public final void updateViewPort(int width, int height, int x16, int y16) {
        if (width <= 0 || height <= 0) {
            return;
        }
        this.surfaceSizeChanged = true;
        this.surfaceWidth = width;
        this.surfaceHeight = height;
        this.x = x16;
        this.y = y16;
    }

    public static /* synthetic */ void updateViewPort$default(GlRender glRender, int i3, int i16, int i17, int i18, int i19, Object obj) {
        if ((i19 & 4) != 0) {
            i17 = 0;
        }
        if ((i19 & 8) != 0) {
            i18 = 0;
        }
        glRender.updateViewPort(i3, i16, i17, i18);
    }
}
