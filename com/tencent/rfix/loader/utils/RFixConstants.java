package com.tencent.rfix.loader.utils;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFixConstants {
    public static final String APK_PATH = "apk";
    public static final String APK_TINKER_NAME = "tinker.apk";
    public static final int BUFFER_SIZE = 16384;
    public static final String DEFAULT_PATCH_ID = "DEFAULT_PATCH_ID";
    public static final String DEX_CONFIG_NAME = "config.txt";
    public static final String DEX_FILE_NAME = "classes.dex";
    public static final String DEX_OPT_PATH = "dex_opt";
    public static final String DEX_PATH = "dex";
    public static final String EFFECT_IMMEDIATE = "EFFECT_IMMEDIATE";
    public static final String ENABLE_ASSERT_DEX = "enable_assert_dex";
    public static final String ENABLE_ASSERT_LIB = "enable_assert_lib";
    public static final String ENABLE_ASSERT_RES = "enable_assert_res";
    public static final int ERROR_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND = -205;
    public static final int ERROR_PACKAGE_CHECK_DEX_META_CORRUPTED = -203;
    public static final int ERROR_PACKAGE_CHECK_LIB_META_CORRUPTED = -204;
    public static final int ERROR_PACKAGE_CHECK_PACKAGE_META_NOT_FOUND = -202;
    public static final int ERROR_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND = -206;
    public static final int ERROR_PACKAGE_CHECK_RESOURCE_META_CORRUPTED = -208;
    public static final int ERROR_PACKAGE_CHECK_SIGNATURE_FAIL = -201;
    public static final int ERROR_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT = -209;
    public static final int ERROR_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL = -207;
    public static final int ERROR_PATCH_ALREADY_APPLY = -106;
    public static final int ERROR_PATCH_DISABLE = -101;
    public static final int ERROR_PATCH_INSERVICE = -104;
    public static final int ERROR_PATCH_JIT = -105;
    public static final int ERROR_PATCH_NOTEXIST = -102;
    public static final int ERROR_PATCH_RETRY_COUNT_LIMIT = -107;
    public static final int ERROR_PATCH_RUNNING = -103;
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final int INSTALL_ERROR_OK = 0;
    public static final int INSTALL_ERROR_QFIX_DEX_FAIL = -1;
    public static final int INSTALL_ERROR_QFIX_RES_FAIL = -6;
    public static final int INSTALL_ERROR_QFIX_SO_FAIL = -5;
    public static final int INSTALL_ERROR_REDIRECT_DEX_FAIL = -7;
    public static final int INSTALL_ERROR_REDIRECT_SO_FAIL = -8;
    public static final int INSTALL_ERROR_TINKER_APK_COPY_FAIL = -3;
    public static final int INSTALL_ERROR_TINKER_APK_FAIL = -2;
    public static final int INSTALL_ERROR_TINKER_DEX_OPT_FAIL = -302;
    public static final int INSTALL_ERROR_TINKER_INFO_CORRUPTED = -303;
    public static final int INSTALL_ERROR_TINKER_INIT_FAIL = -4;
    public static final int INSTALL_ERROR_TINKER_PACKAGE_CHECK_FAIL = -200;
    public static final int INSTALL_ERROR_TINKER_PROCESS_KILLED = -305;
    public static final int INSTALL_ERROR_TINKER_RECEIVE_FAIL = -100;
    public static final int INSTALL_ERROR_TINKER_TYPE_EXTRACT_FAIL = -301;
    public static final int INSTALL_ERROR_TINKER_UNKNOWN_EXCEPTION = -304;
    public static final int INSTALL_ERROR_TINKER_VERSION_CHECK_FAIL = -300;
    public static final int INSTALL_ERROR_UNKNOWN_EXCEPTION = -999;
    public static final int MAX_INSTALL_RETRY_COUNT = 10;
    public static final int MD5_FILE_BUF_LENGTH = 102400;
    public static final int MD5_LENGTH = 32;
    public static final String PATCH_DIRECTORY_NAME = "rfix";
    public static final String PATCH_ID = "PATCH_ID";
    public static final String PATCH_INFO_NAME = "rfix_patch_info.prop";
    public static final String PATCH_NAME_PREFIX = "patch-";
    public static final String PATCH_NAME_SUFFIX = ".apk";
    public static final String PATCH_TEMP_DIRECTORY_NAME = "rfix_temp";
    public static final String PATCH_TEMP_LAST_CRASH_NAME = "rfix_last_crash";
    public static final String PATCH_TYPE = "PATCH_TYPE";
    public static final String RES_CONFIG_NAME = "resources.meta";
    public static final String RES_FILE_NAME = "resources.zip";
    public static final String RES_PATH = "res";
    public static final String RFIX_VERSION = "1.2.4-beta4-SNAPSHOT";
    public static final String SO_PATH = "lib";

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public enum LoadResult {
        LOAD_RESULT_SUCCESS,
        LOAD_RESULT_PATCH_INFO_BLANK(true),
        LOAD_RESULT_PATCH_DOWNLOAD_FAIL(true),
        LOAD_RESULT_PATCH_INSTALL_FAIL(true),
        LOAD_RESULT_PATCH_REMOVED(true),
        LOAD_RESULT_PROCESS_DISABLE(true),
        LOAD_RESULT_REMOTE_VERIFY_FAIL(true),
        LOAD_RESULT_MAIN_UNVERIFIED(true),
        LOAD_RESULT_PATCH_VERSION_NOT_EXIST,
        LOAD_RESULT_SAFE_MODE_CHECK,
        LOAD_RESULT_NO_LOADER_SUPPORT,
        LOAD_RESULT_PATCH_LOADER_FAIL,
        LOAD_RESULT_UNKNOWN_EXCEPTION;

        private final boolean noPatch;

        LoadResult() {
            this(false);
        }

        public boolean isNoPatch() {
            return this.noPatch;
        }

        LoadResult(boolean z16) {
            this.noPatch = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public enum PatchError {
        PATCH_ERROR_OK,
        PATCH_ERROR_APPLYING,
        PATCH_ERROR_NOT_EXIST,
        PATCH_ERROR_MD5_INVALID,
        PATCH_ERROR_SAFE_MODE_INTERCEPT,
        PATCH_ERROR_RETRY_LIMIT,
        PATCH_ERROR_ALREADY_APPLY,
        PATCH_ERROR_SIGN_NOT_MATCH,
        PATCH_ERROR_TYPE_INVALID,
        PATCH_ERROR_ID_INVALID,
        PATCH_ERROR_COPY_PATCH_FAIL,
        PATCH_ERROR_NO_INSTALLER_SUPPORT,
        PATCH_ERROR_INSTALL_FAIL,
        PATCH_ERROR_WRITE_PATCH_INFO_FAIL,
        PATCH_ERROR_UNKNOWN_EXCEPTION
    }
}
