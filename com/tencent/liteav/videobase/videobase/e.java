package com.tencent.liteav.videobase.videobase;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<a, Integer> f119413a = new HashMap<a, Integer>() { // from class: com.tencent.liteav.videobase.videobase.e.1
        {
            put(a.ERR_CODE_NONE, 0);
            put(a.ERR_VIDEO_CAPTURE_EGL_CORE_CREATE_FAILED, -1301);
            put(a.ERR_VIDEO_CAPTURE_OPENGL_ERROR, -1301);
            put(a.ERR_VIDEO_CAPTURE_CAMERA_NOT_AUTHORIZED, -1314);
            put(a.ERR_VIDEO_CAPTURE_CAMERA_INVALID_DEVICE, -1301);
            put(a.ERR_VIDEO_CAPTURE_SCREEN_CAPTURE_START_FAILED, -1308);
            put(a.ERR_VIDEO_CAPTURE_SCREEN_UNSUPPORTED, -1309);
            put(a.ERR_VIDEO_CAPTURE_SCREEN_UNAUTHORIZED, -1308);
            put(a.ERR_VIDEO_ENCODE_FATALERROR, -1303);
            put(a.ERR_VIDEO_ENCODE_FAIL, -1303);
            put(a.ERR_VIDEO_NO_AVAILABLE_HEVC_DECODERS, -2304);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private static final Map<c, Integer> f119414b = new HashMap<c, Integer>() { // from class: com.tencent.liteav.videobase.videobase.e.2
        {
            put(c.WARNING_VIDEO_ENCODE_EGL_CORE_CREATE_FAILED, 1103);
            put(c.WARNING_VIDEO_ENCODE_START_FAILED_INSUFFICIENT_RESOURCE, 1103);
            put(c.WARNING_VIDEO_ENCODE_START_FAILED, 1103);
            put(c.WARNING_VIDEO_ENCODE_SWAP_BUFFER, 1103);
            put(c.WARNING_VIDEO_RENDER_EGL_CORE_CREATE_FAILED, 2110);
            put(c.WARNING_VIDEO_RENDER_EGL_CORE_DESTROY_FAILED, 2110);
            put(c.WARNING_VIDEO_RENDER_SWAP_BUFFER, 2110);
            put(c.WARNING_VIDEO_DECODE_EGL_CORE_CREATE_FAILED, 2106);
            put(c.WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_ARGUMENT, 2106);
            put(c.WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_STATE, 2106);
            put(c.WARNING_VIDEO_DECODE_START_FAILED_INSUFFICIENT_RESOURCE, 2106);
            put(c.WARNING_VIDEO_DECODE_START_FAILED_OUT_OF_MEMORY, 2106);
            put(c.WARNING_VIDEO_DECODE_START_FAILED, 2106);
            put(c.WARNING_VIDEO_DECODE_RESTART_WHEN_DECODE_ERROR, 2101);
            put(c.WARNING_VIDEO_DECODE_ERROR_NOT_SUPPORT_PIXEL_FORMAT_TYPE, 2101);
            put(c.WARNING_VIDEO_DECODE_FATAL_ERROR, 2101);
            put(c.WARNING_OUT_OF_MEMORY, 1113);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private static final Map<b, Integer> f119415c = new HashMap<b, Integer>() { // from class: com.tencent.liteav.videobase.videobase.e.3
        {
            put(b.EVT_VIDEO_DECODE_HW_TO_SW_DECODE_COST_TOO_HIGH, 2108);
            put(b.EVT_VIDEO_DECODE_HW_TO_SW_REMOTE_VIDEO_ENABLE_RPS, 2108);
            put(b.EVT_VIDEO_DECODE_HW_TO_SW_MEDIACODEC_NOT_WORK, 2108);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private static final Map<b, Integer> f119416d = new HashMap<b, Integer>() { // from class: com.tencent.liteav.videobase.videobase.e.4
        {
            put(b.EVT_VIDEO_DECODE_FIRST_FRAME_DECODED, 10000);
            put(b.EVT_VIDEO_RENDER_FIRST_FRAME_ON_VIEW, 10004);
            put(b.EVT_VIDEO_EVENT_REQUEST_KEY_FRAME, 10005);
            put(b.EVT_VIDEO_RENDER_FIRST_FRAME, 10001);
            put(b.EVT_VIDEO_DECODE_TYPE_CHANGE, 10002);
            put(b.EVT_VIDEO_RENDER_RESOLUTION_CHANGE, 10003);
            put(b.EVT_VIDEO_CAPTURE_FIRST_FRAME, 20000);
            put(b.EVT_VIDEO_CAPTURE_CAMERA_START_SUCCESS, 30001);
            put(b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_START_SUCCESS, 30002);
            put(b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_STOP_SUCCESS, 30003);
            put(b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_INTERRUPTED, 30004);
            put(b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_RESUME, 30005);
            put(b.EVT_VIDEO_ENCODE_START_SUCCESS, 40001);
            put(b.EVT_VIDEO_CAPTURE_CAMERA_STUCK, 50001);
            put(b.EVT_VIDEO_HARDWARE_ENCODER_STUCK, 50002);
            put(b.EVT_VIDEO_HARDWARE_DECODER_STUCK, 50003);
        }
    };

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum a {
        ERR_CODE_NONE(0),
        ERR_VIDEO_CAPTURE_EGL_CORE_CREATE_FAILED(100),
        ERR_VIDEO_CAPTURE_OPENGL_ERROR(101),
        ERR_VIDEO_CAPTURE_CAMERA_INVALID_DEVICE(110),
        ERR_VIDEO_CAPTURE_CAMERA_NOT_AUTHORIZED(111),
        ERR_VIDEO_CAPTURE_SCREEN_CAPTURE_START_FAILED(120),
        ERR_VIDEO_CAPTURE_SCREEN_UNAUTHORIZED(121),
        ERR_VIDEO_CAPTURE_SCREEN_UNSUPPORTED(122),
        ERR_VIDEO_ENCODE_FATALERROR(200),
        ERR_VIDEO_ENCODE_FAIL(201),
        ERR_VIDEO_NO_AVAILABLE_HEVC_DECODERS(300);

        private final int mValue;

        a(int i3) {
            this.mValue = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum b {
        EVT_CODE_NONE,
        EVT_VIDEO_DECODE_HW_TO_SW_DECODE_COST_TOO_HIGH,
        EVT_VIDEO_DECODE_HW_TO_SW_REMOTE_VIDEO_ENABLE_RPS,
        EVT_VIDEO_DECODE_HW_TO_SW_MEDIACODEC_NOT_WORK,
        EVT_VIDEO_DECODE_FIRST_FRAME_DECODED,
        EVT_VIDEO_RENDER_FIRST_FRAME,
        EVT_VIDEO_DECODE_TYPE_CHANGE,
        EVT_VIDEO_RENDER_RESOLUTION_CHANGE,
        EVT_VIDEO_RENDER_FIRST_FRAME_ON_VIEW,
        EVT_VIDEO_EVENT_REQUEST_KEY_FRAME,
        EVT_VIDEO_CAPTURE_FIRST_FRAME,
        EVT_VIDEO_CAPTURE_CAMERA_START_SUCCESS,
        EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_START_SUCCESS,
        EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_STOP_SUCCESS,
        EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_INTERRUPTED,
        EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_RESUME,
        EVT_VIDEO_ENCODE_START_SUCCESS,
        EVT_VIDEO_CAPTURE_CAMERA_STUCK,
        EVT_VIDEO_HARDWARE_ENCODER_STUCK,
        EVT_VIDEO_HARDWARE_DECODER_STUCK,
        EVT_VIDEO_CAPTURE_VIRTUAL_CAMERA_SIZE_CHANGE_SUCCESS,
        EVT_VIDEO_CAPTURE_VIRTUAL_CAMERA_START_SUCCESS,
        EVT_VIDEO_CAPTURE_VIRTUAL_CAMERA_STOP_SUCCESS,
        EVT_VIDEO_PREPROCESS_FACE_RECOGNIZE_SUCESS,
        EVT_VIDEO_PREPROCESS_FACE_RECOGNIZE_FAILED,
        EVT_VIDEO_PREPROCESS_COSMETIC_FIRST_USE,
        EVT_VIDEO_ENCODE_STOP_SUCCESS,
        EVT_VIDEO_ENCODE_SW_TO_HW_CPU_USAGE,
        EVT_VIDEO_ENCODE_HW_TO_SW_MEDIACODEC_NOT_WORK,
        EVT_VIDEO_CONSUMER_RECEIVE_FIRST_FRAME,
        EVT_VIDEO_DECODE_START_DECODE_FIRST_FRAME,
        EVT_VIDEO_DECODE_START_SUCCESS,
        EVT_VIDEO_DECODE_SW_TO_HW_REMOTE_VIDEO_DISABLE_RPS
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum c {
        WARNING_VIDEO_ENCODE_EGL_CORE_CREATE_FAILED(100),
        WARNING_VIDEO_ENCODE_START_FAILED_INSUFFICIENT_RESOURCE(101),
        WARNING_VIDEO_ENCODE_START_FAILED(102),
        WARNING_VIDEO_ENCODE_SWAP_BUFFER(103),
        WARNING_VIDEO_RENDER_EGL_CORE_CREATE_FAILED(200),
        WARNING_VIDEO_RENDER_EGL_CORE_DESTROY_FAILED(201),
        WARNING_VIDEO_RENDER_SWAP_BUFFER(202),
        WARNING_VIDEO_DECODE_EGL_CORE_CREATE_FAILED(300),
        WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_ARGUMENT(301),
        WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_STATE(302),
        WARNING_VIDEO_DECODE_START_FAILED_INSUFFICIENT_RESOURCE(303),
        WARNING_VIDEO_DECODE_START_FAILED_OUT_OF_MEMORY(304),
        WARNING_VIDEO_DECODE_START_FAILED(305),
        WARNING_VIDEO_DECODE_RESTART_WHEN_DECODE_ERROR(306),
        WARNING_VIDEO_DECODE_ERROR_NOT_SUPPORT_PIXEL_FORMAT_TYPE(307),
        WARNING_VIDEO_DECODE_FATAL_ERROR(308),
        WARNING_VIDEO_DECODE_CACHE_EXCEEDED(1000),
        WARNING_VIDEO_DECODE_ABNORMAL(1001),
        WARNING_VIDEO_DECODE_EGL_CORE_DESTROY_FAILED(1002),
        WARNING_VIDEO_DECODE_HARDWARE_ERROR(1003),
        WARNING_OUT_OF_MEMORY(2000);

        public final int mValue;

        c(int i3) {
            this.mValue = i3;
        }
    }

    public static int a(a aVar) {
        Map<a, Integer> map = f119413a;
        if (map.containsKey(aVar)) {
            return map.get(aVar).intValue();
        }
        return 0;
    }

    public static int a(c cVar) {
        Map<c, Integer> map = f119414b;
        if (map.containsKey(cVar)) {
            return map.get(cVar).intValue();
        }
        return 0;
    }
}
