package com.tencent.qqlive.module.videoreport.dtreport.audio.data;

import android.support.annotation.Nullable;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioInfoChangeListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioEntity;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AudioDataManager implements IAudioDataManager {
    private static final String TAG = "audio.AudioDataManager";
    private ListenerMgr<IAudioInfoChangeListener> mListener = new ListenerMgr<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        static AudioDataManager sInstance = new AudioDataManager();

        InstanceHolder() {
        }
    }

    public static IAudioDataManager getInstance() {
        return InstanceHolder.sInstance;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.data.IAudioDataManager
    public void bindAudioInfo(Object obj, AudioEntity audioEntity) {
        if (audioEntity == null) {
            audioEntity = new AudioEntity.Builder().setContentId("").setPlayType(-1).build();
        }
        AudioDataStorage.setData(obj, audioEntity);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.data.IAudioDataManager
    @Nullable
    public AudioEntity getAudioInfo(Object obj) {
        AudioEntity data = AudioDataStorage.getData(obj);
        if (data == null) {
            Log.e(TAG, "getAudioInfo(), audioInfo is null, check");
        }
        return data;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.data.IAudioDataManager
    public void registerListener(IAudioInfoChangeListener iAudioInfoChangeListener) {
        this.mListener.register(iAudioInfoChangeListener);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.data.IAudioDataManager
    public void unregisterListener(IAudioInfoChangeListener iAudioInfoChangeListener) {
        this.mListener.unregister(iAudioInfoChangeListener);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.data.IAudioDataManager
    public void updateAudioInfo(final Object obj, @NonNull final AudioEntity audioEntity, @Nullable final Map<String, Object> map) {
        this.mListener.startNotify(new ListenerMgr.INotifyCallback() { // from class: com.tencent.qqlive.module.videoreport.dtreport.audio.data.a
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public final void onNotify(Object obj2) {
                ((IAudioInfoChangeListener) obj2).onAudioInfoChangedStart(obj, audioEntity, map);
            }
        });
        bindAudioInfo(obj, audioEntity);
        this.mListener.startNotify(new ListenerMgr.INotifyCallback() { // from class: com.tencent.qqlive.module.videoreport.dtreport.audio.data.b
            @Override // com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback
            public final void onNotify(Object obj2) {
                ((IAudioInfoChangeListener) obj2).onAudioInfoChangedEnd(obj, audioEntity, map);
            }
        });
    }
}
