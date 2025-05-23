package bn0;

import com.google.gson.annotations.SerializedName;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class e {

    @SerializedName("basic_info")
    public a basic_info;

    @SerializedName("dest_info")
    public b dest_info;

    @SerializedName(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO)
    public c report_info;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class a {

        @SerializedName("aid")
        public String aid;

        @SerializedName(SsoReporter.POS_ID_KEY)
        public String pos_id;

        @SerializedName("product_type")
        public int product_type;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class b {

        @SerializedName("deep_link")
        public String deep_link;

        @SerializedName("dest_type")
        public int dest_type;

        @SerializedName("dest_url")
        public String dest_url;

        @SerializedName("disable_jump_app_home")
        public boolean disable_jump_app_home;

        @SerializedName("download_info")
        public a download_info;

        /* compiled from: P */
        /* loaded from: classes6.dex */
        public static final class a {

            @SerializedName("app_id")
            public String app_id;

            @SerializedName("app_logo_url")
            public String app_logo_url;

            @SerializedName("app_name")
            public String app_name;

            @SerializedName("app_package_name")
            public String app_package_name;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class c {

        @SerializedName("trace_id")
        public String trace_id;

        @SerializedName("via")
        public String via;
    }
}
