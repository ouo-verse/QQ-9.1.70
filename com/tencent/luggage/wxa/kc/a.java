package com.tencent.luggage.wxa.kc;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kc.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6375a {

        /* renamed from: a, reason: collision with root package name */
        public static final C6375a f131902a = new C6375a();

        public static final String a(int i3) {
            if (i3 == 0) {
                return "OK";
            }
            if (i3 == -1) {
                return "ERR_INVALID_PARAMS";
            }
            if (i3 == -2) {
                return "ERR_TASK_ALREADY_ALIVE";
            }
            if (i3 == -3) {
                return "ERR_TASK_GET_ATTRS_FAIL";
            }
            if (i3 == -4) {
                return "ERR_TASK_BIND_REMOTE_SERVICE_FAIL";
            }
            if (i3 == -5) {
                return "ERR_TASK_REMOTE_SERVICE_DIED";
            }
            if (i3 == -6) {
                return "ERR_TASK_CREATE_RUNTIME_FAILED";
            }
            if (i3 == -7) {
                return "ERR_TASK_RESOURCE_PREPARE_FAIL";
            }
            if (i3 == -8) {
                return "ERR_TASK_UNSUPPORTED";
            }
            if (i3 == -9) {
                return "ERR_TASK_LOAD_MODULE_FAILED";
            }
            if (i3 == -10) {
                return "ERR_TASK_BANNED";
            }
            if (i3 == -11) {
                return "ERR_TASK_IPC_BIND_MAIN_PROCESS_FAILED";
            }
            if (i3 == -12) {
                return "ERR_TASK_INTERRUPTED";
            }
            if (i3 == -13) {
                return "ERR_TASK_INTERRUPTED_BY_LOGOUT";
            }
            return "UNKNOWN";
        }
    }

    void a(int i3, String str);

    void onSuccess();
}
