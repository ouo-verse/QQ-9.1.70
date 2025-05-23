package com.tencent.tav.player;

import android.content.Context;
import android.media.AudioManager;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AudioFocusHelper {
    private AudioManager.OnAudioFocusChangeListener mAudioFocusListener;
    private AudioManager mAudioManager;
    private Context mContext;
    private boolean mIsAudioFocus;
    private Player mPlayer;

    public AudioFocusHelper(Context context, Player player) {
        this.mContext = context;
        this.mPlayer = player;
    }

    private void ensureAudioManager() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        }
    }

    private AudioManager.OnAudioFocusChangeListener getAudioFocusChangeListener() {
        if (this.mAudioFocusListener == null) {
            this.mAudioFocusListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.tencent.tav.player.AudioFocusHelper.1
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public void onAudioFocusChange(int i3) {
                    if (AudioFocusHelper.this.mPlayer == null) {
                        return;
                    }
                    try {
                        if (i3 == -2) {
                            AudioFocusHelper.this.onAudioFocusLoss(true);
                        } else if (i3 == -1) {
                            AudioFocusHelper.this.onAudioFocusLoss(false);
                        } else {
                            if (i3 == 1) {
                                AudioFocusHelper.this.mIsAudioFocus = true;
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            };
        }
        return this.mAudioFocusListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAudioFocusLoss(boolean z16) {
        if (!z16) {
            this.mAudioManager.abandonAudioFocus(this.mAudioFocusListener);
            this.mIsAudioFocus = false;
        }
        Player player = this.mPlayer;
        if (player != null && player.isPlaying()) {
            this.mPlayer.pause();
        }
    }

    public void release() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.mAudioFocusListener);
            this.mAudioManager = null;
            this.mAudioFocusListener = null;
            this.mIsAudioFocus = false;
        }
        if (this.mPlayer != null) {
            this.mPlayer = null;
        }
    }

    public void requestFocus() {
        ensureAudioManager();
        if (!this.mIsAudioFocus) {
            boolean z16 = true;
            if (this.mAudioManager.requestAudioFocus(getAudioFocusChangeListener(), 3, 1) != 1) {
                z16 = false;
            }
            this.mIsAudioFocus = z16;
        }
    }
}
