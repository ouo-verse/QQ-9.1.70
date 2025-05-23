package com.tencent.qqlive.module.videoreport.dtreport.audio.data;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AudioEntity {
    private static final String TAG = "AudioEntity";
    private Map<String, Object> audioCustomParams;
    private String contentId;
    private int playType;
    private WeakReference<Object> weakPage;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface AudioPlayType {
        public static final int AUTO_PLAY_TYPE = 1;
        public static final int NONE_PLAY_TYPE = -1;
        public static final int USER_PLAY_TYPE = 2;
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Builder {
        private Map<String, Object> audioCustomParams;
        private String contentId;
        private int playType;
        private WeakReference<Object> weakPage;

        public Builder addCustomParam(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            if (this.audioCustomParams == null) {
                this.audioCustomParams = new HashMap(1);
            }
            this.audioCustomParams.put(str, obj);
            return this;
        }

        public Builder addCustomParams(Map<String, ?> map) {
            if (map == null) {
                return this;
            }
            if (this.audioCustomParams == null) {
                this.audioCustomParams = new HashMap(1);
            }
            this.audioCustomParams.putAll(map);
            return this;
        }

        public AudioEntity build() {
            AudioEntity audioEntity = new AudioEntity();
            audioEntity.contentId = this.contentId;
            audioEntity.playType = this.playType;
            audioEntity.weakPage = this.weakPage;
            audioEntity.audioCustomParams = this.audioCustomParams;
            return audioEntity;
        }

        public Builder removeAllCustomParams() {
            Map<String, Object> map = this.audioCustomParams;
            if (map != null) {
                map.clear();
            }
            return this;
        }

        public Builder removeCustomParam(String str) {
            Map<String, Object> map = this.audioCustomParams;
            if (map != null) {
                map.remove(str);
            }
            return this;
        }

        public Builder setContentId(String str) {
            this.contentId = str;
            return this;
        }

        public Builder setPage(Object obj) {
            if (obj == null) {
                return this;
            }
            this.weakPage = new WeakReference<>(obj);
            return this;
        }

        public Builder setPlayType(int i3) {
            this.playType = i3;
            return this;
        }
    }

    public void appendParams(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        if (this.audioCustomParams == null) {
            this.audioCustomParams = new HashMap();
        }
        this.audioCustomParams.putAll(map);
    }

    public Map<String, Object> getAudioCustomParams() {
        return this.audioCustomParams;
    }

    public String getContentId() {
        return this.contentId;
    }

    @Nullable
    public Object getPageObject() {
        WeakReference<Object> weakReference = this.weakPage;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getPlayType() {
        return this.playType + "";
    }

    public boolean isSameAudio(AudioEntity audioEntity) {
        if (!TextUtils.isEmpty(getContentId()) && audioEntity != null && getContentId().equals(audioEntity.getContentId())) {
            return true;
        }
        return false;
    }

    public void mergeOldParams(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        if (this.audioCustomParams == null) {
            this.audioCustomParams = new HashMap();
        }
        Set<String> keySet = map.keySet();
        keySet.removeAll(this.audioCustomParams.keySet());
        for (String str : keySet) {
            this.audioCustomParams.put(str, map.get(str));
        }
    }

    public String toString() {
        Object obj;
        if (!VideoReportInner.getInstance().isDebugMode()) {
            return super.toString();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("AudioInfo:");
        sb5.append("contentId:");
        sb5.append(this.contentId);
        sb5.append("\n");
        sb5.append("playType:");
        sb5.append(this.playType);
        sb5.append("\n");
        WeakReference<Object> weakReference = this.weakPage;
        if (weakReference == null) {
            obj = "null";
        } else {
            obj = weakReference.get();
        }
        if (obj != null) {
            sb5.append(obj.toString());
        } else {
            sb5.append("page is null");
            sb5.append("\n");
        }
        return sb5.toString();
    }

    AudioEntity() {
        this.playType = -1;
    }
}
