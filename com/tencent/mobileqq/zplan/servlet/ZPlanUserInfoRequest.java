package com.tencent.mobileqq.zplan.servlet;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import com.tencent.state.data.SquareJSConst;
import com.tencent.trpcprotocol.zplan.user_info.common_pb.commonPb$Info;
import com.tencent.trpcprotocol.zplan.user_info.common_pb.commonPb$InfoDes;
import com.tencent.trpcprotocol.zplan.user_info.common_pb.commonPb$UserInfo;
import com.tencent.trpcprotocol.zplan.user_info.get_pb.getPb$ReqBody;
import com.tencent.trpcprotocol.zplan.user_info.get_pb.getPb$RspBody;
import com.tencent.trpcprotocol.zplan.user_info.set_pb.setPb$ReqBody;
import com.tencent.trpcprotocol.zplan.user_info.set_pb.setPb$RspBody;
import com.tencent.trpcprotocol.zplan.user_info_ext.user_info_ext.userInfoExt$DCBackImage;
import com.tencent.trpcprotocol.zplan.user_info_ext.user_info_ext.userInfoExt$DCBackImageReq;
import com.tencent.trpcprotocol.zplan.user_info_ext.user_info_ext.userInfoExt$DCBackImageRsp;
import com.tencent.trpcprotocol.zplan.user_info_ext.user_info_ext.userInfoExt$DCBackImages;
import com.tencent.trpcprotocol.zplan.user_info_ext.user_info_ext.userInfoExt$ExtInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b>\u0010?J,\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006*\u00020\u0002H\u0002J\f\u0010\n\u001a\u00020\t*\u00020\bH\u0002J\f\u0010\r\u001a\u00020\f*\u00020\u000bH\u0002JF\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00042\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J(\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00042\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0002J\u001e\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010*\b\u0012\u0004\u0012\u00020 0\u001bH\u0002J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u001eH\u0002J\u0014\u0010(\u001a\u0004\u0018\u00010'2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0002JI\u0010.\u001a\u00020-2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010+\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010,\u001a\u00020\u000e\u00a2\u0006\u0004\b.\u0010/J.\u00102\u001a\u00020-2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\b0\u001b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u000101J>\u00107\u001a\u00020-2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\b0\u001b2\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u000e03j\b\u0012\u0004\u0012\u00020\u000e`42\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u000106J.\u00109\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00042\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0006\u0010+\u001a\u000208R\u0016\u0010=\u001a\u0004\u0018\u00010:8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/ZPlanUserInfoRequest;", "", "Lcom/tencent/trpcprotocol/zplan/user_info/get_pb/getPb$RspBody;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "t", "Lcom/tencent/mobileqq/zplan/model/c;", "Lcom/tencent/trpcprotocol/zplan/user_info/common_pb/commonPb$InfoDes;", "w", "Lcom/tencent/mobileqq/zplan/model/b;", "Lcom/tencent/trpcprotocol/zplan/user_info/common_pb/commonPb$Info;", "v", "", "uin", "", "map", "g", DomainData.DOMAIN_NAME, "command", "Lcom/tencent/mobileqq/pb/MessageMicro;", "body", "serviceType", "Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;", "k", "handleType", "", "Lcom/tencent/mobileqq/zplan/model/g;", "zPlanBgInfos", "Lcom/tencent/trpcprotocol/zplan/user_info_ext/user_info_ext/userInfoExt$DCBackImageReq;", "i", "Lcom/tencent/trpcprotocol/zplan/user_info_ext/user_info_ext/userInfoExt$ExtInfo;", "u", "Lcom/tencent/trpcprotocol/zplan/user_info_ext/user_info_ext/userInfoExt$DCBackImage;", "image", tl.h.F, "j", "data", "Lcom/tencent/trpcprotocol/zplan/user_info_ext/user_info_ext/userInfoExt$DCBackImageRsp;", "l", "infoList", "Lnk3/a;", "callback", "timeoutMillis", "", "o", "(IILjava/util/List;Ljava/lang/Long;Lnk3/a;J)V", "infoDesList", "Lnk3/p;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", SquareJSConst.Params.PARAMS_UIN_LIST, "Lnk3/l;", "r", "Lnk3/i;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/sqshow/servlet/ZPlanRequestHandler;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/sqshow/servlet/ZPlanRequestHandler;", "requestHandler", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanUserInfoRequest {

    /* renamed from: a */
    public static final ZPlanUserInfoRequest f335380a = new ZPlanUserInfoRequest();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanUserInfoRequest$a", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d */
        final /* synthetic */ Function1 f335381d;

        public a(Function1 function1) {
            this.f335381d = function1;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0086 A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #1 {all -> 0x009c, blocks: (B:3:0x0005, B:17:0x0086, B:34:0x007e, B:5:0x0007, B:7:0x001f, B:8:0x002b, B:10:0x0033, B:12:0x003d, B:15:0x0044, B:30:0x005e), top: B:2:0x0005, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
        @Override // com.tencent.mobileqq.app.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onUpdate(int type, boolean isSuccess, Object data) {
            Function1 function1;
            Function1 function12;
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
            Integer valueOf;
            String str;
            MessageMicro messageMicro = null;
            try {
                ZPlanUserInfoRequest zPlanUserInfoRequest = ZPlanUserInfoRequest.f335380a;
                try {
                    oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
                    oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
                    valueOf = oidb_sso_oidbssopkg.uint32_result.has() ? Integer.valueOf(oidb_sso_oidbssopkg.uint32_result.get()) : null;
                    str = oidb_sso_oidbssopkg.str_error_msg.has() ? oidb_sso_oidbssopkg.str_error_msg.get() : null;
                } catch (Throwable th5) {
                    QLog.e("ZPlanUserInfoRequest", 1, "extractRspPkg exception:", th5);
                }
            } catch (Throwable th6) {
                try {
                    QLog.e("ZPlanUserInfoRequest", 1, "requestOidb onUpdate exception:", th6);
                    function12 = this.f335381d;
                    if (function12 == null) {
                        return;
                    }
                } finally {
                    function1 = this.f335381d;
                    if (function1 != null) {
                        function1.invoke(messageMicro);
                    }
                }
            }
            if (valueOf != null && valueOf.intValue() == 0) {
                Object newInstance = setPb$RspBody.class.newInstance();
                ((MessageMicro) newInstance).mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                messageMicro = (MessageMicro) newInstance;
                if (messageMicro != null) {
                    QLog.e("ZPlanUserInfoRequest", 1, "requestOidb response is null");
                    if (function1 != null) {
                        return;
                    } else {
                        return;
                    }
                } else {
                    function12 = this.f335381d;
                    if (function12 == null) {
                        return;
                    }
                    function12.invoke(messageMicro);
                    return;
                }
            }
            QLog.e("ZPlanUserInfoRequest", 1, "extractRspPkg fail, result:" + valueOf + ", errMsg:" + str);
            if (messageMicro != null) {
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanUserInfoRequest$b", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d */
        final /* synthetic */ Function1 f335382d;

        public b(Function1 function1) {
            this.f335382d = function1;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0086 A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #1 {all -> 0x009c, blocks: (B:3:0x0005, B:17:0x0086, B:34:0x007e, B:5:0x0007, B:7:0x001f, B:8:0x002b, B:10:0x0033, B:12:0x003d, B:15:0x0044, B:30:0x005e), top: B:2:0x0005, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
        @Override // com.tencent.mobileqq.app.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onUpdate(int type, boolean isSuccess, Object data) {
            Function1 function1;
            Function1 function12;
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
            Integer valueOf;
            String str;
            MessageMicro messageMicro = null;
            try {
                ZPlanUserInfoRequest zPlanUserInfoRequest = ZPlanUserInfoRequest.f335380a;
                try {
                    oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
                    oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
                    valueOf = oidb_sso_oidbssopkg.uint32_result.has() ? Integer.valueOf(oidb_sso_oidbssopkg.uint32_result.get()) : null;
                    str = oidb_sso_oidbssopkg.str_error_msg.has() ? oidb_sso_oidbssopkg.str_error_msg.get() : null;
                } catch (Throwable th5) {
                    QLog.e("ZPlanUserInfoRequest", 1, "extractRspPkg exception:", th5);
                }
            } catch (Throwable th6) {
                try {
                    QLog.e("ZPlanUserInfoRequest", 1, "requestOidb onUpdate exception:", th6);
                    function12 = this.f335382d;
                    if (function12 == null) {
                        return;
                    }
                } finally {
                    function1 = this.f335382d;
                    if (function1 != null) {
                        function1.invoke(messageMicro);
                    }
                }
            }
            if (valueOf != null && valueOf.intValue() == 0) {
                Object newInstance = getPb$RspBody.class.newInstance();
                ((MessageMicro) newInstance).mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                messageMicro = (MessageMicro) newInstance;
                if (messageMicro != null) {
                    QLog.e("ZPlanUserInfoRequest", 1, "requestOidb response is null");
                    if (function1 != null) {
                        return;
                    } else {
                        return;
                    }
                } else {
                    function12 = this.f335382d;
                    if (function12 == null) {
                        return;
                    }
                    function12.invoke(messageMicro);
                    return;
                }
            }
            QLog.e("ZPlanUserInfoRequest", 1, "extractRspPkg fail, result:" + valueOf + ", errMsg:" + str);
            if (messageMicro != null) {
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanUserInfoRequest$c", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d */
        final /* synthetic */ Function1 f335383d;

        public c(Function1 function1) {
            this.f335383d = function1;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0086 A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #1 {all -> 0x009c, blocks: (B:3:0x0005, B:17:0x0086, B:34:0x007e, B:5:0x0007, B:7:0x001f, B:8:0x002b, B:10:0x0033, B:12:0x003d, B:15:0x0044, B:30:0x005e), top: B:2:0x0005, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
        @Override // com.tencent.mobileqq.app.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onUpdate(int type, boolean isSuccess, Object data) {
            Function1 function1;
            Function1 function12;
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
            Integer valueOf;
            String str;
            MessageMicro messageMicro = null;
            try {
                ZPlanUserInfoRequest zPlanUserInfoRequest = ZPlanUserInfoRequest.f335380a;
                try {
                    oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
                    oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
                    valueOf = oidb_sso_oidbssopkg.uint32_result.has() ? Integer.valueOf(oidb_sso_oidbssopkg.uint32_result.get()) : null;
                    str = oidb_sso_oidbssopkg.str_error_msg.has() ? oidb_sso_oidbssopkg.str_error_msg.get() : null;
                } catch (Throwable th5) {
                    QLog.e("ZPlanUserInfoRequest", 1, "extractRspPkg exception:", th5);
                }
            } catch (Throwable th6) {
                try {
                    QLog.e("ZPlanUserInfoRequest", 1, "requestOidb onUpdate exception:", th6);
                    function12 = this.f335383d;
                    if (function12 == null) {
                        return;
                    }
                } finally {
                    function1 = this.f335383d;
                    if (function1 != null) {
                        function1.invoke(messageMicro);
                    }
                }
            }
            if (valueOf != null && valueOf.intValue() == 0) {
                Object newInstance = getPb$RspBody.class.newInstance();
                ((MessageMicro) newInstance).mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                messageMicro = (MessageMicro) newInstance;
                if (messageMicro != null) {
                    QLog.e("ZPlanUserInfoRequest", 1, "requestOidb response is null");
                    if (function1 != null) {
                        return;
                    } else {
                        return;
                    }
                } else {
                    function12 = this.f335383d;
                    if (function12 == null) {
                        return;
                    }
                    function12.invoke(messageMicro);
                    return;
                }
            }
            QLog.e("ZPlanUserInfoRequest", 1, "extractRspPkg fail, result:" + valueOf + ", errMsg:" + str);
            if (messageMicro != null) {
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanUserInfoRequest$d", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d */
        final /* synthetic */ nk3.i f335384d;

        /* renamed from: e */
        final /* synthetic */ userInfoExt$DCBackImageReq f335385e;

        /* renamed from: f */
        final /* synthetic */ long f335386f;

        d(nk3.i iVar, userInfoExt$DCBackImageReq userinfoext_dcbackimagereq, long j3) {
            this.f335384d = iVar;
            this.f335385e = userinfoext_dcbackimagereq;
            this.f335386f = j3;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            try {
                ZPlanUserInfoRequest zPlanUserInfoRequest = ZPlanUserInfoRequest.f335380a;
                userInfoExt$DCBackImageRsp l3 = zPlanUserInfoRequest.l(data);
                if (l3 == null) {
                    QLog.e("ZPlanUserInfoRequest", 1, "requestOidb_0x1169 fail, extract0x1169RespPkg get null");
                    this.f335384d.onResultFailed();
                    return;
                }
                int i3 = this.f335385e.handle_type.get();
                if (i3 == 1) {
                    this.f335384d.onResultForAddImage();
                    return;
                }
                if (i3 == 2) {
                    this.f335384d.onResultForDeleteImage();
                    return;
                }
                if (i3 == 3) {
                    this.f335384d.onResultForUpdateImage();
                    return;
                }
                if (i3 != 4) {
                    if (i3 != 5) {
                        return;
                    }
                    String str = l3.select_images.url.get();
                    String str2 = l3.select_images.dark_url.get();
                    long j3 = l3.select_images.update_time.get();
                    int i16 = l3.select_images.image_type.get();
                    List<userInfoExt$ExtInfo> list = l3.select_images.ext_infos.get();
                    Intrinsics.checkNotNullExpressionValue(list, "response.select_images.ext_infos.get()");
                    com.tencent.mobileqq.zplan.model.g gVar = new com.tencent.mobileqq.zplan.model.g(str, str2, j3, 1, i16, zPlanUserInfoRequest.u(list));
                    ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).saveUserBackgroundInfo(String.valueOf(this.f335386f), gVar);
                    this.f335384d.onResultForSelectImage(gVar);
                    return;
                }
                List<userInfoExt$DCBackImage> list2 = l3.all_images.back_images.get();
                Intrinsics.checkNotNullExpressionValue(list2, "response.all_images.back_images.get()");
                ArrayList arrayList = new ArrayList();
                Iterator<userInfoExt$DCBackImage> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(ZPlanUserInfoRequest.f335380a.h(it.next()));
                }
                String str3 = l3.xiaowo_photograph_schema.get();
                if (str3 != null) {
                    this.f335384d.onResultForRequestAllImage(arrayList, str3);
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                this.f335384d.onResultFailed();
                QLog.e("ZPlanUserInfoRequest", 1, "requestOidb_0x1169 onUpdate exception:", e16);
            }
        }
    }

    ZPlanUserInfoRequest() {
    }

    public final com.tencent.mobileqq.zplan.model.g h(userInfoExt$DCBackImage userinfoext_dcbackimage) {
        String str = userinfoext_dcbackimage.url.get();
        String str2 = userinfoext_dcbackimage.dark_url.get();
        long j3 = userinfoext_dcbackimage.update_time.get();
        int i3 = userinfoext_dcbackimage.is_select.get();
        int i16 = userinfoext_dcbackimage.image_type.get();
        List<userInfoExt$ExtInfo> list = userinfoext_dcbackimage.ext_infos.get();
        Intrinsics.checkNotNullExpressionValue(list, "image.ext_infos.get()");
        return new com.tencent.mobileqq.zplan.model.g(str, str2, j3, i3, i16, u(list));
    }

    private final userInfoExt$DCBackImageReq i(long uin, int handleType, List<? extends com.tencent.mobileqq.zplan.model.g> zPlanBgInfos) {
        List<commonPb$Info> mutableListOf;
        setPb$ReqBody setpb_reqbody = new setPb$ReqBody();
        commonPb$InfoDes commonpb_infodes = new commonPb$InfoDes();
        commonpb_infodes.name.set(14);
        commonpb_infodes.type.set(2);
        commonPb$Info commonpb_info = new commonPb$Info();
        commonpb_info.des.set(commonpb_infodes);
        commonpb_info.value.set("");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(commonpb_info);
        commonPb$UserInfo commonpb_userinfo = new commonPb$UserInfo();
        commonpb_userinfo.uint64_uin.set(uin);
        commonpb_userinfo.infos.set(mutableListOf);
        setpb_reqbody.user_info.set(commonpb_userinfo);
        ArrayList arrayList = new ArrayList();
        if (zPlanBgInfos != null) {
            for (com.tencent.mobileqq.zplan.model.g gVar : zPlanBgInfos) {
                userInfoExt$DCBackImage userinfoext_dcbackimage = new userInfoExt$DCBackImage();
                String url = gVar.i();
                if (url != null) {
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    userinfoext_dcbackimage.url.set(url);
                }
                String darkUrl = gVar.b();
                if (darkUrl != null) {
                    Intrinsics.checkNotNullExpressionValue(darkUrl, "darkUrl");
                    userinfoext_dcbackimage.dark_url.set(darkUrl);
                }
                userinfoext_dcbackimage.is_select.set(gVar.e());
                userinfoext_dcbackimage.image_type.set(gVar.d());
                userinfoext_dcbackimage.update_time.set(gVar.h());
                arrayList.add(userinfoext_dcbackimage);
            }
        }
        userInfoExt$DCBackImages userinfoext_dcbackimages = new userInfoExt$DCBackImages();
        userinfoext_dcbackimages.back_images.set(arrayList);
        userInfoExt$DCBackImageReq userinfoext_dcbackimagereq = new userInfoExt$DCBackImageReq();
        userinfoext_dcbackimagereq.dc_back_images.set(userinfoext_dcbackimages);
        userinfoext_dcbackimagereq.user_info.set(setpb_reqbody);
        userinfoext_dcbackimagereq.handle_type.set(handleType);
        return userinfoext_dcbackimagereq;
    }

    private final oidb_sso$OIDBSSOPkg j(userInfoExt$DCBackImageReq body) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(4457);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(body.toByteArray()));
        return oidb_sso_oidbssopkg;
    }

    private final oidb_sso$OIDBSSOPkg k(int command, MessageMicro<?> body, int serviceType) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(command);
        oidb_sso_oidbssopkg.uint32_service_type.set(serviceType);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(body.toByteArray()));
        return oidb_sso_oidbssopkg;
    }

    public final userInfoExt$DCBackImageRsp l(Object data) {
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
            oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
            Integer valueOf = oidb_sso_oidbssopkg.uint32_result.has() ? Integer.valueOf(oidb_sso_oidbssopkg.uint32_result.get()) : null;
            String str = oidb_sso_oidbssopkg.str_error_msg.has() ? oidb_sso_oidbssopkg.str_error_msg.get() : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                userInfoExt$DCBackImageRsp userinfoext_dcbackimagersp = new userInfoExt$DCBackImageRsp();
                userinfoext_dcbackimagersp.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                return userinfoext_dcbackimagersp;
            }
            QLog.e("ZPlanUserInfoRequest", 1, "extract0x1169RespPkg fail, result:" + valueOf + ", errMsg:" + str);
            return null;
        } catch (Throwable th5) {
            QLog.e("ZPlanUserInfoRequest", 1, "extract0x1169RespPkg exception:", th5);
            return null;
        }
    }

    public final ZPlanRequestHandler m() {
        return ZPlanRequestHandler.INSTANCE.a();
    }

    private final long n() {
        bb bbVar = bb.f335811a;
        if (bbVar.d() == null) {
            QLog.e("ZPlanUserInfoRequest", 1, "getUin fail ");
            return -1L;
        }
        AppRuntime d16 = bbVar.d();
        Intrinsics.checkNotNull(d16);
        return d16.getLongAccountUin();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d A[Catch: all -> 0x0085, TryCatch #0 {all -> 0x0085, blocks: (B:3:0x0005, B:5:0x0011, B:10:0x001d, B:13:0x0024, B:15:0x002c, B:17:0x0033, B:19:0x003e, B:22:0x0047, B:24:0x004e, B:25:0x005f, B:27:0x0065), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0024 A[Catch: all -> 0x0085, TryCatch #0 {all -> 0x0085, blocks: (B:3:0x0005, B:5:0x0011, B:10:0x001d, B:13:0x0024, B:15:0x002c, B:17:0x0033, B:19:0x003e, B:22:0x0047, B:24:0x004e, B:25:0x005f, B:27:0x0065), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final HashMap<Integer, String> t(getPb$RspBody getpb_rspbody) {
        boolean z16;
        try {
            List<commonPb$UserInfo> list = getpb_rspbody.user_infos.get();
            List<commonPb$UserInfo> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                z16 = false;
                if (!z16) {
                    QLog.e("ZPlanUserInfoRequest", 1, "requestOidb_0x1127 resp user_infos empty");
                    return null;
                }
                commonPb$UserInfo commonpb_userinfo = list.get(0);
                if (commonpb_userinfo == null) {
                    QLog.e("ZPlanUserInfoRequest", 1, "requestOidb_0x1127 resp first pbUserInfo empty");
                    return null;
                }
                List<commonPb$Info> respInfoMap = commonpb_userinfo.infos.get();
                List<commonPb$Info> list3 = respInfoMap;
                if (list3 == null || list3.isEmpty()) {
                    QLog.e("ZPlanUserInfoRequest", 1, "requestOidb_0x1127 resp pbUserInfo.infos empty");
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(respInfoMap, "respInfoMap");
                HashMap<Integer, String> hashMap = new HashMap<>();
                for (Object obj : respInfoMap) {
                    hashMap.put(Integer.valueOf(((commonPb$Info) obj).des.name.get()), ((commonPb$Info) obj).value.get());
                }
                return hashMap;
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Throwable th5) {
            QLog.e("ZPlanUserInfoRequest", 1, "requestOidb_0x1127 onUpdate exception:", th5);
            return null;
        }
    }

    public final Map<String, String> u(List<userInfoExt$ExtInfo> list) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        List<userInfoExt$ExtInfo> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (userInfoExt$ExtInfo userinfoext_extinfo : list2) {
            Pair pair = TuplesKt.to(userinfoext_extinfo.key.get(), userinfoext_extinfo.value.get());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    private final commonPb$Info v(com.tencent.mobileqq.zplan.model.b bVar) {
        commonPb$Info commonpb_info = new commonPb$Info();
        commonPb$InfoDes commonpb_infodes = commonpb_info.des;
        ZPlanUserInfoRequest zPlanUserInfoRequest = f335380a;
        com.tencent.mobileqq.zplan.model.c des = bVar.f334800a;
        Intrinsics.checkNotNullExpressionValue(des, "des");
        commonpb_infodes.set(zPlanUserInfoRequest.w(des));
        commonpb_info.value.set(bVar.f334801b);
        return commonpb_info;
    }

    private final commonPb$InfoDes w(com.tencent.mobileqq.zplan.model.c cVar) {
        commonPb$InfoDes commonpb_infodes = new commonPb$InfoDes();
        commonpb_infodes.name.set(cVar.f334802a);
        commonpb_infodes.type.set(cVar.f334803b);
        return commonpb_infodes;
    }

    public final void o(int command, int serviceType, List<com.tencent.mobileqq.zplan.model.b> infoList, Long uin, final nk3.a callback, long timeoutMillis) {
        long n3;
        int collectionSizeOrDefault;
        List<commonPb$Info> mutableList;
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        setPb$ReqBody setpb_reqbody = new setPb$ReqBody();
        commonPb$UserInfo commonpb_userinfo = setpb_reqbody.user_info;
        commonPb$UserInfo commonpb_userinfo2 = new commonPb$UserInfo();
        PBUInt64Field pBUInt64Field = commonpb_userinfo2.uint64_uin;
        if (uin != null) {
            n3 = uin.longValue();
        } else {
            n3 = f335380a.n();
        }
        pBUInt64Field.set(n3);
        PBRepeatMessageField<commonPb$Info> pBRepeatMessageField = commonpb_userinfo2.infos;
        List<com.tencent.mobileqq.zplan.model.b> list = infoList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f335380a.v((com.tencent.mobileqq.zplan.model.b) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        pBRepeatMessageField.set(mutableList);
        commonpb_userinfo.set(commonpb_userinfo2);
        oidb_sso$OIDBSSOPkg k3 = k(command, setpb_reqbody, serviceType);
        String str = "OidbSvcTrpcTcp.0x1123_" + serviceType;
        Function1<setPb$RspBody, Unit> function1 = new Function1<setPb$RspBody, Unit>() { // from class: com.tencent.mobileqq.zplan.servlet.ZPlanUserInfoRequest$requestOidb1123$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(setPb$RspBody setpb_rspbody) {
                invoke2(setpb_rspbody);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(setPb$RspBody setpb_rspbody) {
                nk3.a aVar = nk3.a.this;
                if (aVar != null) {
                    aVar.onResult(setpb_rspbody != null);
                }
            }
        };
        try {
            ZPlanRequestHandler m3 = m();
            if (m3 != null) {
                m3.H2(str, k3.toByteArray(), new a(function1), timeoutMillis);
            }
        } catch (Throwable th5) {
            QLog.e("ZPlanUserInfoRequest", 1, "requestOidb getHandler failed exception:", th5);
            function1.invoke(null);
        }
    }

    public final void q(List<com.tencent.mobileqq.zplan.model.c> infoDesList, final long j3, int i3, final nk3.p pVar) {
        List<Long> mutableListOf;
        int collectionSizeOrDefault;
        List<commonPb$InfoDes> mutableList;
        Intrinsics.checkNotNullParameter(infoDesList, "infoDesList");
        getPb$ReqBody getpb_reqbody = new getPb$ReqBody();
        PBRepeatField<Long> pBRepeatField = getpb_reqbody.uint64_uins;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Long.valueOf(j3));
        pBRepeatField.set(mutableListOf);
        PBRepeatMessageField<commonPb$InfoDes> pBRepeatMessageField = getpb_reqbody.need_infos;
        List<com.tencent.mobileqq.zplan.model.c> list = infoDesList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f335380a.w((com.tencent.mobileqq.zplan.model.c) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        pBRepeatMessageField.set(mutableList);
        oidb_sso$OIDBSSOPkg k3 = k(4391, getpb_reqbody, i3);
        String str = "OidbSvcTrpcTcp.0x1127_" + i3;
        Function1<getPb$RspBody, Unit> function1 = new Function1<getPb$RspBody, Unit>() { // from class: com.tencent.mobileqq.zplan.servlet.ZPlanUserInfoRequest$requestOidb1127$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(getPb$RspBody getpb_rspbody) {
                invoke2(getpb_rspbody);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(getPb$RspBody getpb_rspbody) {
                HashMap g16;
                HashMap t16 = getpb_rspbody != null ? ZPlanUserInfoRequest.f335380a.t(getpb_rspbody) : null;
                nk3.p pVar2 = nk3.p.this;
                if (pVar2 != null) {
                    pVar2.a(t16);
                }
                ZPlanUserInfoRequest zPlanUserInfoRequest = ZPlanUserInfoRequest.f335380a;
                g16 = zPlanUserInfoRequest.g(j3, t16);
                ZPlanRequestHandler m3 = zPlanUserInfoRequest.m();
                if (m3 != null) {
                    m3.notifyUI(5, g16 != null, g16);
                }
            }
        };
        try {
            ZPlanRequestHandler m3 = m();
            if (m3 != null) {
                m3.H2(str, k3.toByteArray(), new b(function1), 30000L);
            }
        } catch (Throwable th5) {
            QLog.e("ZPlanUserInfoRequest", 1, "requestOidb getHandler failed exception:", th5);
            function1.invoke(null);
        }
    }

    public final void r(List<com.tencent.mobileqq.zplan.model.c> infoDesList, ArrayList<Long> r95, int serviceType, final nk3.l callback) {
        int collectionSizeOrDefault;
        List<commonPb$InfoDes> mutableList;
        Intrinsics.checkNotNullParameter(infoDesList, "infoDesList");
        Intrinsics.checkNotNullParameter(r95, "uinList");
        getPb$ReqBody getpb_reqbody = new getPb$ReqBody();
        getpb_reqbody.uint64_uins.set(r95);
        PBRepeatMessageField<commonPb$InfoDes> pBRepeatMessageField = getpb_reqbody.need_infos;
        List<com.tencent.mobileqq.zplan.model.c> list = infoDesList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f335380a.w((com.tencent.mobileqq.zplan.model.c) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        pBRepeatMessageField.set(mutableList);
        oidb_sso$OIDBSSOPkg k3 = k(4391, getpb_reqbody, serviceType);
        String str = "OidbSvcTrpcTcp.0x1127_" + serviceType;
        Function1<getPb$RspBody, Unit> function1 = new Function1<getPb$RspBody, Unit>() { // from class: com.tencent.mobileqq.zplan.servlet.ZPlanUserInfoRequest$requestOidb1127$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(getPb$RspBody getpb_rspbody) {
                invoke2(getpb_rspbody);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(getPb$RspBody getpb_rspbody) {
                PBRepeatMessageField<commonPb$UserInfo> pBRepeatMessageField2;
                List<commonPb$UserInfo> list2;
                PBRepeatMessageField<commonPb$Info> pBRepeatMessageField3;
                PBUInt64Field pBUInt64Field;
                HashMap<Long, HashMap<Integer, String>> hashMap = new HashMap<>();
                if (getpb_rspbody != null && (pBRepeatMessageField2 = getpb_rspbody.user_infos) != null && (list2 = pBRepeatMessageField2.get()) != null) {
                    for (commonPb$UserInfo commonpb_userinfo : list2) {
                        ZPlanUserInfoRequest zPlanUserInfoRequest = ZPlanUserInfoRequest.f335380a;
                        List<commonPb$Info> list3 = null;
                        Long valueOf = (commonpb_userinfo == null || (pBUInt64Field = commonpb_userinfo.uint64_uin) == null) ? null : Long.valueOf(pBUInt64Field.get());
                        if (commonpb_userinfo != null && (pBRepeatMessageField3 = commonpb_userinfo.infos) != null) {
                            list3 = pBRepeatMessageField3.get();
                        }
                        List<commonPb$Info> list4 = list3;
                        if (!(list4 == null || list4.isEmpty()) && valueOf != null) {
                            HashMap<Integer, String> hashMap2 = new HashMap<>();
                            for (commonPb$Info commonpb_info : list3) {
                                hashMap2.put(Integer.valueOf(commonpb_info.des.name.get()), commonpb_info.value.get());
                            }
                            hashMap.put(valueOf, hashMap2);
                        }
                    }
                }
                nk3.l lVar = nk3.l.this;
                if (lVar != null) {
                    lVar.onResult(hashMap);
                }
            }
        };
        try {
            ZPlanRequestHandler m3 = m();
            if (m3 != null) {
                m3.H2(str, k3.toByteArray(), new c(function1), 30000L);
            }
        } catch (Throwable th5) {
            QLog.e("ZPlanUserInfoRequest", 1, "requestOidb getHandler failed exception:", th5);
            function1.invoke(null);
        }
    }

    public final void s(long j3, int i3, List<? extends com.tencent.mobileqq.zplan.model.g> list, nk3.i callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 == null) {
            QLog.e("ZPlanUserInfoRequest", 1, "requestOidb_0x1169 error, handler null");
            callback.onResultFailed();
            return;
        }
        userInfoExt$DCBackImageReq i16 = i(j3, i3, list);
        a16.request("OidbSvcTrpcTcp.0x1169_0", j(i16).toByteArray(), new d(callback, i16, j3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final HashMap<Long, String> g(long uin, Map<Integer, String> map) {
        if (map == null) {
            return null;
        }
        HashMap<Long, String> hashMap = new HashMap<>(map.size());
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            hashMap.put(Long.valueOf(((Number) r1.getKey()).intValue()), ((Map.Entry) it.next()).getValue());
        }
        hashMap.put(Long.valueOf(uin), String.valueOf(uin));
        return hashMap;
    }
}
