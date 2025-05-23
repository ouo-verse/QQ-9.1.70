package com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig;

import android.graphics.PointF;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class TVKeyMapMsg {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface IKeyMapConfigRespListener {
        void onRespConfigLoadSuccess(KeyMapConfigManager keyMapConfigManager, boolean z16, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class PassInputDevice {
        int pass_level = 0;
        int product_id = 0;
        int vendor_id = 0;
        String device_name = null;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class TVCloudDeviceConfig {
        int[] init_cloud_device_ids;
        int map_mode = 0;
        boolean is_check_device_map_index = false;
        int create_cloud_device_flag = 0;
        int connected_gamepad_create_max_size = 0;
        int connected_tv_controller_create_max_size = 0;
        int added_gamepad_create_max_size = 0;
        int added_tv_controller_create_max_size = 0;
        boolean is_unique_device_by_vendor_product = true;
        boolean is_pass_product_0_vendor_0 = true;
        boolean is_pass_product_1_vendor_1 = true;
        List<PassInputDevice> pass_input_devices = null;

        public TVCloudDeviceConfig() {
            this.init_cloud_device_ids = r1;
            int[] iArr = {0};
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class TVMsg {
        int code = 0;

        /* renamed from: msg, reason: collision with root package name */
        String f108158msg = null;
        TVMsgGameConfig data = null;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class TVMsgGameConfig {
        boolean gamepad_perf_monitor_enable;
        String version = null;
        String game_id = null;
        boolean tgpa_support = false;
        boolean scenes_monitor_enable = false;
        boolean gamepad_private_data_enable = false;
        boolean gamepad_pid_vid_enable = false;
        boolean key_tracking_enable = false;
        int[] product_ids = null;
        int[] vendor_ids = null;
        int game_type = 0;
        int game_type_bit = 0;
        int virtual_gamepad_type = 0;
        int is_necessary_to_login = 0;
        int max_number_of_player = 0;
        List<TVMsgSceneConfig> scene_list = null;
        int native_input_protocol_type = 0;
        TVCloudDeviceConfig cloud_device_config = null;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class TVMsgJoyKeyCancelConfig {
        int btn_type = 0;
        String data_type = null;
        List<PointF> pos = null;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class TVMsgKeyConfig {
        int type = 0;
        boolean is_valid = false;
        boolean is_show = false;
        int[] key_codes = null;
        String key_name = "init";
        float percent_x = 0.0f;
        float percent_y = 0.0f;
        int radius = 0;
        float sensitivity = 1.0f;
        String path = null;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class TVMsgKeyConfig4Choose {

        /* renamed from: id, reason: collision with root package name */
        int f108159id = 0;
        String name = "init";
        float width = 0.0f;
        float height = 0.0f;
        int left = 0;
        int right = 0;

        /* renamed from: up, reason: collision with root package name */
        int f108160up = 0;
        int down = 0;

        /* renamed from: x, reason: collision with root package name */
        float f108161x = 0.0f;

        /* renamed from: y, reason: collision with root package name */
        float f108162y = 0.0f;
        float percent_x = 0.0f;
        float percent_y = 0.0f;
        int[] key_codes = null;
        boolean select = false;
        float[] confirm = null;
        String desc = null;
        boolean is_switch_show = false;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class TVMsgMoveKeyItem {
        int type = 9;
        boolean is_valid = false;
        int key_code = 0;
        String key_name = "init";
        float percent_x = 0.0f;
        float percent_y = 0.0f;
        int move_direction = 0;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class TVMsgSceneConfig {

        /* renamed from: id, reason: collision with root package name */
        int f108163id = 0;
        String key_scene = "init";
        int map_type = 0;
        boolean tgpa_valid = false;
        int tgpa_primary_index = 0;
        String[] tgpa_sceneIds = null;
        int key_combination_keyCode = 0;
        float touch_map_pos_x = 0.0f;
        float touch_map_pos_y = 0.0f;
        float touch_map_sensitivity_x = 1.0f;
        float touch_map_sensitivity_y = 1.0f;
        float sgame_skills_cancel_pos_x = 0.0f;
        float sgame_skills_cancel_pos_y = 0.0f;
        boolean joystick_to_move_enable = false;
        List<TVMsgKeyConfig> config = null;
        List<TVMsgKeyConfig4Choose> config_for_choose = null;
        List<TVMsgMoveKeyItem> move_key_items = null;
        List<TVMsgJoyKeyCancelConfig> joy_key_cancel_config = null;
    }
}
