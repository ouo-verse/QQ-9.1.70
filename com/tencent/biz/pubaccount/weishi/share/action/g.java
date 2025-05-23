package com.tencent.biz.pubaccount.weishi.share.action;

import NS_KING_SOCIALIZE_META.stShareBody;
import NS_KING_SOCIALIZE_META.stShareInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J&\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/share/action/g;", "Lcom/tencent/biz/pubaccount/weishi/share/action/a;", "Lj10/a;", "shareParam", "", tl.h.F, "LNS_KING_SOCIALIZE_META/stShareBody;", "shareBody", "", WadlProxyConsts.KEY_JUMP_URL, "", "i", "c", "e", "g", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "sheetItem", "a", "", "f", "d", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public class g implements a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/pubaccount/weishi/share/action/g$b", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "resp", "", "onWXShareResp", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements WXShareHelper.a {
        b() {
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
            int i3 = resp.errCode;
            if (i3 == -4) {
                ToastUtil.a().b(R.string.hit);
            } else if (i3 != -2 && i3 != 0) {
                ToastUtil.a().b(R.string.hit);
            }
            WXShareHelper.b0().q0(this);
        }
    }

    private final void c() {
        WXShareHelper.b0().A(new b());
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean h(j10.a shareParam) {
        boolean z16;
        boolean isBlank;
        stSimpleMetaFeed stsimplemetafeed;
        stShareInfo stshareinfo;
        stShareBody e16 = e(shareParam);
        if (e16 == null) {
            x.f("WSShare2WeChat", "[share2WeChat] shareBody is null!");
            return false;
        }
        String str = (shareParam == null || (stsimplemetafeed = shareParam.f409063a) == null || (stshareinfo = stsimplemetafeed.share_info) == null) ? null : stshareinfo.jump_url;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    x.f("WSShare2WeChat", "[share2WeChat] jumpUrl is null!");
                    return false;
                }
                if (!WXShareHelper.b0().e0()) {
                    ToastUtil.a().b(R.string.f173257ih1);
                } else if (!WXShareHelper.b0().f0()) {
                    ToastUtil.a().b(R.string.f173258ih2);
                }
                i(e16, str);
                c();
                return true;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final void i(final stShareBody shareBody, final String jumpUrl) {
        final String valueOf = String.valueOf(System.currentTimeMillis());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.share.action.f
            @Override // java.lang.Runnable
            public final void run() {
                g.j(stShareBody.this, valueOf, jumpUrl, this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(stShareBody shareBody, String wxTransaction, String str, g this$0) {
        Intrinsics.checkNotNullParameter(shareBody, "$shareBody");
        Intrinsics.checkNotNullParameter(wxTransaction, "$wxTransaction");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            byte[] openUrlForByte = HttpUtil.openUrlForByte(BaseApplication.getContext(), MsfSdkUtils.insertMtype("GameCenter", shareBody.image_url), "GET", null, null);
            Bitmap decodeByteArray = openUrlForByte != null ? BitmapFactory.decodeByteArray(openUrlForByte, 0, openUrlForByte.length) : null;
            if (decodeByteArray == null) {
                return;
            }
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            if (width * height > 8000.0d) {
                double d16 = width;
                double d17 = height;
                double sqrt = Math.sqrt(8000.0d / (d16 * d17));
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, (int) (d16 * sqrt), (int) (d17 * sqrt), true);
                decodeByteArray.recycle();
                WXShareHelper.b0().L0(wxTransaction, shareBody.title, createScaledBitmap, shareBody.desc, str, this$0.f());
                createScaledBitmap.recycle();
            }
        } catch (Exception e16) {
            x.f("WSShare2WeChat", "[shareWebPage] e:" + e16.getMessage());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.share.action.a
    public boolean a(Context context, ShareActionSheetBuilder.ActionSheetItem sheetItem, j10.a shareParam) {
        boolean h16 = h(shareParam);
        if (h16) {
            g(shareParam);
        }
        return h16;
    }

    public int d() {
        return 1003004;
    }

    public int f() {
        return 0;
    }

    private final stShareBody e(j10.a shareParam) {
        stSimpleMetaFeed stsimplemetafeed;
        stShareInfo stshareinfo;
        Map<Integer, stShareBody> map;
        if (shareParam == null || (stsimplemetafeed = shareParam.f409063a) == null || (stshareinfo = stsimplemetafeed.share_info) == null || (map = stshareinfo.body_map) == null) {
            return null;
        }
        return map.get(3);
    }

    private final void g(j10.a shareParam) {
        if (shareParam != null) {
            WSPublicAccReport.getInstance().reportShareClick(shareParam.f409069g, d(), shareParam.f409067e, shareParam.f409068f, shareParam.f409063a, shareParam.f409071i);
        }
    }
}
