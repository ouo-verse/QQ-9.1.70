package com.tencent.qqlive.tvkplayer.tools.config;

import androidx.annotation.NonNull;
import java.util.HashMap;

/* loaded from: classes23.dex */
public class TVKMediaPlayerConfig {
    private static final String TAG = "TVKPlayer[TVKMediaPlayerConfig]";

    /* loaded from: classes23.dex */
    public static class PlayerConfig {
        public static final String FORMAT_ID_AUTO = "auto";
        public static final String FORMAT_ID_FLV = "flv";
        public static final String FORMAT_ID_HLS = "hls";
        public static final String FORMAT_MP4 = "mp4";
        public static final String FORMAT_MP4_20MIN = "20min_mp4";
        public static final String FORMAT_MP4_5MIN = "5min_mp4";
        public static boolean ad_use_proxy = true;
        public static boolean allow_start_after_buffering_end_when_seeking = false;
        public static int audio_avsync_strategy = 1;
        public static int audio_jump_log_report_times = 5;
        public static int audio_track_get_latency_strategy = 3;
        public static boolean av1_enable_drop_frame_by_screen_refresh_rate = true;
        public static boolean av1_enable_video_adaptive_framerate = false;
        public static float av1_high_frame_drop_rate_threshold = 0.1f;
        public static float av1_low_frame_rate_threshold = 15.0f;
        public static long bluetooth_latency_threshold_ms = 2000;
        public static int buffer_pool_ad = 6000;
        public static int buffer_pool_avgSize = 6000;
        public static int buffer_pool_higSize = 12000;
        public static int buffer_pool_liveStreaming = 2000;
        public static int buffer_pool_livestreaming_hls_lowdelay = 2000;
        public static int buffer_pool_min_size = 4000;
        public static boolean buffer_report_compact_enable = false;
        public static int buffer_timeout_1080 = 0;
        public static int buffer_timeout_1080_below = 18000;
        public static int buffer_timeout_for_ad_ms = 3000;
        public static long buffering_filter_threshold_ms = 100;
        public static int cache_dns_future_ttl_ms = 10000;
        public static int capability_lower_level_av1 = 1;
        public static int capability_upper_level_av1 = 6;
        public static int capability_upper_level_hevc = 8;
        public static int cgi_max_retry_times = 3;
        public static int cgi_request_timeout_ms = 10000;
        public static boolean chacha20_support_external_audiotrack = true;
        public static boolean china_drm_2_0_enable = true;
        public static boolean china_drm_2_0_l1_enable = false;
        public static String color_management_whitelist = "V2001A,V2005A,V2011A,V1938T,V1962A,V2020A,V1832A,V1913A";
        public static String crop_black_list = "";
        public static String crop_manufacturer_black_list = "HUAWEI";
        public static double da_v_report_sample_rate = 0.0d;
        public static String decoding_capability_report_codec_id_list = "1029";
        public static String decoding_capability_report_decoder_type_list = "102";
        public static int default_polling_report_interval_sec = 300;
        public static int default_tvk_work_thread_priority = -4;
        public static long device_capability_report_delay_time_sec = 30;
        public static double device_capability_report_sample_rate = 0.0d;
        public static String device_capability_report_sub_switches = "";
        public static boolean disable_ad_event_filter = true;
        public static boolean disable_dl_proxy_retry_when_dl_unavailable = true;
        public static boolean disable_surface_pixel_format_with_alpha_channel = true;
        public static String dolby_hard_render_device_black_list = "";
        public static String dolby_player = "self";
        public static String dolby_track_player = "system";
        public static long drm_log_report_drm_prepared_to_player_prepared_threshold_ms = 500;
        public static long drm_log_report_player_preparing_to_drm_preparing_threshold_ms = 300;
        public static boolean enable_audio_renderer_channel_layout_conversion = true;
        public static boolean enable_audio_track_direct_m3u8_output = true;
        public static boolean enable_audio_track_write_stuck_fallback = true;
        public static boolean enable_av1 = true;
        public static boolean enable_av1_error_retry = false;
        public static boolean enable_av1_hardware_decoder = false;
        public static boolean enable_avs3 = true;
        public static boolean enable_avs3_audio_decoder_multi_thread = true;
        public static boolean enable_buffer_size_sync_with_video_dimensions = true;
        public static boolean enable_cdn_url_retry_when_connect_download_proxy_refused = true;
        public static boolean enable_cellular_network_race_when_disconnected = true;
        public static boolean enable_chacha20_stream_insert_ad_cap = true;
        public static boolean enable_china_drm20_stream_insert_ad_cap = true;
        public static boolean enable_color_management = true;
        public static boolean enable_connection_race = true;
        public static boolean enable_create_rich_media = true;
        public static boolean enable_da_v_report = false;
        public static boolean enable_dark_logo = true;
        public static boolean enable_delay_request_userinfo_when_network_unavailable = true;
        public static boolean enable_device_capability_report = false;
        public static boolean enable_dok_check = true;
        public static boolean enable_dolby_audio_mediacodec = true;
        public static boolean enable_dolby_audio_softdecoder = false;
        public static boolean enable_dolby_preview = false;
        public static boolean enable_drop_frame_by_screen_refresh_rate = true;
        public static boolean enable_dvma_softrender = false;
        public static boolean enable_feitian_adaptive_defn_state_report = false;
        public static boolean enable_feitian_audio_effect_report = false;
        public static boolean enable_feitian_audio_timeout_report = false;
        public static boolean enable_feitian_decoding_performance_report = false;
        public static boolean enable_feitian_drm_report = false;
        public static boolean enable_feitian_effect_report = true;
        public static boolean enable_feitian_init_mediacodec_report = false;
        public static boolean enable_feitian_report = true;
        public static boolean enable_ffmpeg_live_hls_first_segment_discontinuity_fix = true;
        public static boolean enable_ffmpeg_log_pthread_local_storage = true;
        public static boolean enable_first_frame_render_when_paused = true;
        public static boolean enable_gaussianblur_effect = true;
        public static boolean enable_h264_fmp4_widevine_stream_insert_ad_cap = true;
        public static boolean enable_hdmi_observing = true;
        public static boolean enable_hdr_downward_compatibility = true;
        public static boolean enable_hdr_dynamic_mapping_config = false;
        public static boolean enable_hdr_vivid_hardware_dynamic_mapping = false;
        public static boolean enable_hdr_vivid_software_dynamic_mapping = false;
        public static boolean enable_headset_observing = false;
        public static boolean enable_hevc = true;
        public static boolean enable_hls_plugin_ad = true;
        public static boolean enable_live_cgi_cache = true;
        public static boolean enable_live_flv = true;
        public static boolean enable_live_flv_downward_retry = false;
        public static boolean enable_live_hdr_vivid = true;
        public static boolean enable_live_period_report = true;
        public static boolean enable_live_rtmp = true;
        public static boolean enable_live_rtmp_downward_retry = false;
        public static boolean enable_live_vvc = false;
        public static boolean enable_logo_draw_hardware = false;
        public static boolean enable_medialab_vr = false;
        public static boolean enable_medialab_vr_report = false;
        public static boolean enable_monet_set_buffers_geometry = true;
        public static boolean enable_monet_tvm_shared_texture = false;
        public static boolean enable_multi_drm_for_china_drm_2_0 = true;
        public static boolean enable_multi_drm_for_widevine = true;
        public static boolean enable_multi_drm_stream_insert_ad_cap = true;
        public static boolean enable_new_capability = true;
        public static boolean enable_new_flv_special_config_parse = true;
        public static boolean enable_new_loopback = true;
        public static boolean enable_new_subtitle_postprocess = true;
        public static boolean enable_opengl_as_default_render = false;
        public static int enable_oppo_system_sr = 0;
        public static boolean enable_pcdn = false;
        public static boolean enable_player_reuse = true;
        public static boolean enable_polling_report = true;
        public static boolean enable_post_process_resource_update = true;
        public static boolean enable_release_media_codec_with_setsurface = true;
        public static boolean enable_renderer_unlimited_retry = true;
        public static boolean enable_report_report_info_from_app = false;
        public static boolean enable_segment_internal_fix = true;
        public static boolean enable_simulated_live_preview = true;
        public static boolean enable_spatial_audio_rendering_all_time = true;
        public static boolean enable_subtitle_track_direct_m3u8_output = true;
        public static boolean enable_tab_config = true;
        public static boolean enable_tvm_super_resolution = true;
        public static boolean enable_uhd_hdrvivid_dynamic_metadata = false;
        public static boolean enable_use_drm_decoder_until_first_encrypted_packet = false;
        public static boolean enable_verbose_surface_callback_log = false;
        public static boolean enable_video_adaptive_framerate = true;
        public static boolean enable_video_metadata_callback = true;
        public static boolean enable_vod_aac_5_1 = true;
        public static boolean enable_vod_animation = true;
        public static boolean enable_vod_audio_vivid = true;
        public static boolean enable_vod_cgi_cache = true;
        public static boolean enable_vod_hdr_vivid = true;
        public static boolean enable_vod_uhd_definition = true;
        public static boolean enable_vod_uhd_high_fps_hdr_vivid = true;
        public static boolean enable_vod_vvc_shd_tvmsr_mutual_execlusion = false;
        public static boolean enable_vvc = false;
        public static boolean enable_worker_thread_looper_hung_detection = false;
        public static boolean enable_xml_vod_cache = true;
        public static int encrypt_ver = 66;
        public static int external_url_get_ad_timeout_sec = 3;
        public static double feitian_decoding_performance_report_sample_ratio = 0.0d;
        public static double feitian_drm_report_sample_ratio = 0.0d;
        public static double feitian_init_mediacodec_report_sample_ratio = 0.0d;
        public static double feitian_report_sample_ratio = 1.0d;
        public static int fetch_remote_config_timeout_ms = 20000;
        public static String frame_rate_test_start_def = "fhd";
        public static String gaussianblur_effect_blacklist = "";
        public static int get_ad_timeout_sec = 10;
        public static boolean get_cpu_arch_from_vm = true;
        public static int ha_crash_reset_interval = 50;
        public static int ha_crash_retry_count = 2;
        public static int ha_crash_retry_interval = 5;
        public static String ha_init_timeout_white_list = "V1934A,V1913A,V2031A,V1831A,V1901A,V1831A,PCAM10,PBAM00,21091116C";
        public static int ha_max_init_timeout_count = 5;
        public static int ha_max_init_timeout_count_for_has_turn_off = 1;
        public static int ha_max_init_timeout_count_for_special_device = 2;
        public static boolean hdcp_capability = false;
        public static boolean hdr10_decode_enable = true;
        public static boolean hdr_enable = true;
        public static boolean hdr_enhance_decode_enable = true;
        public static String hdr_enhance_video_decode_black_list = "";
        public static String hdr_enhance_video_decode_white_list = "";
        public static String hdr_video_decode_black_list = "vivo NEX A,BLA-AL00,SM-G9730,SM-G9750,TNY-AL00,16th,PCDM10,PCDT10,CPH1979,Redmi K20 Pro,BKL-AL20,LYA-AL00,ALP-L29,EVR-AL00,MI 8,SM-G9650,SM-N9600,SM-G9600,SM-N9500,M2006J10C";
        public static String hdr_video_decode_manufacturer_black_list = "";
        public static String hdr_video_decode_white_list = "";
        public static String hdrvivid_black_list = "";
        public static String hdrvivid_mediacodec_white_list = "";
        public static String hdrvivid_white_list = "";
        public static String hevc_player = "self";
        public static boolean high_fps_enable = true;
        public static float high_frame_drop_rate_threshold = 0.2f;
        public static int http_dns_request_type = 0;
        public static boolean is_ad_on = true;
        public static boolean is_allow_decreases_definition = false;
        public static boolean is_allow_prepare_player_when_pre_ad_downloaded = true;
        public static boolean is_api19_480p_below_force_soft = true;
        public static boolean is_cache_video_fenpian = true;
        public static String is_in_new_monet_blacklist = "";
        public static boolean is_logo_position_fixed = true;
        public static boolean is_need_retry_after_live_vvc_failed = false;
        public static boolean is_need_retry_after_vvc_failed = false;
        public static boolean is_one_player_instance = false;
        public static boolean is_only_audio_support = true;
        public static boolean is_support_dolby_audio = true;
        public static boolean is_support_dolby_vision = true;
        public static boolean is_support_multi_audiotrack = true;
        public static boolean is_support_vod_master_m3u8_url_enable = true;
        public static boolean is_thumbplayer_reportv2_on = false;
        public static boolean is_use_cgi_gzip_for_vod = true;
        public static boolean is_use_logo = true;
        public static boolean is_use_mediacodec = true;
        public static boolean is_use_subtitle = true;
        public static boolean is_wifi_use_ipv6 = false;
        public static int least_buffer_size_for_seeking = 0;
        public static boolean live_active_sp_enable = true;
        public static int live_buffer_strategy = -1;
        public static int live_cgi_cached_object_valid_duration_sec = 60;
        public static boolean live_chacha20_enable = true;
        public static boolean live_complete = false;
        public static String live_dolby_player = "self";
        public static String live_hevc_player = "self";
        public static String live_hls_tag_array_list = "#EXT-QQHLS-AD,#EXT-X-PROGRAM-DATE-TIME";
        public static double live_period_report_sample_ratio = 1.0d;
        public static String live_player = "self";
        public static String live_self_soft_hevc_definition = "msd";
        public static int live_self_soft_hevc_least_level = 33;
        public static boolean live_widevine_drm_enable = true;
        public static int log_print_level = 40;
        public static String logo_hardware_accelerate_chip_list = "";
        public static float low_frame_rate_threshold = 15.0f;
        public static float max_framerate_for_decoder_frame_drop_strategy_30fps_or_lower_source = 45.0f;
        public static float max_subtitle_hwsub_size_ratio_for_fullscreen = 6.4f;
        public static float max_subtitle_hwsub_size_ratio_for_portrait = 9.5f;
        public static int media_asset_expire_wait_user_info_update_timeout_ms = 10000;
        public static String media_codec_multi_instance_black_list = "";
        public static long mediacodec_stuck_timeout_ms = 5000;
        public static long min_left_packet_queue_total_duration_ms = 2000;
        public static float min_subtitle_hwsub_size_ratio_for_fullscreen = 5.0f;
        public static float min_subtitle_hwsub_size_ratio_for_portrait = 7.0f;
        public static String monet_set_buffers_geometry_black_list = "";
        public static String monet_tvm_shared_texture_black_list = "";
        public static int no_buffering_interval_to_end = 5000;
        public static long non_bluetooth_latency_threshold_ms = 500;
        public static long non_bluetooth_latency_threshold_ms_for_huawei = 2000;
        public static int offline_get_ad_timeout_sec = 3;
        public static long okhttp_connection_keep_alive_duration_minute = 5;
        public static int pos_ms_seek_tolerance_after = 0;
        public static int pos_ms_seek_tolerance_before = 0;
        public static int position_of_accurate_startpos_ms = 180000;
        public static int position_polling_time_interval_ms = 300;
        public static long post_process_resource_update_delay_ms = 5000;
        public static int prepare_buffer_size_livestreaming = 200;
        public static int prepare_buffer_size_vod = 200;
        public static int prepared_timeout_for_ad_ms = 3000;
        public static int preview_duration_threshold = 5;
        public static boolean qm_enable_pt = false;
        public static boolean qqlive_asset_player_use_proxy = true;
        public static long render_monitor_period_ms = 1000;
        public static long report_log_by_guid_interval = 60000;
        public static boolean report_log_enable = true;
        public static long report_log_first_buffer_threshold_live = 10000;
        public static long report_log_first_buffer_threshold_vod = 10000;
        public static long report_log_getvinfo_duration_threshold_live_ms = 10000;
        public static long report_log_getvinfo_duration_threshold_vod_ms = 10000;
        public static double report_log_sample = 0.0d;
        public static long report_log_second_buffer_time_threshold_live = 10000;
        public static long report_log_second_buffer_time_threshold_vod = 10000;
        public static int report_log_second_buffer_times_count_threshold_live = 3;
        public static int report_log_second_buffer_times_count_threshold_vod = 3;
        public static int report_second_buffer_min_interval_ms = 1200;
        public static boolean report_worker_thread_looper_hung_detail_info = false;
        public static int request_dvma_config_interval_sec = 86400;
        public static boolean reset_decoder_on_def_switch = false;
        public static boolean retry_when_socket_connect_failed = true;
        public static boolean retry_with_back_up_host = true;
        public static int self_player_crash_count_to_switch = 2;
        public static String self_soft_hevc_definition = "msd";
        public static int self_soft_hevc_least_level = 33;
        public static float subtitle_bottom_offset_ratio_for_fullscreen = 4.2f;
        public static float subtitle_bottom_offset_ratio_for_portrait = 5.5f;
        public static float subtitle_hwsub_offset_ratio = 0.54f;
        public static float subtitle_hwsub_size_double = 1.1f;
        public static float subtitle_size_ratio_for_fullscreen = 4.8f;
        public static float subtitle_size_ratio_for_portrait = 5.8f;
        public static String super_resolution_black_list = "";
        public static String super_resolution_chip_white_list = "Kirin990,MSM8996,MSM8976,MSM8998,SM8150";
        public static boolean sync_enable_accurate_startpos = true;
        public static String sync_no_support_model = "";
        public static int sync_player_loss_time = 4000;
        public static int sync_player_low_api = 24;
        public static boolean throw_exception_when_threadpool_reject_execution = false;
        public static int tp_core_audio_decode_thread_priority = 27;
        public static int tp_core_audio_render_thread_priority = 29;
        public static int tp_core_demux_thread_priority = 23;
        public static int tp_core_video_decode_thread_priority = 27;
        public static int tp_core_work_thread_priority = 23;
        public static boolean tp_player_report_enable = false;
        public static int tvk_ad_player_thread_priority = -4;
        public static int tvk_thread_priority_after_modification = -19;
        public static String tvmsr_480p_chip_black_list = "";
        public static String tvmsr_480p_device_black_list = "";
        public static String tvmsr_720p_chip_black_list = "";
        public static String tvmsr_720p_device_black_list = "";
        public static String upload_log_errcode_set = "";
        public static String upload_log_fmt_set = "";
        public static String upload_log_guid_sets = "";
        public static boolean use_cellular_network_retry_when_wifi_request_failed = true;
        public static boolean use_dns_java_resolve_host_name = true;
        public static boolean use_http_dns_when_sys_dns_failed = true;
        public static boolean use_offline_resource_for_quick_play = true;
        public static int video_jump_log_report_times = 5;
        public static boolean vod_avs_enable = false;
        public static boolean vod_avs_signal_subtitle_audio_enable = true;
        public static int vod_buffer_strategy = -1;
        public static int vod_cgi_cached_object_valid_duration_sec = 7200;
        public static int vod_cgi_ea_set = 3;
        public static String vod_fmt = "auto";
        public static boolean vod_m3u8_multi_layer_parse_enable = true;
        public static String vod_player = "auto";
        public static int vod_proxy_authentication_strategy = 1;
        public static boolean vod_vvip_enable = false;
        public static int vvc_level = -1;
        public static String vvc_player = "self";
        public static boolean widevine_drm_enable = true;
        public static String widevine_l1_model_black_list = "";
        public static String widevine_provision_url = "https://www.googleapis.cn/certificateprovisioning/v1/devicecertificates/create?key=AIzaSyB-5OLKTx2iU5mko18DfdwK5611JIjbUhE";
        public static long worker_thread_looper_hung_timeout_ms = 5000;
        public static int zhencai_audio_effect_ver = 4;
        public static boolean zhencaishiting_enable = true;
        public static String zhencaishiting_video_decode_black_list = "";
        public static String zhencaishiting_video_force_framerate__list = "";
        public static boolean zhencaishiting_vod_enable = true;

        static {
            TVKMediaPlayerConfig.initTvSpecialConfig();
            TVKMediaPlayerConfig.initInternationSpecialConfig();
        }
    }

    public static void applePlayerConfig(@NonNull HashMap<String, String> hashMap) {
        TVKConfigFieldSetter.setTVKConfigFields(PlayerConfig.class, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initInternationSpecialConfig() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initTvSpecialConfig() {
    }
}
