package com.tencent.mobileqq.kandian.biz.common.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.b;
import com.tencent.mobileqq.kandian.base.utils.c;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m52.a;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\u00a2\u0006\u0006\b\u00bf\u0001\u0010\u00c0\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J'\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001a\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u001a\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001dJ\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010 \u001a\u00020\bH\u0016J\"\u0010$\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u00142\u0006\u0010#\u001a\u00020\bH\u0016J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u000eH\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0012\u0010,\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u00100\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u00101\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u00103\u001a\u00020\u00062\u0006\u0010.\u001a\u000202H\u0016J\u0010\u00104\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u00105\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u00106\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u00107\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u00108\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u00109\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u0010:\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u0010;\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u0010<\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010=\u001a\u00020\u000eH\u0016J\b\u0010?\u001a\u00020>H\u0016J\b\u0010@\u001a\u00020\u000eH\u0016J\b\u0010A\u001a\u00020\u000eH\u0016J\b\u0010B\u001a\u00020\bH\u0016J\n\u0010C\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010D\u001a\u00020\bH\u0016J\b\u0010E\u001a\u00020\bH\u0016J\b\u0010F\u001a\u00020\u000eH\u0016J\b\u0010G\u001a\u00020\u000eH\u0016J\b\u0010H\u001a\u00020\u0006H\u0016J\b\u0010I\u001a\u00020\u000eH\u0016J\u0012\u0010K\u001a\u00020\u000e2\b\u0010J\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010L\u001a\u00020\u000eH\u0016J\b\u0010M\u001a\u00020\bH\u0016J\b\u0010N\u001a\u00020\u000eH\u0016J\n\u0010O\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010Q\u001a\u00020\u00062\b\u0010P\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010R\u001a\u00020\u0006H\u0016J\b\u0010S\u001a\u00020\u0006H\u0016J\u0012\u0010U\u001a\u00020\u00062\b\u0010T\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010V\u001a\u00020\u00062\b\u0010T\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010W\u001a\u00020\u00062\b\u0010T\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010Y\u001a\u00020\u00062\u0006\u0010X\u001a\u00020\u000eH\u0016J\u0010\u0010Z\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u000eH\u0016J\u0012\u0010[\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\\\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010^\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u000eH\u0016J\u0012\u0010_\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010`\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010c\u001a\u00020\u00062\u0006\u0010b\u001a\u00020\u000eH\u0016J\u0010\u0010d\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u0010e\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\bH\u0016J\u001c\u0010f\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010g\u001a\u00020\u00062\u0006\u0010T\u001a\u00020\u0014H\u0016J\u0010\u0010i\u001a\u00020\u00062\u0006\u0010h\u001a\u00020\u000eH\u0016J\u0012\u0010k\u001a\u00020\u00062\b\u0010j\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010l\u001a\u00020\u00062\b\u0010j\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010m\u001a\u00020\u00062\b\u0010j\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010n\u001a\u00020\u00062\b\u0010j\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010o\u001a\u00020\u000e2\b\u0010j\u001a\u0004\u0018\u00010\u0014H\u0016J/\u0010p\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\bp\u0010qJ\b\u0010r\u001a\u00020\u000eH\u0016J\u0010\u0010s\u001a\u00020\u00062\u0006\u0010h\u001a\u00020\u000eH\u0016J\b\u0010t\u001a\u00020\u000eH\u0016J\u0012\u0010w\u001a\u00020\u00062\b\u0010v\u001a\u0004\u0018\u00010uH\u0016J\u0010\u0010x\u001a\u00020\u00062\u0006\u0010h\u001a\u00020\u000eH\u0016J\b\u0010y\u001a\u00020\u000eH\u0016J\u0010\u0010z\u001a\u00020\u00062\u0006\u0010h\u001a\u00020\u000eH\u0016J\b\u0010{\u001a\u00020\u000eH\u0016J\u0010\u0010|\u001a\u00020\u00062\u0006\u0010h\u001a\u00020\u000eH\u0016J\b\u0010}\u001a\u00020\u000eH\u0016J\u0010\u0010~\u001a\u00020\u00062\u0006\u0010h\u001a\u00020\u000eH\u0016J\b\u0010\u007f\u001a\u00020\u000eH\u0016J\u0011\u0010\u0080\u0001\u001a\u00020\u00062\u0006\u0010h\u001a\u00020\u000eH\u0016J\t\u0010\u0081\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010\u0083\u0001\u001a\u00020\u00062\u0007\u0010\u0082\u0001\u001a\u00020\u000eH\u0016J\t\u0010\u0084\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010\u0085\u0001\u001a\u00020\u00062\u0007\u0010\u0082\u0001\u001a\u00020\u000eH\u0016J\t\u0010\u0086\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010\u0088\u0001\u001a\u00020\u00062\u0007\u0010\u0087\u0001\u001a\u00020\u000eH\u0016J\t\u0010\u0089\u0001\u001a\u00020\u000eH\u0016J\u0011\u0010\u008a\u0001\u001a\u00020\u00062\u0006\u0010h\u001a\u00020\u000eH\u0016J\t\u0010\u008b\u0001\u001a\u00020>H\u0016J\t\u0010\u008c\u0001\u001a\u00020\u0006H\u0016J/\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u0017\u0010qJ\u001c\u0010\u008e\u0001\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u000e2\u0007\u0010\u008d\u0001\u001a\u00020\u000eH\u0016J\t\u0010\u008f\u0001\u001a\u00020\u000eH\u0016J\t\u0010\u0090\u0001\u001a\u00020\u000eH\u0016J-\u0010\u0095\u0001\u001a\u00020\u00062\u0007\u0010\u0091\u0001\u001a\u00020\b2\u0007\u0010\u0092\u0001\u001a\u00020>2\u0007\u0010\u0093\u0001\u001a\u00020\b2\u0007\u0010\u0094\u0001\u001a\u00020\bH\u0016J\f\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0016J3\u0010\u009c\u0001\u001a\u00020\u00062\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0099\u0001\u001a\u00020\b2\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0016J\t\u0010\u009d\u0001\u001a\u00020\u000eH\u0016J\u001e\u0010\u009f\u0001\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00142\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0014H\u0016J\t\u0010\u00a0\u0001\u001a\u00020\u000eH\u0016J\u0012\u0010\u00a2\u0001\u001a\u00020\u000e2\u0007\u0010\u00a1\u0001\u001a\u00020\bH\u0016J\u0014\u0010\u00a3\u0001\u001a\u00020\u000e2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0002H\u0016J\t\u0010\u00a4\u0001\u001a\u00020\u000eH\u0016J\u0015\u0010\u00a7\u0001\u001a\u00020\b2\n\u0010\u00a6\u0001\u001a\u0005\u0018\u00010\u00a5\u0001H\u0016J\u0011\u0010&\u001a\u00020\u00062\u0007\u0010\u00a8\u0001\u001a\u00020\bH\u0016J\u0014\u0010\u00a9\u0001\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0006\b\u00a9\u0001\u0010\u00aa\u0001J\u0011\u0010\u00ab\u0001\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0014\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00142\u0007\u0010\u00ac\u0001\u001a\u00020\bH\u0016J\u0011\u0010\u00ae\u0001\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\bH\u0016J\u0012\u0010\u00b0\u0001\u001a\u00020\u00062\u0007\u0010\u00af\u0001\u001a\u00020\u0014H\u0016JX\u0010\u00ba\u0001\u001a\u00020\u00062\u0007\u0010\u00b1\u0001\u001a\u00020\u00142\u0007\u0010\u00b2\u0001\u001a\u00020\u00142\n\u0010\u00b4\u0001\u001a\u0005\u0018\u00010\u00b3\u00012\u0018\u0010\u00b6\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u0096\u0001\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010\u00b5\u00012\t\u0010\u00b7\u0001\u001a\u0004\u0018\u00010\u00142\n\u0010\u00b9\u0001\u001a\u0005\u0018\u00010\u00b8\u0001H\u0016JV\u0010\u00ba\u0001\u001a\u00020\u00062\u0007\u0010\u00b1\u0001\u001a\u00020\u00142\u0007\u0010\u00b2\u0001\u001a\u00020\u00142\n\u0010\u00b4\u0001\u001a\u0005\u0018\u00010\u00b3\u00012\u0007\u0010\u00bb\u0001\u001a\u00020\b2\u0018\u0010\u00b6\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u0096\u0001\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010\u00b5\u00012\n\u0010\u00b9\u0001\u001a\u0005\u0018\u00010\u00b8\u0001H\u0016JD\u0010\u00be\u0001\u001a\u00020\u00062\u0007\u0010\u00bc\u0001\u001a\u00020\u00142\n\u0010\u00b4\u0001\u001a\u0005\u0018\u00010\u00b3\u00012\u0018\u0010\u00b6\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u0096\u0001\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010\u00b5\u00012\n\u0010\u00b9\u0001\u001a\u0005\u0018\u00010\u00bd\u0001H\u0016\u00a8\u0006\u00c1\u0001"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/ReadInJoyHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoyHelper;", "Landroid/app/Activity;", "fromActivity", "Landroid/content/Intent;", "intent", "", "launchReadInJoyPlugin", "", "accessMode", "Landroid/content/SharedPreferences;", "getReadInJoySharedPreferences", "Landroid/content/SharedPreferences$Editor;", "editor", "", "applyFirst", "applySharedPreferences", "maybeInitializedAladdin", "initAladdin", "T", "", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getReadInJoySpValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "value", "updateReadInJoySpValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "isAccountRelated", "(Ljava/lang/String;Ljava/lang/Object;Z)V", "bidKey", "getProteusOfflineBid", "getReadInJoyMultiVideoChannelInfoVersion", "channelID", "channelName", "channelType", "updateReadInJoyMultiVideoChannelInfo", "enable", "updateSupportMultiVideoSwitch", "updateVideoStructMsgPlaySwitch", "updateKandianVideoSocialSwitch", "updateVideoChannelAutoPlaySwitchDefaultValue", "updateReadInJoyVideoJumpDefaultValue", "bitRateStr", "updateKandianConfigDefaultBitRate", "updateCUKingCardDlgSwitch", WidgetCacheConstellationData.NUM, "updateVideoChannelCoverStyle", "updateVideoDynamicRecommmendStrategy", "updateVideoDynamicRecommmendDurationLimit", "", "updateVideoDynamicRecommendDurationPercent", "updateVideoDynamicRecommendOperator", "updateWebRenderConfig", "updateWebRenderModeConfig", "updateVideoChannelAutoPlaySwitchDefaultValueVideoFlow", "updateVideoChannelFeedsClickSwitchValue", "updateViolaDynamicConfig", "updateViolaWeishiAdConfig", "updateViolaDiscoverConfig", "updateViolaMessageBoxConfig", "isInReadinjoyFolderMergerStyle", "", "getFFProbesize", "isFFProbelistSwitch", "isDownloadAsyncIo", "getDynamicBufferSwitch", "getDynamicBufferConfig", "getCameraCaptureMaxDuration", "getReadInjoyShareToWxAtSwitch", "getWebRenderConfig", "getCanLoadStartWebRenderModeConfig", "synSwitchCache", "canFreeTimeRefreshPush", "uin", "canInMessageList", "getRemoveKandianFlag", "getKandianConfigBadgeSwitch", "getKanDianReportTTSwitch", "checkLastScanTTDate", "date", "setLastScanTTDate", "updateReadinjoyFolderMergerReal", "updateReadinjoyStopFunctionSwtichReal", "setting", "updateReadInJoySmartCropSetting", "updateReadInJoyFeedsGroupSetting", "updateReadInJoyPushMsgSwitch", "flag", "updateReadInJoyIndividualPushSwitchSetting", "updateReadinjoySubscribeListPush", "findSocialFeedsWebUrlKey", "updateSocialFeedsWebJumpUrl", "can", "updateFreeTimeRefreshPush", "updateKandianMyTabPage", "updateGallerySubChannelHidden", "updateGallerySubChannelWaterFallHidden", "reportSwitch", "setKanDianReportTTSwitch", "updateKandianConfigRedShowNum", "updateKandianConfigRedThreshold", "updateSelfFragmentFeedBackConf", "updateReadinjoyFolderMergerConfig", "show", "updateOpenSimpleSwitchFm", DownloadInfo.spKey_Config, "onShareToNewsConfigChanged", "onSynchronizeToQzoneConfigChanged", "onMergeFeedsConfigChanged", "onKandianFeedsConfigChanged", "updateArkChannelConfig", "getKDSPValueWithKey", "(Ljava/lang/String;Ljava/lang/Object;Z)Ljava/lang/Object;", "getInnerVideoInfoShowSWitcher", "updateInnerVideoInfoShowSwitcher", "getSplasDebugSWitcher", "Lorg/json/JSONObject;", "r5", "addExtraInfoInJson", "updateSplashDebugSwitcher", "getViolaDebugSWitcher", "updateViolaDebugSwitcher", "getViolaJsDebugBundleSwitcher", "updateViolaJsDebugBundleSwitcher", "getViolaJsLocalBundleSwitcher", "updateViolaJsLocalBundleSwitcher", "getViolaRecommendSwitcher", "updateViolaRecommendSwitcher", "isViolaMessageBoxInTest", QFSSearchBaseRequest.EXTRA_KEY_IS_TEST_ENVIRONMENT, "updateVideoMessageBoxSwitcher", "isViolaColumnEntryInTest", "updateVideoColumnEntrySwitcher", "isRIJVideoEnableReprint", "enableReprint", "updateRIJVideoEnableReprint", "isShowRecommendReasonInTitle", "updateShowRecommendReasonInTitle", "getVideoRealTimeLogDebug", "updateVideoRealTimeLogDebug", "isSupportMultiProcess", "getReadInJoySP", "getVideoStructMsgPlaySwitch", "getViolaPicDetailConfig", "source", "sourceArticleId", QCircleDaTongConstant.ElementParamValue.OPERATION, "opsource", "reportArticleByWeb", "", "getKandianLebaViewItem", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "requestCode", "Landroid/content/DialogInterface$OnDismissListener;", "dismissListener", "forwardToReadInJoyFeed", "checkIsVideoFeedsGameAdComBarLocalConfigToday", "bid", "updateProteusOfflineBid", "getReadinjoyStopFunctionSwitch", "videoFromType", "isFromVideoColumn", "isInSplashActivity", "isShowMainVideoTab", "Lmqq/app/AppRuntime;", "app", "getKandianConfigAdExposureThreshold", "enableSw", "getUserConfigVersion", "()Ljava/lang/Integer;", "setUserConfigVersion", "count", "generateSocialCountLess99", "adSuperMaskServiceSetChannelId", "msg", "adSuperMaskLog", "service", "method", "", "param", "", "extra", "refer", "Ll52/a;", "callback", "ssoForward", "serializationType", "cmd", "Ll52/b;", "sendSsoCmdRequest", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ReadInJoyHelperImpl implements IReadInJoyHelper {
    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void adSuperMaskLog(String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void addExtraInfoInJson(JSONObject r56) {
        ReadInJoyHelper.b(r56);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean canFreeTimeRefreshPush() {
        return ReadInJoyHelper.c(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean canInMessageList(String uin) {
        return ReadInJoyHelper.d(uin);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean checkIsVideoFeedsGameAdComBarLocalConfigToday() {
        return ReadInJoyHelper.e(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public String checkLastScanTTDate() {
        return ReadInJoyHelper.f(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean findSocialFeedsWebUrlKey(String key) {
        return ReadInJoyHelper.i(key);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void forwardToReadInJoyFeed(Activity activity, Intent intent, int requestCode, DialogInterface.OnDismissListener dismissListener) {
        ReadInJoyHelper.j(activity, intent, requestCode, dismissListener);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public String generateSocialCountLess99(int count) {
        return ReadInJoyHelper.k(count);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public int getCameraCaptureMaxDuration() {
        return ReadInJoyHelper.m(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean getCanLoadStartWebRenderModeConfig() {
        return ReadInJoyHelper.n(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public String getDynamicBufferConfig() {
        return "";
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public int getDynamicBufferSwitch() {
        return 0;
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public long getFFProbesize() {
        return ReadInJoyHelper.p();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean getInnerVideoInfoShowSWitcher() {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return ReadInJoyHelper.q((QQAppInterface) c16);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public <T> T getKDSPValueWithKey(String key, T defaultValue, boolean isAccountRelated) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) c.d(key, defaultValue, isAccountRelated);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean getKanDianReportTTSwitch() {
        return ReadInJoyHelper.r(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public int getKandianConfigAdExposureThreshold(AppRuntime app) {
        return ReadInJoyHelper.s(app);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public int getKandianConfigBadgeSwitch() {
        return ReadInJoyHelper.t(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public Object getKandianLebaViewItem() {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return ReadInJoyHelper.v((QQAppInterface) c16);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public String getProteusOfflineBid(String bidKey) {
        return "0";
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public int getReadInJoyMultiVideoChannelInfoVersion() {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return ReadInJoyHelper.x((QQAppInterface) c16);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public SharedPreferences getReadInJoySP(boolean isAccountRelated, boolean isSupportMultiProcess) {
        return c.b(b.c(), isAccountRelated, isSupportMultiProcess);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public SharedPreferences getReadInJoySharedPreferences(int accessMode) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return ReadInJoyHelper.y((QQAppInterface) c16, accessMode);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public <T> T getReadInJoySpValue(String key, T defaultValue) {
        return (T) c.c(key, defaultValue);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public int getReadInjoyShareToWxAtSwitch() {
        return ReadInJoyHelper.A(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public synchronized boolean getReadinjoyStopFunctionSwitch() {
        return false;
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean getRemoveKandianFlag() {
        return ReadInJoyHelper.C();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean getSplasDebugSWitcher() {
        return ReadInJoyHelper.D(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public Integer getUserConfigVersion() {
        BaseApplication app;
        SharedPreferences sharedPreferences;
        QQAppInterface qQAppInterface = (QQAppInterface) b.c();
        if (qQAppInterface == null || (app = qQAppInterface.getApp()) == null || (sharedPreferences = app.getSharedPreferences(IReadInJoyHelper.HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION, 4)) == null) {
            return null;
        }
        return Integer.valueOf(sharedPreferences.getInt(IReadInJoyHelper.HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION + qQAppInterface.getCurrentAccountUin(), 0));
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public long getVideoRealTimeLogDebug() {
        return ReadInJoyHelper.I();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean getVideoStructMsgPlaySwitch() {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return ReadInJoyHelper.J((QQAppInterface) c16);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean getViolaDebugSWitcher() {
        return ReadInJoyHelper.K(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean getViolaJsDebugBundleSwitcher() {
        return ReadInJoyHelper.L(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean getViolaJsLocalBundleSwitcher() {
        return ReadInJoyHelper.M(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean getViolaPicDetailConfig() {
        return false;
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean getViolaRecommendSwitcher() {
        return ReadInJoyHelper.N(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean getWebRenderConfig() {
        return ReadInJoyHelper.O(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean isDownloadAsyncIo() {
        return ReadInJoyHelper.P();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean isFFProbelistSwitch() {
        return ReadInJoyHelper.Q();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean isFromVideoColumn(int videoFromType) {
        return ReadInJoyHelper.R(videoFromType);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean isInReadinjoyFolderMergerStyle() {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return ReadInJoyHelper.S((QQAppInterface) c16);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean isInSplashActivity(Activity activity) {
        return activity instanceof SplashActivity;
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean isRIJVideoEnableReprint() {
        return ReadInJoyHelper.T(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean isShowMainVideoTab() {
        return ReadInJoyHelper.V();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean isShowRecommendReasonInTitle() {
        return ReadInJoyHelper.X(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean isViolaColumnEntryInTest() {
        return ReadInJoyHelper.Y(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean isViolaMessageBoxInTest() {
        return ReadInJoyHelper.Z(b.c());
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void launchReadInJoyPlugin(Activity fromActivity, Intent intent) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.a0((QQAppInterface) c16, fromActivity, intent);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void onKandianFeedsConfigChanged(String config) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.c0(config, (QQAppInterface) c16);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void onMergeFeedsConfigChanged(String config) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.d0(config, (QQAppInterface) c16);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void onShareToNewsConfigChanged(String config) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.e0(config, (QQAppInterface) c16);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void onSynchronizeToQzoneConfigChanged(String config) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.f0(config, (QQAppInterface) c16);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void reportArticleByWeb(int source, long sourceArticleId, int operation, int opsource) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.g0((QQAppInterface) c16, source, sourceArticleId, operation, opsource);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void sendSsoCmdRequest(String cmd, byte[] param, Map<Object, ? extends Object> extra, l52.b callback) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        a.a().e(cmd, param, extra, callback);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void setKanDianReportTTSwitch(boolean reportSwitch) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.h0((QQAppInterface) c16, reportSwitch);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void setLastScanTTDate(String date) {
        ReadInJoyHelper.i0(b.c(), date);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void setUserConfigVersion(int value) {
        BaseApplication app;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        QQAppInterface qQAppInterface = (QQAppInterface) b.c();
        if (qQAppInterface == null || (app = qQAppInterface.getApp()) == null || (sharedPreferences = app.getSharedPreferences(IReadInJoyHelper.HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION, 4)) == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        SharedPreferences.Editor putInt = edit.putInt(IReadInJoyHelper.HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION + qQAppInterface.getCurrentAccountUin(), value);
        if (putInt != null) {
            putInt.apply();
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void ssoForward(String service, String method, byte[] param, Map<Object, ? extends Object> extra, String refer, l52.a callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        n52.a.a().f(service, method, param, extra, refer, callback);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void synSwitchCache() {
        ReadInJoyHelper.j0();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean updateArkChannelConfig(String config) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return ReadInJoyHelper.l0((QQAppInterface) c16, config);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateCUKingCardDlgSwitch(int value) {
        ReadInJoyHelper.m0(b.c(), value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateFreeTimeRefreshPush(boolean can) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.n0((QQAppInterface) c16, can);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateGallerySubChannelHidden(String value) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.o0((QQAppInterface) c16, value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateGallerySubChannelWaterFallHidden(String value) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.p0((QQAppInterface) c16, value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateInnerVideoInfoShowSwitcher(boolean show) {
        ReadInJoyHelper.r0(b.c(), show);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateKandianConfigDefaultBitRate(String bitRateStr) {
        ReadInJoyHelper.s0(b.c(), bitRateStr);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateKandianConfigRedShowNum(int num) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.t0((QQAppInterface) c16, num);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateKandianConfigRedThreshold(int num) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.u0((QQAppInterface) c16, num);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public boolean updateKandianMyTabPage(String value) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return ReadInJoyHelper.v0((QQAppInterface) c16, value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateKandianVideoSocialSwitch(boolean value) {
        ReadInJoyHelper.w0(b.c(), value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateOpenSimpleSwitchFm(boolean show) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.y0((QQAppInterface) c16, show);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateRIJVideoEnableReprint(boolean enableReprint) {
        ReadInJoyHelper.z0(b.c(), enableReprint);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateReadInJoyFeedsGroupSetting(String setting) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.A0((QQAppInterface) c16, setting);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateReadInJoyIndividualPushSwitchSetting(boolean flag) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.B0((QQAppInterface) c16, flag);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateReadInJoyMultiVideoChannelInfo(int channelID, String channelName, int channelType) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.C0((QQAppInterface) c16, channelID, channelName, channelType);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateReadInJoyPushMsgSwitch(String setting) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.D0((QQAppInterface) c16, setting);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateReadInJoySmartCropSetting(String setting) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.E0((QQAppInterface) c16, setting);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public <T> void updateReadInJoySpValue(String key, T value) {
        c.e(key, value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateReadInJoyVideoJumpDefaultValue(int value) {
        ReadInJoyHelper.F0(b.c(), value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateReadinjoyFolderMergerConfig(String setting) {
        Intrinsics.checkNotNullParameter(setting, "setting");
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.G0(setting, (QQAppInterface) c16);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateReadinjoyFolderMergerReal() {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.H0((QQAppInterface) c16);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateReadinjoyStopFunctionSwtichReal() {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.I0((QQAppInterface) c16);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateReadinjoySubscribeListPush(boolean enable) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.J0((QQAppInterface) c16, enable);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateSelfFragmentFeedBackConf(String key, String value) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.K0((QQAppInterface) c16, key, value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateShowRecommendReasonInTitle(boolean show) {
        ReadInJoyHelper.L0(b.c(), show);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateSocialFeedsWebJumpUrl(String key, String value) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.M0((QQAppInterface) c16, key, value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateSplashDebugSwitcher(boolean show) {
        ReadInJoyHelper.N0(b.c(), show);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateSupportMultiVideoSwitch(boolean enable) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.O0((QQAppInterface) c16, enable);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateVideoChannelAutoPlaySwitchDefaultValue(int value) {
        ReadInJoyHelper.P0(b.c(), value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateVideoChannelAutoPlaySwitchDefaultValueVideoFlow(int value) {
        ReadInJoyHelper.Q0(b.c(), value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateVideoChannelCoverStyle(int num) {
        ReadInJoyHelper.R0(b.c(), num);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateVideoChannelFeedsClickSwitchValue(int value) {
        ReadInJoyHelper.S0(b.c(), value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateVideoColumnEntrySwitcher(boolean isTest) {
        ReadInJoyHelper.T0(b.c(), isTest);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateVideoDynamicRecommendDurationPercent(float num) {
        ReadInJoyHelper.U0(b.c(), num);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateVideoDynamicRecommendOperator(int num) {
        ReadInJoyHelper.V0(b.c(), num);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateVideoDynamicRecommmendDurationLimit(int num) {
        ReadInJoyHelper.W0(b.c(), num);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateVideoDynamicRecommmendStrategy(int num) {
        ReadInJoyHelper.X0(b.c(), num);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateVideoMessageBoxSwitcher(boolean isTest) {
        ReadInJoyHelper.Y0(b.c(), isTest);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateVideoRealTimeLogDebug() {
        ReadInJoyHelper.Z0();
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateVideoStructMsgPlaySwitch(boolean value) {
        AppRuntime c16 = b.c();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReadInJoyHelper.a1((QQAppInterface) c16, value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateViolaDebugSwitcher(boolean show) {
        ReadInJoyHelper.b1(b.c(), show);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateViolaDiscoverConfig(int value) {
        ReadInJoyHelper.c1(b.c(), value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateViolaDynamicConfig(int value) {
        ReadInJoyHelper.d1(b.c(), value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateViolaJsDebugBundleSwitcher(boolean show) {
        ReadInJoyHelper.e1(b.c(), show);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateViolaJsLocalBundleSwitcher(boolean show) {
        ReadInJoyHelper.f1(b.c(), show);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateViolaMessageBoxConfig(int value) {
        ReadInJoyHelper.g1(b.c(), value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateViolaRecommendSwitcher(boolean show) {
        ReadInJoyHelper.h1(b.c(), show);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateViolaWeishiAdConfig(int value) {
        ReadInJoyHelper.i1(b.c(), value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateWebRenderConfig(int value) {
        ReadInJoyHelper.j1(b.c(), value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateWebRenderModeConfig(int value) {
        ReadInJoyHelper.k1(b.c(), value);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void applySharedPreferences(SharedPreferences.Editor editor, boolean applyFirst) {
        c.a(editor, true);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public <T> T getReadInJoySpValue(String key, T defaultValue, boolean isAccountRelated) {
        return (T) c.d(key, defaultValue, isAccountRelated);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void ssoForward(String service, String method, byte[] param, int serializationType, Map<Object, ? extends Object> extra, l52.a callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        n52.a.a().e(service, method, param, serializationType, extra, null, callback, false);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public <T> void updateReadInJoySpValue(String key, T value, boolean isAccountRelated) {
        c.f(key, value, isAccountRelated);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateSupportMultiVideoSwitch(int enableSw) {
        QQAppInterface qQAppInterface = (QQAppInterface) b.c();
        if (qQAppInterface != null) {
            SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 4).edit();
            Intrinsics.checkNotNullExpressionValue(edit, "appInterface.app.getShar\u2026ODE_MULTI_PROCESS).edit()");
            edit.putInt(IReadInJoyHelper.HOT_SHORTVIDEO_MULTI_VIDEO_SWITCH_799, enableSw);
            edit.apply();
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void initAladdin() {
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void maybeInitializedAladdin() {
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void adSuperMaskServiceSetChannelId(int channelID) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
    public void updateProteusOfflineBid(String bidKey, String bid) {
    }
}
