package com.tencent.ecommerce.biz.showwindow.viewmodel;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import ck0.Category;
import ck0.Product;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.report.service.m;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.hr.module.e;
import com.tencent.ecommerce.biz.showwindow.fragment.ECShowWindowFragment;
import com.tencent.ecommerce.biz.showwindow.repo.IECShowWindowNetRepo;
import com.tencent.ecommerce.biz.showwindow.repo.window.GetProductListRsp;
import com.tencent.ecommerce.biz.showwindow.repo.window.d;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.pts.core.PTSComposer;
import com.tencent.raft.measure.utils.MeasureConst;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b`\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0016\u0018\u0000 \u00fa\u00012\u00020\u0001:\u0002\u00fb\u0001B\t\u00a2\u0006\u0006\b\u00f8\u0001\u0010\u00f9\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J \u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\b2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nH\u0002J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0016\u0010\u0017\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0002J\u000e\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\bJ\u000e\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\bJ\u000e\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'J\b\u0010*\u001a\u00020\u0002H\u0014J\u0010\u0010-\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+H\u0016J\u000e\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\bJ\u000e\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020\bJ\u000e\u00104\u001a\u00020\u00022\u0006\u00103\u001a\u000202J\u000e\u00105\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u00107\u001a\u00020\u00022\u0006\u00106\u001a\u00020\bJ\u000e\u00109\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0005J\u000e\u0010;\u001a\u00020\u00022\u0006\u0010:\u001a\u00020+J\u000e\u0010<\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000fJ\u0014\u0010=\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\nJ\u0014\u0010>\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\nJ\u0016\u0010A\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\bJ\u0006\u0010B\u001a\u00020\u0002J\u0006\u0010C\u001a\u00020\u0002J\u0006\u0010D\u001a\u00020\u0002JZ\u0010J\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010F\u001a\u00020\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010G\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010H\u001a\u00020+2\b\b\u0002\u0010I\u001a\u00020\u0005J\b\u0010K\u001a\u00020\u0002H\u0004J\b\u0010L\u001a\u00020\u0002H\u0004J:\u0010P\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\u00132\b\b\u0002\u0010G\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\b2\u0006\u0010O\u001a\u00020\bJ\u0010\u0010Q\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000fH\u0014J\u001e\u0010S\u001a\u00020\u00022\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n2\u0006\u0010R\u001a\u00020\bJ\u0006\u0010T\u001a\u00020\u0002J\u0006\u0010U\u001a\u00020\u0002R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020Y0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020\b0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010[R\"\u0010a\u001a\u0010\u0012\f\u0012\n _*\u0004\u0018\u00010\b0\b0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010[R$\u0010f\u001a\u0012\u0012\u0004\u0012\u00020\u000f0bj\b\u0012\u0004\u0012\u00020\u000f`c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR$\u0010h\u001a\u0012\u0012\u0004\u0012\u0002020bj\b\u0012\u0004\u0012\u000202`c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010eR*\u0010l\u001a\u0012\u0012\u0004\u0012\u00020\u000f0bj\b\u0012\u0004\u0012\u00020\u000f`c8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bi\u0010e\u001a\u0004\bj\u0010kR*\u0010o\u001a\u0012\u0012\u0004\u0012\u00020\u000f0bj\b\u0012\u0004\u0012\u00020\u000f`c8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bm\u0010e\u001a\u0004\bn\u0010kR*\u0010q\u001a\u0012\u0012\u0004\u0012\u00020\u000f0bj\b\u0012\u0004\u0012\u00020\u000f`c8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bW\u0010e\u001a\u0004\bp\u0010kR\u001a\u0010s\u001a\b\u0012\u0004\u0012\u0002020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010[R\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00130X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010[R\u001a\u0010w\u001a\b\u0012\u0004\u0012\u00020\b0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010[R\u001a\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00130X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bx\u0010[R\u001a\u0010{\u001a\b\u0012\u0004\u0012\u00020\u00050X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bz\u0010[R\u001a\u0010}\u001a\b\u0012\u0004\u0012\u00020\b0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b|\u0010[R\u001a\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\b0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b~\u0010[R\u001c\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\b0X8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010[R\u001c\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050X8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0082\u0001\u0010[R\u001c\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\b0X8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0084\u0001\u0010[R#\u0010\u008b\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R#\u0010\u008e\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u0088\u0001\u001a\u0006\b\u008d\u0001\u0010\u008a\u0001R#\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u008f\u0001\u0010\u0088\u0001\u001a\u0006\b\u0090\u0001\u0010\u008a\u0001R'\u0010\u0095\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\n0X8\u0006\u00a2\u0006\u000f\n\u0005\b\u0092\u0001\u0010[\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R'\u0010\u0098\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0X8\u0006\u00a2\u0006\u000f\n\u0005\b\u0096\u0001\u0010[\u001a\u0006\b\u0097\u0001\u0010\u0094\u0001R'\u0010\u009b\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020\n0X8\u0006\u00a2\u0006\u000f\n\u0005\b\u0099\u0001\u0010[\u001a\u0006\b\u009a\u0001\u0010\u0094\u0001R'\u0010\u009e\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\n0X8\u0006\u00a2\u0006\u000f\n\u0005\b\u009c\u0001\u0010[\u001a\u0006\b\u009d\u0001\u0010\u0094\u0001R#\u0010\u00a1\u0001\u001a\t\u0012\u0004\u0012\u0002020\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009f\u0001\u0010\u0088\u0001\u001a\u0006\b\u00a0\u0001\u0010\u008a\u0001R#\u0010\u00a4\u0001\u001a\t\u0012\u0004\u0012\u00020\u00130\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00a2\u0001\u0010\u0088\u0001\u001a\u0006\b\u00a3\u0001\u0010\u008a\u0001R#\u0010\u00a7\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00a5\u0001\u0010\u0088\u0001\u001a\u0006\b\u00a6\u0001\u0010\u008a\u0001R#\u0010\u00aa\u0001\u001a\t\u0012\u0004\u0012\u00020\u00130\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00a8\u0001\u0010\u0088\u0001\u001a\u0006\b\u00a9\u0001\u0010\u008a\u0001R#\u0010\u00ad\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00ab\u0001\u0010\u0088\u0001\u001a\u0006\b\u00ac\u0001\u0010\u008a\u0001R#\u0010\u00b0\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00ae\u0001\u0010\u0088\u0001\u001a\u0006\b\u00af\u0001\u0010\u008a\u0001R#\u0010\u00b3\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00b1\u0001\u0010\u0088\u0001\u001a\u0006\b\u00b2\u0001\u0010\u008a\u0001R#\u0010\u00b6\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00b4\u0001\u0010\u0088\u0001\u001a\u0006\b\u00b5\u0001\u0010\u008a\u0001R#\u0010\u00b9\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00b7\u0001\u0010\u0088\u0001\u001a\u0006\b\u00b8\u0001\u0010\u008a\u0001R!\u0010\u00bc\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050X8\u0006\u00a2\u0006\u000f\n\u0005\b\u00ba\u0001\u0010[\u001a\u0006\b\u00bb\u0001\u0010\u0094\u0001R)\u0010\u00bf\u0001\u001a\u0010\u0012\f\u0012\n _*\u0004\u0018\u00010\b0\b0X8\u0006\u00a2\u0006\u000f\n\u0005\b\u00bd\u0001\u0010[\u001a\u0006\b\u00be\u0001\u0010\u0094\u0001R'\u0010\u00c2\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\n0X8\u0006\u00a2\u0006\u000f\n\u0005\b\u00c0\u0001\u0010[\u001a\u0006\b\u00c1\u0001\u0010\u0094\u0001R'\u0010\u00c5\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\n0X8\u0006\u00a2\u0006\u000f\n\u0005\b\u00c3\u0001\u0010[\u001a\u0006\b\u00c4\u0001\u0010\u0094\u0001R!\u0010\u00c8\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050X8\u0006\u00a2\u0006\u000f\n\u0005\b\u00c6\u0001\u0010[\u001a\u0006\b\u00c7\u0001\u0010\u0094\u0001R!\u0010\u00cb\u0001\u001a\b\u0012\u0004\u0012\u00020Y0X8\u0006\u00a2\u0006\u000f\n\u0005\b\u00c9\u0001\u0010[\u001a\u0006\b\u00ca\u0001\u0010\u0094\u0001R\u001e\u0010\u00cd\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00cc\u0001\u0010[R#\u0010\u00d0\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00ce\u0001\u0010\u0088\u0001\u001a\u0006\b\u00cf\u0001\u0010\u008a\u0001R)\u0010\u00d7\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00d1\u0001\u0010\u00d2\u0001\u001a\u0006\b\u00d3\u0001\u0010\u00d4\u0001\"\u0006\b\u00d5\u0001\u0010\u00d6\u0001R*\u0010\u00dc\u0001\u001a\u00020\b2\u0007\u0010\u00d8\u0001\u001a\u00020\b8\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u00d9\u0001\u0010\u0099\u0001\u001a\u0006\b\u00da\u0001\u0010\u00db\u0001R)\u0010\u00e0\u0001\u001a\u00020\u00052\u0007\u0010\u00d8\u0001\u001a\u00020\u00058\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\b\u00dd\u0001\u0010W\u001a\u0006\b\u00de\u0001\u0010\u00df\u0001R*\u0010\u00e3\u0001\u001a\u00020\u00132\u0007\u0010\u00d8\u0001\u001a\u00020\u00138\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u00e1\u0001\u0010\u00d2\u0001\u001a\u0006\b\u00e2\u0001\u0010\u00d4\u0001R\u0018\u0010#\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e4\u0001\u0010\u0099\u0001R\u0019\u0010\u00e6\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e5\u0001\u0010\u0099\u0001R\u001c\u0010\u00ea\u0001\u001a\u0005\u0018\u00010\u00e7\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e8\u0001\u0010\u00e9\u0001R\u0019\u0010\u00ec\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00eb\u0001\u0010\u0099\u0001R(\u0010\u00f1\u0001\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b\u00ed\u0001\u0010W\u001a\u0006\b\u00ee\u0001\u0010\u00df\u0001\"\u0006\b\u00ef\u0001\u0010\u00f0\u0001R(\u0010\u00f5\u0001\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b\u00f2\u0001\u0010W\u001a\u0006\b\u00f3\u0001\u0010\u00df\u0001\"\u0006\b\u00f4\u0001\u0010\u00f0\u0001R\u001a\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f6\u0001\u0010\u00f7\u0001\u00a8\u0006\u00fc\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECShowWindowViewModel;", "Landroidx/lifecycle/ViewModel;", "", "p3", "g2", "", "windowType", "O2", "", "isFromQuery", "", "Lck0/a;", "bannerList", "N2", FeedManager.LOAD_MORE, "Lck0/c;", "productList", "P2", "firstScreen", "", "query", "l3", "products", "b3", "product", "c3", "d2", "l2", "e2", "finishRefresh", "u2", ICustomDataEditor.STRING_ARRAY_PARAM_3, "isSuccess", "isHost", "Y2", "isShowAddBtn", "f3", "alwaysEditable", "e3", "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTime", "h3", "onCleared", "Landroid/os/Bundle;", "argument", "Q2", "editable", ICustomDataEditor.NUMBER_PARAM_3, "categoryPanelShown", "m3", "Lck0/b;", "category", "r3", ICustomDataEditor.STRING_PARAM_3, "backToTop", "q3", "emptyPageStage", "t3", "ext", "u3", "i3", "i2", "f2", "selectedProduct", "isSelected", "d3", "o3", "j2", "k2", WadlProxyConsts.CHANNEL, "categoryId", "cookie", "bundle", "source", "y2", "y3", "x3", "mediaId", "sellerUin", "isNight", "I2", "W2", "isVisible", "v3", SemanticAttributes.DbSystemValues.H2, "w3", "i", "I", "Landroidx/lifecycle/MutableLiveData;", "Lorg/json/JSONObject;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_totalRsp", BdhLogUtil.LogTag.Tag_Conn, "_editable", "kotlin.jvm.PlatformType", "D", "_categoryPanelShowed", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "_productList", UserInfo.SEX_FEMALE, "_categoryList", "G", "get_selectedProductList", "()Ljava/util/ArrayList;", "_selectedProductList", "H", "L2", "_selectedByUserProduectList", "M2", "_unselectedByUserProductList", "J", "_currentCategory", "K", "_currentSearchQuery", "L", "_backToTop", "M", "_windowTitle", "N", "_emptyPageState", "P", "_isLoadingMore", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "_isEnd", BdhLogUtil.LogTag.Tag_Req, "_isRefreshing", ExifInterface.LATITUDE_SOUTH, "_totalAddSuccessCount", "T", "_isAllSelected", "Landroidx/lifecycle/LiveData;", "U", "Landroidx/lifecycle/LiveData;", "R2", "()Landroidx/lifecycle/LiveData;", "isAllSelected", "V", ICustomDataEditor.STRING_PARAM_2, "editableLiveData", "W", "p2", "categoryPanelShowedLiveData", "X", NowProxyConstants.AccountInfoKey.A2, "()Landroidx/lifecycle/MutableLiveData;", "productListLiveData", "Y", ICustomDataEditor.NUMBER_PARAM_2, "bannerListLiveData", "Z", "o2", "categoryListLiveData", "a0", "C2", "selectedProductListLiveData", "b0", "q2", "currentCategoryLiveData", "c0", "r2", "currentSearchQueryLiveData", "d0", "m2", "backToTopLiveData", "e0", "J2", "windowTitleLiveData", "f0", "t2", "emptyPageStateLiveData", "g0", "T2", "isLoadingMoreLiveData", "h0", "S2", "isEndLiveData", "i0", "V2", "isRefreshingLiveData", "j0", Constants.BASE_IN_PLUGIN_VERSION, "totalAddSuccessCount", "k0", "H2", "userTotalSelectCount", "l0", "v2", "hasUserOperateList", "m0", "B2", "selectedByUserProductList", "n0", Constants.MMCCID, "unselectedByUserProductList", "o0", "x2", "maxSelectCount", "p0", "F2", "totalRspLiveData", "q0", "_totalProductCount", "r0", "E2", "totalProductCount", "s0", "Ljava/lang/String;", "w2", "()Ljava/lang/String;", "g3", "(Ljava/lang/String;)V", "lastCookie", "<set-?>", "t0", "U2", "()Z", "isNetworkErrorLastTime", "u0", "getChannelId", "()I", "channelId", "v0", "getContentId", "contentId", "w0", "x0", "isAlwaysEditable", "Lcom/tencent/ecommerce/biz/showwindow/repo/IECShowWindowNetRepo;", "y0", "Lcom/tencent/ecommerce/biz/showwindow/repo/IECShowWindowNetRepo;", "netRepo", "z0", "isFirstRequest", "A0", "getUserSelectedCountFromBackend", "j3", "(I)V", "userSelectedCountFromBackend", "B0", "K2", "k3", "_maxSelectCount", "C0", "Lcom/tencent/ecommerce/base/report/service/k;", "<init>", "()V", "D0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class ECShowWindowViewModel extends ViewModel {

    /* renamed from: A0, reason: from kotlin metadata */
    private int userSelectedCountFromBackend;

    /* renamed from: B0, reason: from kotlin metadata */
    private int _maxSelectCount;

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _editable;

    /* renamed from: C0, reason: from kotlin metadata */
    private k showPageCostTime;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _categoryPanelShowed;

    /* renamed from: E, reason: from kotlin metadata */
    private final ArrayList<Product> _productList;

    /* renamed from: F, reason: from kotlin metadata */
    private final ArrayList<Category> _categoryList;

    /* renamed from: G, reason: from kotlin metadata */
    private final ArrayList<Product> _selectedProductList;

    /* renamed from: H, reason: from kotlin metadata */
    private final ArrayList<Product> _selectedByUserProduectList;

    /* renamed from: I, reason: from kotlin metadata */
    private final ArrayList<Product> _unselectedByUserProductList;

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<Category> _currentCategory;

    /* renamed from: K, reason: from kotlin metadata */
    private final MutableLiveData<String> _currentSearchQuery;

    /* renamed from: L, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _backToTop;

    /* renamed from: M, reason: from kotlin metadata */
    private final MutableLiveData<String> _windowTitle;

    /* renamed from: N, reason: from kotlin metadata */
    private final MutableLiveData<Integer> _emptyPageState;

    /* renamed from: P, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _isLoadingMore;

    /* renamed from: Q, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _isEnd;

    /* renamed from: R, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _isRefreshing;

    /* renamed from: S, reason: from kotlin metadata */
    private final MutableLiveData<Integer> _totalAddSuccessCount;

    /* renamed from: T, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _isAllSelected;

    /* renamed from: U, reason: from kotlin metadata */
    private final LiveData<Boolean> isAllSelected;

    /* renamed from: V, reason: from kotlin metadata */
    private final LiveData<Boolean> editableLiveData;

    /* renamed from: W, reason: from kotlin metadata */
    private final LiveData<Boolean> categoryPanelShowedLiveData;

    /* renamed from: X, reason: from kotlin metadata */
    private final MutableLiveData<List<Product>> productListLiveData;

    /* renamed from: Y, reason: from kotlin metadata */
    private final MutableLiveData<List<ck0.a>> bannerListLiveData;

    /* renamed from: Z, reason: from kotlin metadata */
    private final MutableLiveData<List<Category>> categoryListLiveData;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<Product>> selectedProductListLiveData;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Category> currentCategoryLiveData;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<String> currentSearchQueryLiveData;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Boolean> backToTopLiveData;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<String> windowTitleLiveData;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Integer> emptyPageStateLiveData;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Boolean> isLoadingMoreLiveData;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Boolean> isEndLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int windowType;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Boolean> isRefreshingLiveData;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Integer> totalAddSuccessCount;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Integer> userTotalSelectCount;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> hasUserOperateList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<JSONObject> _totalRsp;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<Product>> selectedByUserProductList;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<Product>> unselectedByUserProductList;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Integer> maxSelectCount;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<JSONObject> totalRspLiveData;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Integer> _totalProductCount;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Integer> totalProductCount;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private String lastCookie;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private boolean isNetworkErrorLastTime;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private int channelId;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private String contentId;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private boolean isShowAddBtn;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private boolean isAlwaysEditable;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private IECShowWindowNetRepo netRepo;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstRequest;

    private final void O2(int windowType) {
        Boolean bool;
        if (ECShowWindowFragment.INSTANCE.a(windowType)) {
            return;
        }
        String string = ECLocalConfig.f100650f.getString(u2(windowType), "", Boolean.TRUE);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            d.Companion companion = d.INSTANCE;
            boolean z16 = this.isShowAddBtn;
            MutableLiveData<Boolean> mutableLiveData = this._editable;
            if (mutableLiveData == null || (bool = mutableLiveData.getValue()) == null) {
                bool = Boolean.FALSE;
            }
            d.b a16 = companion.a(jSONObject, z16, bool.booleanValue());
            N2(false, a16.a());
            P2(false, a16.d());
            cg0.a.b("ECShowWindowViewModel", "[handleFirstScreenData] use firstScreenData, data = " + string);
            a3();
        } catch (JSONException e16) {
            cg0.a.a("ECShowWindowViewModel", "[handleFirstScreenData]", e16.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y2(boolean isSuccess, boolean isHost) {
        Map<Object, ? extends Object> d16 = new m().a(isHost).c(isSuccess ? 2 : 3).d();
        k kVar = this.showPageCostTime;
        if (kVar != null) {
            kVar.b(d16);
        }
    }

    private final void a3() {
        Map<Object, ? extends Object> d16 = new m().a(true).c(1).d();
        k kVar = this.showPageCostTime;
        if (kVar != null) {
            kVar.b(d16);
        }
    }

    private final void b3(List<Product> products) {
        ArrayList arrayList = new ArrayList();
        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getMediaProductId());
        }
        final int size = products.size();
        IECShowWindowNetRepo iECShowWindowNetRepo = this.netRepo;
        if (iECShowWindowNetRepo != null) {
            iECShowWindowNetRepo.reqDeleteProduct(this.channelId, products, new Function1<com.tencent.ecommerce.biz.showwindow.repo.window.k, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$reqDeleteProduct$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ecommerce.biz.showwindow.repo.window.k kVar) {
                    invoke2(kVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.ecommerce.biz.showwindow.repo.window.k kVar) {
                    final Application a16 = wg0.a.a();
                    if (kVar.getCom.tencent.mobileqq.vas.api.RemoteProxy.KEY_RESULT_TYPE java.lang.String() == 1) {
                        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$reqDeleteProduct$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                MutableLiveData mutableLiveData;
                                MutableLiveData mutableLiveData2;
                                mutableLiveData = ECShowWindowViewModel.this._totalProductCount;
                                mutableLiveData2 = ECShowWindowViewModel.this._totalProductCount;
                                Integer num = (Integer) mutableLiveData2.getValue();
                                mutableLiveData.setValue(Integer.valueOf(num != null ? num.intValue() - size : 0));
                                i.f101155b.d(a16.getResources().getString(R.string.wjd), ECToastIcon.ICON_SUCCESS, 0);
                            }
                        });
                    } else {
                        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$reqDeleteProduct$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                i.f101155b.d(a16.getResources().getString(R.string.wjb), ECToastIcon.ICON_ERROR, 0);
                            }
                        });
                    }
                }
            }, new Function1<ECRemoteResponse, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$reqDeleteProduct$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ECRemoteResponse eCRemoteResponse) {
                    invoke2(eCRemoteResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ECRemoteResponse eCRemoteResponse) {
                    cg0.a.a("ECShowWindowViewModel", "reqDeleteProduct$\\onError", "[onError]");
                    final Application a16 = wg0.a.a();
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$reqDeleteProduct$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            i.f101155b.d(a16.getResources().getString(R.string.wjb), ECToastIcon.ICON_ERROR, 0);
                        }
                    });
                }
            });
        }
    }

    private final void c3(Product product) {
        IECShowWindowNetRepo iECShowWindowNetRepo = this.netRepo;
        if (iECShowWindowNetRepo != null) {
            iECShowWindowNetRepo.reqSetTopProduct(this.channelId, product, new Function1<com.tencent.ecommerce.biz.showwindow.repo.window.k, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$reqSetTopProduct$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ecommerce.biz.showwindow.repo.window.k kVar) {
                    invoke2(kVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.ecommerce.biz.showwindow.repo.window.k kVar) {
                    final Application a16 = wg0.a.a();
                    if (kVar.getCom.tencent.mobileqq.vas.api.RemoteProxy.KEY_RESULT_TYPE java.lang.String() == 1) {
                        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$reqSetTopProduct$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                i.f101155b.d(a16.getResources().getString(R.string.wsq), ECToastIcon.ICON_SUCCESS, 0);
                            }
                        });
                    } else {
                        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$reqSetTopProduct$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                i.f101155b.d(a16.getResources().getString(R.string.wsp), ECToastIcon.ICON_ERROR, 0);
                            }
                        });
                    }
                }
            }, new Function1<ECRemoteResponse, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$reqSetTopProduct$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ECRemoteResponse eCRemoteResponse) {
                    invoke2(eCRemoteResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ECRemoteResponse eCRemoteResponse) {
                    cg0.a.a("ECShowWindowViewModel", "reqSetTopProduct$\\onError", "[onError]");
                    final Application a16 = wg0.a.a();
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$reqSetTopProduct$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            i.f101155b.d(a16.getResources().getString(R.string.wsp), ECToastIcon.ICON_ERROR, 0);
                        }
                    });
                }
            });
        }
    }

    private final void d2() {
        this._isLoadingMore.setValue(Boolean.TRUE);
    }

    private final void e2() {
        this._isRefreshing.setValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishRefresh() {
        this._isRefreshing.setValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2() {
        this.lastCookie = "";
        this._productList.clear();
        this._selectedProductList.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l2() {
        this._isLoadingMore.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l3(boolean firstScreen, String query) {
        cg0.a.b("ECShowWindowViewModel", "[shouldSaveFirstScreenData] firstScreen = " + firstScreen + ", query = " + query);
        return firstScreen && TextUtils.isEmpty(query) && !ECShowWindowFragment.INSTANCE.a(this.windowType);
    }

    private final void p3() {
        if (ECShowWindowFragment.INSTANCE.a(this.windowType)) {
            return;
        }
        if (this._selectedProductList.size() == 0 && this._productList.size() == 0) {
            this._isAllSelected.postValue(Boolean.FALSE);
        } else {
            this._isAllSelected.postValue(Boolean.valueOf(this._selectedProductList.size() == this._productList.size()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String u2(int windowType) {
        return "show_window_first_screen_data_key" + util.base64_pad_url + windowType;
    }

    public final MutableLiveData<List<Product>> A2() {
        return this.productListLiveData;
    }

    public final MutableLiveData<List<Product>> B2() {
        return this.selectedByUserProductList;
    }

    public final MutableLiveData<List<Product>> C2() {
        return this.selectedProductListLiveData;
    }

    public final LiveData<Integer> D2() {
        return this.totalAddSuccessCount;
    }

    public final LiveData<Integer> E2() {
        return this.totalProductCount;
    }

    public final MutableLiveData<JSONObject> F2() {
        return this.totalRspLiveData;
    }

    public final MutableLiveData<List<Product>> G2() {
        return this.unselectedByUserProductList;
    }

    public final MutableLiveData<Integer> H2() {
        return this.userTotalSelectCount;
    }

    public final LiveData<String> J2() {
        return this.windowTitleLiveData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: K2, reason: from getter */
    public final int get_maxSelectCount() {
        return this._maxSelectCount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayList<Product> L2() {
        return this._selectedByUserProduectList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayList<Product> M2() {
        return this._unselectedByUserProductList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0025, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Q2(Bundle argument) {
        IECShowWindowNetRepo iECShowWindowNetRepo;
        Integer intOrNull;
        this.channelId = Integer.parseInt(argument.getString(WadlProxyConsts.CHANNEL, "0"));
        this.contentId = argument.getString("content_id", "");
        String string = argument.getString("window_type");
        int intValue = (string == null || intOrNull == null) ? 1 : intOrNull.intValue();
        this.windowType = intValue;
        if (intValue == 3) {
            iECShowWindowNetRepo = com.tencent.ecommerce.biz.showwindow.repo.c.f104652a;
        } else if (intValue != 4) {
            iECShowWindowNetRepo = com.tencent.ecommerce.biz.showwindow.repo.d.f104657a;
        } else {
            iECShowWindowNetRepo = com.tencent.ecommerce.biz.showwindow.repo.b.f104647a;
        }
        this.netRepo = iECShowWindowNetRepo;
    }

    public final LiveData<Boolean> R2() {
        return this.isAllSelected;
    }

    public final LiveData<Boolean> S2() {
        return this.isEndLiveData;
    }

    public final LiveData<Boolean> T2() {
        return this.isLoadingMoreLiveData;
    }

    /* renamed from: U2, reason: from getter */
    public final boolean getIsNetworkErrorLastTime() {
        return this.isNetworkErrorLastTime;
    }

    public final LiveData<Boolean> V2() {
        return this.isRefreshingLiveData;
    }

    public final void e3(boolean alwaysEditable) {
        this.isAlwaysEditable = alwaysEditable;
    }

    public final void f2(List<Product> products) {
        for (Product product : products) {
            e.f102613b.c(MeasureConst.SLI_TYPE_DISTRIBUTION + product.getSaasProductId());
        }
    }

    public final void f3(boolean isShowAddBtn) {
        this.isShowAddBtn = isShowAddBtn;
    }

    public final void g3(String str) {
        this.lastCookie = str;
    }

    public final void h2() {
        Iterator<Product> it = this._selectedProductList.iterator();
        while (it.hasNext()) {
            it.next().W(false);
        }
        this._selectedProductList.clear();
        this.selectedProductListLiveData.postValue(this._selectedProductList);
        this._isAllSelected.setValue(Boolean.FALSE);
    }

    public final void h3(k showPageCostTime) {
        this.showPageCostTime = showPageCostTime;
    }

    public final void i2(List<Product> products) {
        for (Product product : products) {
            PTSComposer ptsComposer = product.getPtsComposer();
            if (ptsComposer != null) {
                ptsComposer.destroy();
            }
            this._productList.remove(product);
        }
        w3();
        b3(products);
        h2();
        k2();
        p3();
    }

    public final void i3(Product product) {
        Iterator<Product> it = this._productList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Product next = it.next();
            if (Intrinsics.areEqual(product.getMediaProductId(), next.getMediaProductId())) {
                this._productList.remove(next);
                break;
            }
        }
        this._productList.add(0, product);
        w3();
        c3(product);
        h2();
        k2();
    }

    public final void j2() {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(this._productList);
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$destroyPtsComposerList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    PTSComposer ptsComposer = ((Product) it.next()).getPtsComposer();
                    if (ptsComposer != null) {
                        ptsComposer.destroy();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j3(int i3) {
        this.userSelectedCountFromBackend = i3;
    }

    public final void k2() {
        ECLocalConfig.f100650f.remove(u2(this.windowType), Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k3(int i3) {
        this._maxSelectCount = i3;
    }

    public final LiveData<Boolean> m2() {
        return this.backToTopLiveData;
    }

    public final void m3(boolean categoryPanelShown) {
        this._categoryPanelShowed.setValue(Boolean.valueOf(categoryPanelShown));
    }

    public final MutableLiveData<List<ck0.a>> n2() {
        return this.bannerListLiveData;
    }

    public final void n3(boolean editable) {
        if (!this.isAlwaysEditable || editable) {
            if (!this._productList.isEmpty()) {
                Iterator<Product> it = this._productList.iterator();
                while (it.hasNext()) {
                    it.next().K(editable);
                }
            }
            this._editable.setValue(Boolean.valueOf(editable));
        }
    }

    public final MutableLiveData<List<Category>> o2() {
        return this.categoryListLiveData;
    }

    public final void o3() {
        if (this._productList.size() <= 0) {
            return;
        }
        if (this._selectedProductList.size() < this._productList.size()) {
            this._selectedProductList.clear();
            this._selectedProductList.addAll(this._productList);
            Iterator<Product> it = this._productList.iterator();
            while (it.hasNext()) {
                it.next().W(true);
            }
        } else {
            this._selectedProductList.clear();
            Iterator<Product> it5 = this._productList.iterator();
            while (it5.hasNext()) {
                it5.next().W(false);
            }
        }
        this.selectedProductListLiveData.setValue(this._selectedProductList);
        p3();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }

    public final LiveData<Boolean> p2() {
        return this.categoryPanelShowedLiveData;
    }

    public final LiveData<Category> q2() {
        return this.currentCategoryLiveData;
    }

    public final void q3(boolean backToTop) {
        this._backToTop.postValue(Boolean.valueOf(backToTop));
    }

    public final LiveData<String> r2() {
        return this.currentSearchQueryLiveData;
    }

    public final void r3(Category category) {
        this._currentCategory.setValue(category);
    }

    public final LiveData<Boolean> s2() {
        return this.editableLiveData;
    }

    public final void s3(String query) {
        this._currentSearchQuery.setValue(query);
    }

    public final LiveData<Integer> t2() {
        return this.emptyPageStateLiveData;
    }

    public final void t3(int emptyPageStage) {
        this._emptyPageState.postValue(Integer.valueOf(emptyPageStage));
    }

    public final void u3(Bundle ext) {
        final Application a16 = wg0.a.a();
        if (!Intrinsics.areEqual(this.hasUserOperateList.getValue(), Boolean.TRUE)) {
            i.f101155b.d(a16.getResources().getString(R.string.wng), ECToastIcon.ICON_SUCCESS, 0);
            cg0.a.b("ECShowWindowViewModel", "\u5f53\u524d\u6ca1\u6709\u5546\u54c1\u53d8\u66f4");
            return;
        }
        if (this._maxSelectCount >= 0) {
            Integer value = this.userTotalSelectCount.getValue();
            if (value == null) {
                value = 0;
            }
            if (Intrinsics.compare(value.intValue(), this._maxSelectCount) > 0) {
                i.f101155b.d(a16.getResources().getString(R.string.wul), ECToastIcon.ICON_SUCCESS, 0);
                cg0.a.b("ECShowWindowViewModel", "\u5546\u54c1\u9009\u62e9\u8d85\u8fc7\u4e0a\u9650");
                return;
            }
        }
        e2();
        IECShowWindowNetRepo iECShowWindowNetRepo = this.netRepo;
        if (iECShowWindowNetRepo != null) {
            iECShowWindowNetRepo.reqUpdateProduct(this.channelId, this._selectedByUserProduectList, this._unselectedByUserProductList, ext, new Function1<com.tencent.ecommerce.biz.showwindow.repo.window.k, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$updateModifyedProduct$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ecommerce.biz.showwindow.repo.window.k kVar) {
                    invoke2(kVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final com.tencent.ecommerce.biz.showwindow.repo.window.k kVar) {
                    final String str = kVar.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE java.lang.String();
                    if (str.length() == 0) {
                        int i3 = kVar.getCom.tencent.mobileqq.vas.api.RemoteProxy.KEY_RESULT_TYPE java.lang.String();
                        if (i3 == 1) {
                            str = a16.getResources().getString(R.string.wnn);
                        } else if (i3 == 2) {
                            str = a16.getResources().getString(R.string.wnm);
                        } else if (i3 != 3) {
                            str = a16.getResources().getString(R.string.wnm);
                        } else {
                            str = a16.getResources().getString(R.string.wnh);
                        }
                    }
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$updateModifyedProduct$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MutableLiveData mutableLiveData;
                            ECShowWindowViewModel.this.finishRefresh();
                            i.f101155b.d(str, ECToastIcon.ICON_SUCCESS, 0);
                            mutableLiveData = ECShowWindowViewModel.this._totalAddSuccessCount;
                            mutableLiveData.postValue(Integer.valueOf(kVar.getTotalAddSuccessCount()));
                        }
                    });
                }
            }, new Function1<ECRemoteResponse, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$updateModifyedProduct$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ECRemoteResponse eCRemoteResponse) {
                    invoke2(eCRemoteResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ECRemoteResponse eCRemoteResponse) {
                    cg0.a.a("ECShowWindowViewModel", "updateModifyedProduct onError", eCRemoteResponse.getMsg());
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$updateModifyedProduct$2.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MutableLiveData mutableLiveData;
                            ECShowWindowViewModel.this.finishRefresh();
                            i.f101155b.d(a16.getResources().getString(R.string.wnm), ECToastIcon.ICON_ERROR, 0);
                            mutableLiveData = ECShowWindowViewModel.this._totalAddSuccessCount;
                            mutableLiveData.postValue(0);
                        }
                    });
                }
            });
        }
    }

    public final MutableLiveData<Boolean> v2() {
        return this.hasUserOperateList;
    }

    /* renamed from: w2, reason: from getter */
    public final String getLastCookie() {
        return this.lastCookie;
    }

    public final void w3() {
        this.productListLiveData.postValue(this._productList);
    }

    public final MutableLiveData<Integer> x2() {
        return this.maxSelectCount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void x3() {
        MutableLiveData<Boolean> mutableLiveData = this.hasUserOperateList;
        boolean z16 = true;
        if (!(!this._selectedByUserProduectList.isEmpty()) && !(!this._unselectedByUserProductList.isEmpty())) {
            z16 = false;
        }
        mutableLiveData.postValue(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void y3() {
        this.userTotalSelectCount.postValue(Integer.valueOf((this.userSelectedCountFromBackend + this._selectedByUserProduectList.size()) - this._unselectedByUserProductList.size()));
    }

    public final void I2(int channel, String mediaId, String sellerUin, String cookie, final boolean loadMore, boolean isNight) {
        t3(-1);
        if (loadMore) {
            d2();
        } else {
            e2();
        }
        IECShowWindowNetRepo iECShowWindowNetRepo = this.netRepo;
        if (iECShowWindowNetRepo != null) {
            iECShowWindowNetRepo.getViewProductList(channel, mediaId, sellerUin, cookie, isNight, new Function1<GetProductListRsp, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$getViewProductList$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GetProductListRsp getProductListRsp) {
                    invoke2(getProductListRsp);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final GetProductListRsp getProductListRsp) {
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$getViewProductList$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MutableLiveData mutableLiveData;
                            MutableLiveData mutableLiveData2;
                            MutableLiveData mutableLiveData3;
                            MutableLiveData mutableLiveData4;
                            ECShowWindowViewModel$getViewProductList$1 eCShowWindowViewModel$getViewProductList$1 = ECShowWindowViewModel$getViewProductList$1.this;
                            if (!loadMore) {
                                ECShowWindowViewModel.this.finishRefresh();
                            }
                            mutableLiveData = ECShowWindowViewModel.this._isEnd;
                            if (!Intrinsics.areEqual((Boolean) mutableLiveData.getValue(), Boolean.valueOf(getProductListRsp.getIsEnd()))) {
                                mutableLiveData4 = ECShowWindowViewModel.this._isEnd;
                                mutableLiveData4.setValue(Boolean.valueOf(getProductListRsp.getIsEnd()));
                            }
                            ECShowWindowViewModel$getViewProductList$1 eCShowWindowViewModel$getViewProductList$12 = ECShowWindowViewModel$getViewProductList$1.this;
                            ECShowWindowViewModel.this.P2(loadMore, getProductListRsp.d());
                            ECShowWindowViewModel.this.g3(getProductListRsp.getCookie());
                            ECShowWindowViewModel$getViewProductList$1 eCShowWindowViewModel$getViewProductList$13 = ECShowWindowViewModel$getViewProductList$1.this;
                            if (loadMore) {
                                ECShowWindowViewModel.this.l2();
                            }
                            mutableLiveData2 = ECShowWindowViewModel.this._windowTitle;
                            mutableLiveData2.postValue(getProductListRsp.getWindowTitle());
                            mutableLiveData3 = ECShowWindowViewModel.this._totalProductCount;
                            mutableLiveData3.setValue(Integer.valueOf(getProductListRsp.getTotal()));
                            ECShowWindowViewModel$getViewProductList$1 eCShowWindowViewModel$getViewProductList$14 = ECShowWindowViewModel$getViewProductList$1.this;
                            if (loadMore) {
                                return;
                            }
                            ECShowWindowViewModel.this.Y2(true, false);
                        }
                    });
                }
            }, new Function1<ECRemoteResponse, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$getViewProductList$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ECRemoteResponse eCRemoteResponse) {
                    invoke2(eCRemoteResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ECRemoteResponse eCRemoteResponse) {
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$getViewProductList$2.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            cg0.a.a("ECShowWindowViewModel", "getViewProductList$\\onError", "[getViewProductList] onError");
                            ECShowWindowViewModel$getViewProductList$2 eCShowWindowViewModel$getViewProductList$2 = ECShowWindowViewModel$getViewProductList$2.this;
                            if (loadMore) {
                                ECShowWindowViewModel.this.l2();
                                return;
                            }
                            ECShowWindowViewModel.this.finishRefresh();
                            ECShowWindowViewModel.this.isNetworkErrorLastTime = true;
                            ECShowWindowViewModel.this.t3(2);
                            ECShowWindowViewModel.this.Y2(false, false);
                        }
                    });
                }
            });
        }
    }

    public ECShowWindowViewModel() {
        MutableLiveData<JSONObject> mutableLiveData = new MutableLiveData<>();
        this._totalRsp = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._editable = mutableLiveData2;
        Boolean bool = Boolean.FALSE;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(bool);
        this._categoryPanelShowed = mutableLiveData3;
        this._productList = new ArrayList<>();
        ArrayList<Category> arrayList = new ArrayList<>();
        this._categoryList = arrayList;
        ArrayList<Product> arrayList2 = new ArrayList<>();
        this._selectedProductList = arrayList2;
        ArrayList<Product> arrayList3 = new ArrayList<>();
        this._selectedByUserProduectList = arrayList3;
        ArrayList<Product> arrayList4 = new ArrayList<>();
        this._unselectedByUserProductList = arrayList4;
        MutableLiveData<Category> mutableLiveData4 = new MutableLiveData<>();
        this._currentCategory = mutableLiveData4;
        MutableLiveData<String> mutableLiveData5 = new MutableLiveData<>();
        this._currentSearchQuery = mutableLiveData5;
        MutableLiveData<Boolean> mutableLiveData6 = new MutableLiveData<>(bool);
        this._backToTop = mutableLiveData6;
        MutableLiveData<String> mutableLiveData7 = new MutableLiveData<>();
        this._windowTitle = mutableLiveData7;
        MutableLiveData<Integer> mutableLiveData8 = new MutableLiveData<>(-1);
        this._emptyPageState = mutableLiveData8;
        MutableLiveData<Boolean> mutableLiveData9 = new MutableLiveData<>(bool);
        this._isLoadingMore = mutableLiveData9;
        MutableLiveData<Boolean> mutableLiveData10 = new MutableLiveData<>(bool);
        this._isEnd = mutableLiveData10;
        MutableLiveData<Boolean> mutableLiveData11 = new MutableLiveData<>(bool);
        this._isRefreshing = mutableLiveData11;
        MutableLiveData<Integer> mutableLiveData12 = new MutableLiveData<>();
        this._totalAddSuccessCount = mutableLiveData12;
        MutableLiveData<Boolean> mutableLiveData13 = new MutableLiveData<>(bool);
        this._isAllSelected = mutableLiveData13;
        this.isAllSelected = mutableLiveData13;
        this.editableLiveData = mutableLiveData2;
        this.categoryPanelShowedLiveData = mutableLiveData3;
        this.productListLiveData = new MutableLiveData<>();
        this.bannerListLiveData = new MutableLiveData<>();
        this.categoryListLiveData = new MutableLiveData<>(arrayList);
        this.selectedProductListLiveData = new MutableLiveData<>(arrayList2);
        this.currentCategoryLiveData = mutableLiveData4;
        this.currentSearchQueryLiveData = mutableLiveData5;
        this.backToTopLiveData = mutableLiveData6;
        this.windowTitleLiveData = mutableLiveData7;
        this.emptyPageStateLiveData = mutableLiveData8;
        this.isLoadingMoreLiveData = mutableLiveData9;
        this.isEndLiveData = mutableLiveData10;
        this.isRefreshingLiveData = mutableLiveData11;
        this.totalAddSuccessCount = mutableLiveData12;
        this.userTotalSelectCount = new MutableLiveData<>();
        this.hasUserOperateList = new MutableLiveData<>(bool);
        this.selectedByUserProductList = new MutableLiveData<>(arrayList3);
        this.unselectedByUserProductList = new MutableLiveData<>(arrayList4);
        this.maxSelectCount = new MutableLiveData<>();
        this.totalRspLiveData = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData14 = new MutableLiveData<>();
        this._totalProductCount = mutableLiveData14;
        this.totalProductCount = mutableLiveData14;
        this.lastCookie = "";
        this.channelId = -1;
        this.contentId = "";
        this.isFirstRequest = true;
        this._maxSelectCount = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N2(boolean isFromQuery, List<ck0.a> bannerList) {
        if (isFromQuery) {
            this.bannerListLiveData.postValue(new ArrayList());
        } else {
            this.bannerListLiveData.postValue(bannerList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P2(boolean loadMore, List<Product> productList) {
        boolean z16;
        if (productList != null) {
            boolean z17 = false;
            for (Product product : productList) {
                Boolean value = this._editable.getValue();
                if (value == null) {
                    value = Boolean.FALSE;
                }
                boolean booleanValue = value.booleanValue();
                product.K(booleanValue);
                if (booleanValue) {
                    product.X(false);
                } else {
                    product.X(this.isShowAddBtn);
                }
                if (!this._selectedByUserProduectList.contains(product)) {
                    if (this._unselectedByUserProductList.contains(product) || !product.getSelectStatusFromBackend()) {
                        z16 = false;
                    } else if (product.getState() != 1 || product.getInventory() <= 0) {
                        this._unselectedByUserProductList.add(product);
                        z16 = false;
                        z17 = true;
                    }
                    product.W(z16);
                    if (Intrinsics.areEqual(this._isAllSelected.getValue(), Boolean.TRUE) && !ECShowWindowFragment.INSTANCE.a(this.windowType)) {
                        product.W(true);
                    }
                    W2(product);
                    if (product.getSelected() && !this._selectedProductList.contains(product)) {
                        this._selectedProductList.add(product);
                    }
                }
                z16 = true;
                product.W(z16);
                if (Intrinsics.areEqual(this._isAllSelected.getValue(), Boolean.TRUE)) {
                    product.W(true);
                }
                W2(product);
                if (product.getSelected()) {
                    this._selectedProductList.add(product);
                }
            }
            this._productList.addAll(productList);
            w3();
            Boolean value2 = this._editable.getValue();
            if (value2 == null) {
                value2 = Boolean.FALSE;
            }
            if (value2.booleanValue()) {
                this.selectedProductListLiveData.postValue(this._selectedProductList);
                if (z17) {
                    this.unselectedByUserProductList.postValue(this._unselectedByUserProductList);
                    x3();
                }
                y3();
            }
        }
    }

    public final void d3(Product selectedProduct, boolean isSelected) {
        if (isSelected && this._maxSelectCount >= 0) {
            Integer value = this.userTotalSelectCount.getValue();
            if (value == null) {
                value = 0;
            }
            if (Intrinsics.compare(value.intValue(), this._maxSelectCount) >= 0) {
                i.f101155b.d(wg0.a.a().getResources().getString(R.string.wul), ECToastIcon.ICON_ERROR, 0);
                return;
            }
        }
        Iterator<Product> it = this._productList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Product next = it.next();
            if (next.equals(selectedProduct)) {
                cg0.a.b("ECShowWindowViewModel", "selectProduct, product=" + System.identityHashCode(next) + ", selectedProduct=" + System.identityHashCode(selectedProduct));
                next.W(isSelected);
                break;
            }
        }
        if (isSelected) {
            this._selectedProductList.add(selectedProduct);
            this._unselectedByUserProductList.remove(selectedProduct);
            this.unselectedByUserProductList.setValue(this._unselectedByUserProductList);
            if (selectedProduct.getSelected() != selectedProduct.getSelectStatusFromBackend()) {
                this._selectedByUserProduectList.add(selectedProduct);
                this.selectedByUserProductList.setValue(this._selectedByUserProduectList);
            }
        } else {
            this._selectedProductList.remove(selectedProduct);
            this._selectedByUserProduectList.remove(selectedProduct);
            this.selectedByUserProductList.setValue(this._selectedByUserProduectList);
            if (selectedProduct.getSelected() != selectedProduct.getSelectStatusFromBackend()) {
                this._unselectedByUserProductList.add(selectedProduct);
                this.unselectedByUserProductList.setValue(this._unselectedByUserProductList);
            }
        }
        this.selectedProductListLiveData.setValue(this._selectedProductList);
        x3();
        y3();
        p3();
    }

    public final void v3(List<Product> productList, boolean isVisible) {
        if (productList == null || productList.isEmpty()) {
            return;
        }
        try {
            Boolean value = this._editable.getValue();
            if (value == null) {
                value = Boolean.FALSE;
            }
            boolean booleanValue = value.booleanValue();
            for (Product product : productList) {
                product.X(isVisible);
                product.L(booleanValue);
                product.S(fj0.c.f399474a.a(product, fg0.a.f398587b.a()));
            }
        } catch (JSONException e16) {
            cg0.a.a("ECShowWindowViewModel", "updateProductAddBtnVisibility", "[updateProductAddBtnVisibility] e = " + e16);
        }
    }

    public final void y2(int channel, final String query, String categoryId, final int windowType, String cookie, final boolean loadMore, final boolean firstScreen, Bundle bundle, int source) {
        ECShowWindowFragment.INSTANCE.a(windowType);
        t3(-1);
        if (firstScreen) {
            O2(windowType);
        }
        if (loadMore) {
            d2();
        } else {
            e2();
        }
        Boolean value = this._editable.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        boolean booleanValue = value.booleanValue();
        bundle.putBoolean("isShowAddBtn", booleanValue ? false : this.isShowAddBtn);
        bundle.putBoolean("isEdited", booleanValue);
        IECShowWindowNetRepo iECShowWindowNetRepo = this.netRepo;
        if (iECShowWindowNetRepo != null) {
            iECShowWindowNetRepo.getProductAndCategoryList(channel, query, categoryId, windowType, cookie, bundle, new Function1<GetProductListRsp, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$getProductAndCategoryList$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GetProductListRsp getProductListRsp) {
                    invoke2(getProductListRsp);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final GetProductListRsp getProductListRsp) {
                    MutableLiveData mutableLiveData;
                    boolean l3;
                    boolean z16;
                    String str;
                    String u26;
                    mutableLiveData = ECShowWindowViewModel.this._totalRsp;
                    mutableLiveData.postValue(getProductListRsp.getDataJson());
                    l3 = ECShowWindowViewModel.this.l3(firstScreen, query);
                    if (l3) {
                        JSONObject dataJson = getProductListRsp.getDataJson();
                        if (dataJson == null || (str = dataJson.toString()) == null) {
                            str = "";
                        }
                        if (!TextUtils.isEmpty(str)) {
                            ECLocalConfig eCLocalConfig = ECLocalConfig.f100650f;
                            u26 = ECShowWindowViewModel.this.u2(windowType);
                            eCLocalConfig.setString(u26, str, Boolean.TRUE);
                        }
                    }
                    if (ECShowWindowViewModel.this.get_maxSelectCount() <= 0) {
                        ECShowWindowViewModel.this.k3(getProductListRsp.getSelectedProductsLimit());
                        ECShowWindowViewModel.this.x2().postValue(Integer.valueOf(ECShowWindowViewModel.this.get_maxSelectCount()));
                    }
                    z16 = ECShowWindowViewModel.this.isFirstRequest;
                    if (z16) {
                        ECShowWindowViewModel.this.j3(getProductListRsp.getSelectedProductsCount());
                    }
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$getProductAndCategoryList$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MutableLiveData mutableLiveData2;
                            MutableLiveData mutableLiveData3;
                            MutableLiveData mutableLiveData4;
                            mutableLiveData2 = ECShowWindowViewModel.this._totalProductCount;
                            mutableLiveData2.setValue(Integer.valueOf(getProductListRsp.getTotal()));
                            ECShowWindowViewModel$getProductAndCategoryList$1 eCShowWindowViewModel$getProductAndCategoryList$1 = ECShowWindowViewModel$getProductAndCategoryList$1.this;
                            if (!loadMore) {
                                ECShowWindowViewModel.this.g2();
                                ECShowWindowViewModel.this.q3(true);
                                ECShowWindowViewModel.this.finishRefresh();
                            }
                            mutableLiveData3 = ECShowWindowViewModel.this._isEnd;
                            if (!Intrinsics.areEqual((Boolean) mutableLiveData3.getValue(), Boolean.valueOf(getProductListRsp.getIsEnd()))) {
                                mutableLiveData4 = ECShowWindowViewModel.this._isEnd;
                                mutableLiveData4.setValue(Boolean.valueOf(getProductListRsp.getIsEnd()));
                            }
                            ECShowWindowViewModel$getProductAndCategoryList$1 eCShowWindowViewModel$getProductAndCategoryList$12 = ECShowWindowViewModel$getProductAndCategoryList$1.this;
                            ECShowWindowViewModel.this.N2(query.length() > 0, getProductListRsp.a());
                            ECShowWindowViewModel$getProductAndCategoryList$1 eCShowWindowViewModel$getProductAndCategoryList$13 = ECShowWindowViewModel$getProductAndCategoryList$1.this;
                            ECShowWindowViewModel.this.P2(loadMore, getProductListRsp.d());
                            ECShowWindowViewModel$getProductAndCategoryList$1 eCShowWindowViewModel$getProductAndCategoryList$14 = ECShowWindowViewModel$getProductAndCategoryList$1.this;
                            if (loadMore) {
                                ECShowWindowViewModel.this.l2();
                            }
                            ECShowWindowViewModel.this.g3(getProductListRsp.getCookie());
                            ECShowWindowViewModel$getProductAndCategoryList$1 eCShowWindowViewModel$getProductAndCategoryList$15 = ECShowWindowViewModel$getProductAndCategoryList$1.this;
                            if (firstScreen) {
                                ECShowWindowViewModel.this.Y2(true, true);
                            }
                        }
                    });
                    ECShowWindowViewModel.this.isFirstRequest = true;
                }
            }, new Function1<ECRemoteResponse, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$getProductAndCategoryList$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ECRemoteResponse eCRemoteResponse) {
                    invoke2(eCRemoteResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ECRemoteResponse eCRemoteResponse) {
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel$getProductAndCategoryList$2.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            cg0.a.a("ECShowWindowViewModel", "[getProductAndCategoryList]", "[onError]");
                            ECShowWindowViewModel.this.l2();
                            ECShowWindowViewModel.this.finishRefresh();
                            ECShowWindowViewModel.this.isNetworkErrorLastTime = true;
                            ECShowWindowViewModel$getProductAndCategoryList$2 eCShowWindowViewModel$getProductAndCategoryList$2 = ECShowWindowViewModel$getProductAndCategoryList$2.this;
                            if (!loadMore) {
                                ECShowWindowViewModel.this.t3(2);
                            }
                            ECShowWindowViewModel$getProductAndCategoryList$2 eCShowWindowViewModel$getProductAndCategoryList$22 = ECShowWindowViewModel$getProductAndCategoryList$2.this;
                            if (firstScreen) {
                                ECShowWindowViewModel.this.Y2(false, true);
                            }
                        }
                    });
                }
            }, source);
        }
    }

    public static /* synthetic */ void z2(ECShowWindowViewModel eCShowWindowViewModel, int i3, String str, String str2, int i16, String str3, boolean z16, boolean z17, Bundle bundle, int i17, int i18, Object obj) {
        if (obj == null) {
            eCShowWindowViewModel.y2(i3, str, str2, (i18 & 8) != 0 ? 0 : i16, (i18 & 16) != 0 ? "" : str3, (i18 & 32) != 0 ? false : z16, (i18 & 64) != 0 ? false : z17, (i18 & 128) != 0 ? new Bundle() : bundle, (i18 & 256) != 0 ? 0 : i17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getProductAndCategoryList");
    }

    protected void W2(Product product) {
    }
}
