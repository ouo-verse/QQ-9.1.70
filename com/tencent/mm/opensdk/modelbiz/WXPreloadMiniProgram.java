package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* loaded from: classes9.dex */
public class WXPreloadMiniProgram {

    /* loaded from: classes9.dex */
    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXPreloadMiniProgram.Req";
        public String userName;
        public String path = "";
        public int miniprogramType = 0;
        public String extData = "";

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String str;
            if (b.b(this.userName)) {
                str = "userName is null";
            } else {
                int i3 = this.miniprogramType;
                if (i3 >= 0 && i3 <= 2) {
                    return true;
                }
                str = "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW";
            }
            Log.e(TAG, str);
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 28;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_launch_wxminiprogram_username", this.userName);
            bundle.putString("_launch_wxminiprogram_path", this.path);
            bundle.putString("_launch_wxminiprogram_extData", this.extData);
            bundle.putInt("_launch_wxminiprogram_type", this.miniprogramType);
        }
    }

    /* loaded from: classes9.dex */
    public static final class Resp extends BaseResp {
        public String extMsg;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_launch_wxminiprogram_ext_msg");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 28;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_launch_wxminiprogram_ext_msg", this.extMsg);
        }
    }
}
