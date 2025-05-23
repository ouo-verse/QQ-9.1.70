package com.tencent.qcircle.weseevideo.model.template.light;

import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieSegmentModel;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.MovieController;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LightTemplate implements Serializable {
    private static final String TAG = "LightTemplate";
    private String mFilePath;
    private LightAsset mLightAsset;
    private LightEngine mLightEngine;
    private MovieController mMovieController;
    private TextureInfo textureInfo;
    private ArrayList<MovieSegmentModel> mSegmentModels = new ArrayList<>();
    private boolean mNeedCycleFill = false;
    private CGSize renderSize = new CGSize(720.0f, 1280.0f);
    private long mDuration = 0;
    private HashMap<String, RectF> mBoundsRect = new HashMap<>();
    private boolean isNoDurationLimitTemplate = false;

    public LightTemplate(@NonNull String str) {
        initData(str);
    }

    public HashMap<String, RectF> getBoundsRect() {
        return this.mBoundsRect;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public LightAsset getLightAsset() {
        return this.mLightAsset;
    }

    @NotNull
    public LightEngine getLightEngine() {
        return this.mLightEngine;
    }

    public ArrayList<MovieSegmentModel> getLightSegments() {
        return this.mSegmentModels;
    }

    @NotNull
    public MovieController getMovieController() {
        return this.mMovieController;
    }

    @NotNull
    public CGSize getRenderSize() {
        return this.renderSize;
    }

    public List<MovieSegmentModel> getSegments() {
        return this.mSegmentModels;
    }

    public TextureInfo getTextureInfo() {
        return this.textureInfo;
    }

    @VisibleForTesting
    protected void initData(@NonNull String str) {
        this.mFilePath = str;
        if (TextUtils.isEmpty(str)) {
            Logger.e(TAG, "LightTemplate initData failed. template file path is empty!! ");
            return;
        }
        LightAsset Load = LightAsset.Load(this.mFilePath, 100);
        this.mLightAsset = Load;
        if (Load == null) {
            Logger.e(TAG, "LightAsset.Load return null! mFilePath=" + this.mFilePath);
            return;
        }
        this.renderSize = new CGSize(this.mLightAsset.width(), this.mLightAsset.height());
    }

    public boolean isNoDurationLimitTemplate() {
        return this.isNoDurationLimitTemplate;
    }

    public void setDuration(long j3) {
        this.mDuration = j3;
    }

    public void setFilePath(String str) {
        this.mFilePath = str;
    }

    public void setLightEngine(LightEngine lightEngine) {
        this.mLightEngine = lightEngine;
    }

    public void setLightSegments(ArrayList<MovieSegmentModel> arrayList) {
        this.mSegmentModels = arrayList;
    }

    public void setMovieController(MovieController movieController) {
        this.mMovieController = movieController;
    }

    public void setNoDurationLimitTemplate(boolean z16) {
        this.isNoDurationLimitTemplate = z16;
    }

    public void setRenderSize(CGSize cGSize) {
        this.renderSize = cGSize;
    }

    public void setSegments(List<MovieSegmentModel> list) {
        if (list != null && !list.isEmpty()) {
            this.mSegmentModels.clear();
            this.mSegmentModels.addAll(list);
        }
    }

    public void setTextureInfo(TextureInfo textureInfo) {
        this.textureInfo = textureInfo;
    }
}
