package com.wx.voice.vad;

import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;

/* loaded from: classes22.dex */
public class WXVadParam {
    public int mode;
    public int offline_max_spk_time;
    public int offline_min_nspk_time;
    public int offline_min_process_time;
    public int offline_min_sil_time;
    public int offline_min_spk_time;
    public int offline_padding_btime;
    public int offline_padding_etime;
    public boolean offline_remove_sil;
    public int offline_rtcmode;
    public int online_begin_confirm_time;
    public int online_begin_padding_ms;
    public int online_begin_win;
    public float online_cross_zero_thresh;
    public float online_end_sil_decrease_slope;
    public float online_energy_thresh;
    public int online_max_spk_time;
    public int online_output_data_size;
    public int online_rtcmode;
    public int online_sil_timeout;
    public int opt_spk_time;
    public int sample_rate;

    public void GMMVADParam() {
        this.mode = 0;
        this.sample_rate = 16000;
        this.opt_spk_time = 20000;
        this.online_max_spk_time = 50000;
        this.online_begin_win = 500;
        this.online_begin_confirm_time = ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID;
        this.online_sil_timeout = 300;
        this.online_energy_thresh = 10.0f;
        this.online_cross_zero_thresh = 0.01f;
        this.online_begin_padding_ms = 80;
        this.online_rtcmode = 2;
        this.online_output_data_size = 1280;
        this.online_end_sil_decrease_slope = -0.01f;
        this.offline_min_spk_time = 80;
        this.offline_max_spk_time = 60000;
        this.offline_min_nspk_time = 80;
        this.offline_remove_sil = true;
        this.offline_padding_btime = 100;
        this.offline_padding_etime = 100;
        this.offline_min_process_time = 1000;
        this.offline_min_sil_time = 300;
        this.offline_rtcmode = 2;
    }
}
