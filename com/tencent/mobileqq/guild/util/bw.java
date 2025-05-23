package com.tencent.mobileqq.guild.util;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ark.ark;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.guild.data.ark.ArkHeightCache;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.state.data.SquareJSConst;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0003\b\u0083\u0001\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u00d8\u0001\u0010\u00d9\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\nH\u0007J\b\u0010\u000f\u001a\u00020\nH\u0007J\u0016\u0010\u0013\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0007J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0007J\b\u0010\u0015\u001a\u00020\u0004H\u0007J \u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0007J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0007J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001dH\u0007J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0011H\u0007J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001dH\u0007J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0011H\u0007J\b\u0010$\u001a\u00020\u0004H\u0007J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0011H\u0007J\b\u0010'\u001a\u00020\u0004H\u0007J\b\u0010(\u001a\u00020\u0006H\u0007J\b\u0010)\u001a\u00020\u0004H\u0007J\b\u0010*\u001a\u00020\u0006H\u0007J\b\u0010+\u001a\u00020\u0006H\u0007J\b\u0010,\u001a\u00020\u0004H\u0007J\b\u0010-\u001a\u00020\u0006H\u0007J\b\u0010.\u001a\u00020\u0004H\u0007J\b\u0010/\u001a\u00020\u0006H\u0007J\b\u00100\u001a\u00020\u0004H\u0007J\b\u00101\u001a\u00020\nH\u0007J\u0010\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020\nH\u0007J\b\u00104\u001a\u00020\u0006H\u0007J\u0010\u00105\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0006H\u0007J\u0010\u00107\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0011H\u0007J\u0018\u00109\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00112\u0006\u00108\u001a\u00020\nH\u0007J\u0010\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\nH\u0007J\u0010\u0010<\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\nH\u0007J\b\u0010=\u001a\u00020\nH\u0007J\u0010\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\nH\u0007J\u0018\u0010A\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010@\u001a\u00020\u0011H\u0007J\u0012\u0010B\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J\u0010\u0010D\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0011H\u0007J\b\u0010E\u001a\u00020\u0011H\u0007J\u0010\u0010G\u001a\u00020\u00112\u0006\u0010F\u001a\u00020\u0011H\u0007J\u0010\u0010H\u001a\u00020\u00112\u0006\u0010F\u001a\u00020\u0011H\u0007J\u0018\u0010I\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010F\u001a\u00020\u0011H\u0007J(\u0010M\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010K\u001a\u00020\u00112\u0006\u0010L\u001a\u00020\u0011H\u0007J(\u0010N\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010K\u001a\u00020\u00112\u0006\u0010L\u001a\u00020\u0011H\u0007J \u0010Q\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010P\u001a\u00020OH\u0007J\u001a\u0010R\u001a\u0004\u0018\u00010O2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J\b\u0010S\u001a\u00020\u0006H\u0007J\b\u0010T\u001a\u00020\u0004H\u0007J\b\u0010U\u001a\u00020\u0006H\u0007J\b\u0010V\u001a\u00020\u0004H\u0007J\u0016\u0010Y\u001a\u00020\u00042\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\n0WH\u0007J\u000e\u0010Z\u001a\b\u0012\u0004\u0012\u00020\n0WH\u0007J\u0010\u0010[\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\nH\u0007J\b\u0010\\\u001a\u00020\nH\u0007J\u0010\u0010^\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u001dH\u0007J\u0018\u0010_\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J\b\u0010`\u001a\u00020\u0006H\u0007J\u0010\u0010b\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u0006H\u0007J\b\u0010c\u001a\u00020\u0006H\u0007J\u0010\u0010e\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u0006H\u0007J\b\u0010f\u001a\u00020\u0006H\u0007J\b\u0010g\u001a\u00020\u0004H\u0007J\b\u0010h\u001a\u00020\u0006H\u0007J\u0016\u0010j\u001a\u00020\u00042\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0007J\u000e\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0007J\u0012\u0010l\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0007J\u0018\u0010m\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0007J\u0012\u0010n\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0007J\u0018\u0010o\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0007J\b\u0010p\u001a\u00020\u001dH\u0007J\u0012\u0010q\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0007J\u0018\u0010s\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010r\u001a\u00020\u0011H\u0007J\u0010\u0010t\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0007J\u0010\u0010v\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0011H\u0007J\b\u0010w\u001a\u00020\u0011H\u0007J\b\u0010x\u001a\u00020\u0006H\u0007J\u0010\u0010y\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\nH\u0007J\b\u0010z\u001a\u00020\nH\u0007J\u0010\u0010|\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u0011H\u0007J\b\u0010}\u001a\u00020\u0011H\u0007J\u0010\u0010\u007f\u001a\u00020\u00042\u0006\u0010~\u001a\u00020\u0011H\u0007J\t\u0010\u0080\u0001\u001a\u00020\u0011H\u0007J\u0011\u0010\u0081\u0001\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\nH\u0007J\t\u0010\u0082\u0001\u001a\u00020\nH\u0007J\u0011\u0010\u0083\u0001\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u0011H\u0007J\t\u0010\u0084\u0001\u001a\u00020\u0011H\u0007J\u0012\u0010\u0086\u0001\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020\u0011H\u0007J\t\u0010\u0087\u0001\u001a\u00020\u0011H\u0007J\u0011\u0010\u0088\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J\u0011\u0010\u0089\u0001\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J\u0011\u0010\u008a\u0001\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0011H\u0007J\u0019\u0010\u008b\u0001\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001dH\u0007J\t\u0010\u008c\u0001\u001a\u00020\u0006H\u0007J\t\u0010\u008d\u0001\u001a\u00020\u0004H\u0007J\t\u0010\u008e\u0001\u001a\u00020\u0004H\u0007J\t\u0010\u008f\u0001\u001a\u00020\u0006H\u0007J\t\u0010\u0090\u0001\u001a\u00020\u0004H\u0007J\u0012\u0010\u0092\u0001\u001a\u00020\u00042\u0007\u0010\u0091\u0001\u001a\u00020\u0006H\u0007J\t\u0010\u0093\u0001\u001a\u00020\u0006H\u0007J\u0010\u0010\u0095\u0001\u001a\u00020\u00042\u0007\u0010\u0094\u0001\u001a\u00020\u0006J\u0007\u0010\u0096\u0001\u001a\u00020\u0006J\u0010\u0010\u0098\u0001\u001a\u00020\u00042\u0007\u0010\u0097\u0001\u001a\u00020\u0006J\u0007\u0010\u0099\u0001\u001a\u00020\u0006J\u0010\u0010\u009a\u0001\u001a\u00020\u00042\u0007\u0010\u0097\u0001\u001a\u00020\u0006J\u0007\u0010\u009b\u0001\u001a\u00020\u0006J\u0010\u0010\u009c\u0001\u001a\u00020\u00042\u0007\u0010\u0097\u0001\u001a\u00020\u0006J\u0007\u0010\u009d\u0001\u001a\u00020\u0006J\u0007\u0010\u009e\u0001\u001a\u00020\u0006J\u0010\u0010\u00a0\u0001\u001a\u00020\u00042\u0007\u0010\u009f\u0001\u001a\u00020\u0006J\u0018\u0010\u00a2\u0001\u001a\u00020\u00112\u0006\u0010F\u001a\u00020\u00112\u0007\u0010\u00a1\u0001\u001a\u00020\u0011J\u0018\u0010\u00a3\u0001\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00112\u0007\u0010\u0094\u0001\u001a\u00020\u0011J\t\u0010\u00a4\u0001\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u00a6\u0001\u001a\u00020\u00042\u0007\u0010\u00a5\u0001\u001a\u00020\u0011J\u0007\u0010\u00a7\u0001\u001a\u00020\nJ\u0010\u0010\u00a9\u0001\u001a\u00020\u00042\u0007\u0010\u00a8\u0001\u001a\u00020\nJ\u0007\u0010\u00aa\u0001\u001a\u00020\nJ\u001d\u0010\u00ac\u0001\u001a\u00020\u00042\u000b\b\u0002\u0010\u00ab\u0001\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0006\b\u00ac\u0001\u0010\u00ad\u0001J\u0007\u0010\u00ae\u0001\u001a\u00020\nJ\u0007\u0010\u00af\u0001\u001a\u00020\u001dJ\u0010\u0010\u00b0\u0001\u001a\u00020\u00042\u0007\u0010\u00ab\u0001\u001a\u00020\u001dJ\u0010\u0010\u00b2\u0001\u001a\u00020\u00042\u0007\u0010\u00b1\u0001\u001a\u00020\nJ\u0007\u0010\u00b3\u0001\u001a\u00020\nJ\u001d\u0010\u00b4\u0001\u001a\u00020\u00042\u000b\b\u0002\u0010\u00ab\u0001\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0006\b\u00b4\u0001\u0010\u00ad\u0001J\u0007\u0010\u00b5\u0001\u001a\u00020\nJ\u0010\u0010\u00b6\u0001\u001a\u00020\u00042\u0007\u0010\u00ab\u0001\u001a\u00020\nJ\u0007\u0010\u00b7\u0001\u001a\u00020\nJ\u0010\u0010\u00b8\u0001\u001a\u00020\u00042\u0007\u0010\u00ab\u0001\u001a\u00020\nJ\u0007\u0010\u00b9\u0001\u001a\u00020\nJ\u0010\u0010\u00ba\u0001\u001a\u00020\u00042\u0007\u0010\u00b1\u0001\u001a\u00020\nJ\u0010\u0010\u00bc\u0001\u001a\u00020\u00042\u0007\u0010\u00bb\u0001\u001a\u00020\nJ\u0007\u0010\u00bd\u0001\u001a\u00020\nJ\u0018\u0010\u00be\u0001\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00112\u0007\u0010\u0094\u0001\u001a\u00020\u0006J\u000f\u0010\u00bf\u0001\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u0011J\u0018\u0010\u00c0\u0001\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00112\u0007\u0010\u0094\u0001\u001a\u00020\u001dJ\u000f\u0010\u00c1\u0001\u001a\u00020\u001d2\u0006\u0010F\u001a\u00020\u0011J\u0010\u0010\u00c3\u0001\u001a\u00020\u00042\u0007\u0010\u00c2\u0001\u001a\u00020\u0011J\u0007\u0010\u00c4\u0001\u001a\u00020\u0011J\u0018\u0010\u00c6\u0001\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00112\u0007\u0010\u00c5\u0001\u001a\u00020\u0006J\u000f\u0010\u00c7\u0001\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0011J\u000f\u0010\u00c8\u0001\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u0006J\u0007\u0010\u00c9\u0001\u001a\u00020\u0006J\u0007\u0010\u00ca\u0001\u001a\u00020\u0006J\u0010\u0010\u00cc\u0001\u001a\u00020\u00042\u0007\u0010\u00cb\u0001\u001a\u00020\u0006J\u0010\u0010\u00ce\u0001\u001a\u00020\u00042\u0007\u0010\u00cd\u0001\u001a\u00020\u0011J\u0007\u0010\u00cf\u0001\u001a\u00020\u0011J\u0010\u0010\u00d1\u0001\u001a\u00020\u00042\u0007\u0010\u00d0\u0001\u001a\u00020\u0006J\u0007\u0010\u00d2\u0001\u001a\u00020\u0006J\u0010\u0010\u00d4\u0001\u001a\u00020\u00062\u0007\u0010\u00d3\u0001\u001a\u00020\u0011J\u0010\u0010\u00d5\u0001\u001a\u00020\u00042\u0007\u0010\u00d3\u0001\u001a\u00020\u0011R\u0019\u0010\u00d7\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u00d6\u0001\u00a8\u0006\u00da\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/util/bw;", "", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "L", "", "S1", "", "e0", "A0", "a", "", "f0", "B0", "version", "T1", "g0", "", "", "keys", "l1", "E", "F1", "guildId", "channelId", QQPermissionConstants.Permission.AUIDO_GROUP, "N0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "P0", DomainData.DOMAIN_NAME, "", "time", "Q0", "o", "uin", "T0", "p", "i1", "bannerId", "p0", "R0", "r0", "S0", "s0", "x0", "P1", "v0", "H1", "w0", "O1", "k", "mode", "L0", "n0", "j1", "userId", "k0", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "Y1", "dateVersion", "j0", "X1", "h0", "captureVolume", "U1", "shareInfo", "z1", ExifInterface.LATITUDE_SOUTH, "authType", "w1", "P", "key", "b2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "m0", "tinyId", "tittle", "bubbleText", "l0", "Z1", "Lcom/tencent/mobileqq/guild/data/ark/ArkHeightCache;", "cache", "I0", "g", "f", "H0", "e", "G0", "", "data", "F0", "d", "X0", "t", "nextShowTime", "V1", "E1", "X", "hasClosed", "I1", "Y", "hasShow", "J1", "o0", "W1", "W", "set", Constants.BASE_IN_PLUGIN_ID, "V", "j", "K0", "i", "J0", BdhLogUtil.LogTag.Tag_Conn, tl.h.F, SquareJSConst.Params.PARAMS_NUMS, "C0", "h1", "appId", "K1", "Z", "d0", "Z0", "v", "url", "Y0", "u", "guildCoverInfoListJson", ICustomDataEditor.STRING_ARRAY_PARAM_1, "w", "e1", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "d1", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ark.ARKMETADATA_JSON, "c1", "y", "O0", "q0", "B", "f1", HippyTKDListViewAdapter.X, "b1", "g1", "t0", "b", "openDelay", Constants.APK_CERTIFICATE, "u0", "value", "W0", ReportConstant.COSTREPORT_PREFIX, "show", "v1", "O", "x1", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "y1", BdhLogUtil.LogTag.Tag_Req, "l", "needRedDot", "M0", RemoteHandleConst.PARAM_DEFAULT_VALUE, "i0", "D0", "r", "str", "V0", "M", "pageType", "t1", "H", Element.ELEMENT_NAME_TIMES, "o1", "(Ljava/lang/Integer;)V", UserInfo.SEX_FEMALE, "G", ICustomDataEditor.NUMBER_PARAM_1, "dataVersion", "m1", "U", "B1", "N", "u1", "K", ICustomDataEditor.STRING_PARAM_1, "T", "A1", "selType", "r1", "J", "M1", "b0", "N1", "c0", "selId", "q1", "I", "hasShowed", "k1", "D", "U0", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "y0", "state", "Q1", "type", "E0", "c", "needShow", "L1", "a0", "scene", "z0", "R1", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class bw {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bw f235485a = new bw();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static MMKVOptionEntity entity;

    static {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD)");
        entity = from;
    }

    bw() {
    }

    @JvmStatic
    public static final int A() {
        return entity.decodeInt(b2("MMKV_KEY_GUILD_ONEPLAY_CONFIG_VERSION"), 0);
    }

    @JvmStatic
    public static final void A0() {
        L().encodeBool(b2("MMKV_KEY_TROOP_JOIN_GUILD"), false);
    }

    @JvmStatic
    public static final long B(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return L().decodeLong("key_guild_speak_manage_guide_last_time_" + uin, 0L);
    }

    @JvmStatic
    public static final void B0() {
        L().encodeInt(b2("MMKV_KEY_TROOP_JOIN_GUILD_TIMES"), 0);
    }

    @JvmStatic
    public static final long C() {
        return L().decodeLong("key_guild_user_online_time", 0L);
    }

    @JvmStatic
    public static final void C0(@NotNull String guildId, @NotNull String nums) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(nums, "nums");
        L().encodeString(b2("key_guild_at_remain_num" + guildId), nums);
    }

    public static /* synthetic */ void C1(bw bwVar, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        bwVar.B1(num);
    }

    @JvmStatic
    public static final void D1(@NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "set");
        L().encodeStringSet(b2("MMKV_KEY_NEW_USER_ACTIVE_CHANNEL_LIST"), set);
    }

    @JvmStatic
    @NotNull
    public static final Set<String> E() {
        Set<String> decodeStringSet = entity.decodeStringSet(b2("MMKV_KEY_INBOX_INVISIBLE_OFFICIAL_KEYS"), new HashSet());
        Intrinsics.checkNotNullExpressionValue(decodeStringSet, "entity.decodeStringSet(u\u2026FFICIAL_KEYS), HashSet())");
        return decodeStringSet;
    }

    @JvmStatic
    public static final void E1(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        L().encodeBool(b2("MMKV_KEY_NEW_USER_STAY_OR_WRITE_IN_CHANNEL" + guildId + channelId), true);
    }

    @JvmStatic
    public static final void F0(@NotNull List<Integer> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!data.isEmpty() && data.size() == 2) {
            L().encodeInt(b2("MMKV_KEY_AIO_BUBBLE_WIDTH_1"), data.get(0).intValue());
            L().encodeInt(b2("MMKV_KEY_AIO_BUBBLE_WIDTH_2"), data.get(1).intValue());
        }
    }

    @JvmStatic
    public static final void F1() {
        L().encodeBool(a2("MMKV_KEY_NEW_VERSION_GUIDE_HAS_SHOW"), true);
    }

    @JvmStatic
    public static final void G0() {
        L().encodeBool(b2("key_aio_guild_tab_daka_popup_showed"), true);
    }

    @JvmStatic
    public static final void G1(boolean openDelay) {
        L().encodeBool(b2("MMKV_KEY_GPRO_DELAY_INIT"), openDelay);
    }

    @JvmStatic
    public static final void H0() {
        L().encodeBool(b2("key_aio_guild_tab_popup_showed"), true);
    }

    @JvmStatic
    public static final void H1() {
        entity.encodeBool(b2("KEY_IS_PLUS_BTN_ROBOT_DOT_HAS_SHOW"), true);
    }

    @JvmStatic
    public static final void I0(@NotNull String guildId, @NotNull String channelId, @NotNull ArkHeightCache cache) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(cache, "cache");
        L().encodeParcelable(b2("MMKV_KEY_ARK_HEIGHT" + guildId + channelId), cache);
    }

    @JvmStatic
    public static final void I1(boolean hasClosed) {
        L().encodeBool(b2("MMKV_KEY_RECENT_CHANNEL_GUIDE_ANIMATION_CLOSED"), hasClosed);
    }

    @JvmStatic
    public static final void J0(@NotNull String guildId, @NotNull String record) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(record, "record");
        L().encodeString(b2("key_at_robot_recent_record" + guildId), record);
    }

    @JvmStatic
    public static final void J1(boolean hasShow) {
        L().encodeBool(b2("MMKV_KEY_RECENT_CHANNEL_GUIDE_ANIMATION_SHOWED"), hasShow);
    }

    @JvmStatic
    public static final void K0(@NotNull String guildId, @NotNull String record) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(record, "record");
        L().encodeString(b2("key_at_role_recent_record" + guildId), record);
    }

    @JvmStatic
    public static final void K1(@NotNull String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        L().encodeString("key_guild_media_recent_third_app_id", appId);
    }

    @JvmStatic
    @NotNull
    public static final MMKVOptionEntity L() {
        return entity;
    }

    @JvmStatic
    public static final void L0(int mode) {
        L().encodeInt(b2("MMKV_KEY_AUDIO_CHANNEL_MODE"), mode);
    }

    @JvmStatic
    public static final void N0(@NotNull String guildId, @NotNull String channelId, @NotNull String record) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(record, "record");
        L().encodeString(b2("MMKV_KEY_CHANNEL_OPENS_RECORD" + guildId + channelId), record);
    }

    @JvmStatic
    public static final void O0(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Set<String> decodeStringSet = entity.decodeStringSet(b2("MMKV_KEY_SHOWED_BLOCK_ADS_TIPS_CHANNEL"), new LinkedHashSet());
        if (!decodeStringSet.contains(channelId)) {
            decodeStringSet.add(channelId);
            entity.encodeStringSet(b2("MMKV_KEY_SHOWED_BLOCK_ADS_TIPS_CHANNEL"), decodeStringSet);
        }
    }

    @JvmStatic
    public static final void O1() {
        entity.encodeBool(b2("MMKV_KEY_ROBOT_SLASH_PANEL_HAS_USED"), true);
    }

    @JvmStatic
    @NotNull
    public static final String P() {
        String decodeString = entity.decodeString(b2("MMKV_KEY_MEDIA_GAME_AUTH"), "AUTH_ONLY_ONCE");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(uinK\u2026ME_AUTH), AUTH_ONLY_ONCE)");
        return decodeString;
    }

    @JvmStatic
    public static final void P0(@NotNull String guildId, @NotNull String channelId, @NotNull String record) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(record, "record");
        L().encodeString(b2("MMKV_KEY_CHANNEL_SPEAKING_RECORD" + guildId + channelId), record);
    }

    @JvmStatic
    public static final void P1() {
        entity.encodeBool(b2("KEY_IS_ROBOT_SLASH_RED_DOT_HAS_SHOW"), true);
    }

    @JvmStatic
    public static final void Q0(@NotNull String guildId, long time) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        L().encodeLong(b2("MMKV_KEY_CHANNEL_SUBSCRIBE_GRAY_SHOW_TIME" + guildId), time);
    }

    @JvmStatic
    public static final void R0() {
        entity.encodeBool(b2("MMKV_KEY_CHANNEL_SUBSCRIBE_NOT_CONFIRM"), true);
    }

    @JvmStatic
    @Nullable
    public static final String S(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return L().decodeString(b2("SP_KEY_MINI_APP_CHANNEL_SHARE_INFO" + channelId), "null");
    }

    @JvmStatic
    public static final void S0() {
        entity.encodeBool(b2("MMKV_KEY_CHANNEL_SUBSCRIBE_RED_DOT_HAS_SHOW"), true);
    }

    @JvmStatic
    public static final void S1() {
        L().encodeBool(b2("MMKV_KEY_TROOP_JOIN_GUILD"), true);
    }

    @JvmStatic
    public static final void T0(@NotNull String uin, long time) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        L().encodeLong(b2("MMKV_KEY_CHANNEL_SUBSCRIBE_GUIDE_SHOW_TIME" + uin), time);
    }

    @JvmStatic
    public static final void T1(int version) {
        L().encodeInt(b2("MMKV_KEY_TROOP_JOIN_GUILD_VERSION"), version);
    }

    @JvmStatic
    public static final void U1(int captureVolume) {
        L().encodeInt("AUDIO_CAPTURE_VOLUME", captureVolume);
    }

    @JvmStatic
    @NotNull
    public static final Set<String> V() {
        Set<String> emptySet;
        MMKVOptionEntity L = L();
        String b26 = b2("MMKV_KEY_NEW_USER_ACTIVE_CHANNEL_LIST");
        emptySet = SetsKt__SetsKt.emptySet();
        Set<String> decodeStringSet = L.decodeStringSet(b26, emptySet);
        Intrinsics.checkNotNullExpressionValue(decodeStringSet, "getMMKVEntity().decodeSt\u2026_LIST), setOf()\n        )");
        return decodeStringSet;
    }

    @JvmStatic
    public static final void V1(long nextShowTime) {
        L().encodeLong(b2("subscribe_channel_guide_next_show_time"), nextShowTime);
    }

    @JvmStatic
    public static final boolean W() {
        return L().decodeBool(b2("MMKV_KEY_NEW_USER_MSG_NOTICE_DIALOG_HAS_SHOW"), false);
    }

    @JvmStatic
    public static final void W1() {
        L().encodeBool(a2("has_subscribed_channel_ever"), true);
    }

    @JvmStatic
    public static final boolean X() {
        return L().decodeBool(b2("MMKV_KEY_RECENT_CHANNEL_GUIDE_ANIMATION_CLOSED"), false);
    }

    @JvmStatic
    public static final void X0(int data) {
        L().encodeInt(b2("MMKV_KEY_FEED_DETAIL_WIDTH"), data);
    }

    @JvmStatic
    public static final void X1(int dateVersion) {
        L().encodeInt(b2("key_guild_media_update_tips_data_version"), dateVersion);
    }

    @JvmStatic
    public static final boolean Y() {
        return L().decodeBool(b2("MMKV_KEY_RECENT_CHANNEL_GUIDE_ANIMATION_SHOWED"), false);
    }

    @JvmStatic
    public static final void Y0(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        L().encodeString(b2("MMKV_KEY_GUILD_COVER_CONFIG_URL"), url);
    }

    @JvmStatic
    public static final void Y1(@NotNull String userId, int volume) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        L().encodeInt(b2(userId), volume);
    }

    @JvmStatic
    @NotNull
    public static final String Z() {
        String decodeString = L().decodeString("key_guild_media_recent_third_app_id", "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "getMMKVEntity().decodeSt\u2026_APP_ID,\n        \"\"\n    )");
        return decodeString;
    }

    @JvmStatic
    public static final void Z0(int version) {
        L().encodeInt(b2("MMKV_KEY_GUILD_COVER_CONFIG_VERSION"), version);
    }

    @JvmStatic
    public static final void Z1(@NotNull String tinyId, @NotNull String guildId, @NotNull String tittle, @NotNull String bubbleText) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tittle, "tittle");
        Intrinsics.checkNotNullParameter(bubbleText, "bubbleText");
        String str = "MMKV_KEY_SHOW_BUBBLE" + tinyId + guildId + tittle + bubbleText;
        if (!l0(tinyId, guildId, tittle, bubbleText)) {
            L().encodeBool(str, true);
            QLog.i("QQGuildMMKVUtils", 1, "set success, key: " + str);
        }
    }

    @JvmStatic
    public static final void a() {
        L().encodeInt(b2("MMKV_KEY_TROOP_JOIN_GUILD_TIMES"), f0() + 1);
    }

    @JvmStatic
    public static final void a1(@NotNull String guildCoverInfoListJson) {
        Intrinsics.checkNotNullParameter(guildCoverInfoListJson, "guildCoverInfoListJson");
        L().encodeString(b2("MMKV_KEY_GUILD_COVER_LIST"), guildCoverInfoListJson);
    }

    @JvmStatic
    @NotNull
    public static final String a2(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String g16 = ch.g();
        Intrinsics.checkNotNullExpressionValue(g16, "accountUin()");
        return key + "_" + AppSetting.f99551k + "_" + g16;
    }

    @JvmStatic
    public static final void b() {
        L().clearAll();
    }

    @JvmStatic
    public static final void b1() {
        L().encodeBool(b2("key_guild_has_show_create_section_guide"), true);
    }

    @JvmStatic
    @NotNull
    public static final String b2(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String g16 = ch.g();
        Intrinsics.checkNotNullExpressionValue(g16, "accountUin()");
        return key + "_" + g16;
    }

    @JvmStatic
    public static final void c1(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        L().encodeString(b2("MMKV_KEY_GUILD_ONEPLAY_CONFIG_JSON"), json);
    }

    @JvmStatic
    @NotNull
    public static final List<Integer> d() {
        ArrayList arrayList = new ArrayList();
        int decodeInt = L().decodeInt(b2("MMKV_KEY_AIO_BUBBLE_WIDTH_1"), 0);
        int decodeInt2 = L().decodeInt(b2("MMKV_KEY_AIO_BUBBLE_WIDTH_2"), 0);
        if (decodeInt > 0) {
            arrayList.add(Integer.valueOf(decodeInt));
        }
        if (decodeInt2 > 0) {
            arrayList.add(Integer.valueOf(decodeInt2));
        }
        return arrayList;
    }

    @JvmStatic
    public static final boolean d0() {
        return L().decodeBool(b2("MMKV_KEY_MIND_GUILD_SHOW_SETTING_RED_DOT"), false);
    }

    @JvmStatic
    public static final void d1(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        L().encodeString(b2("MMKV_KEY_GUILD_ONEPLAY_CONFIG_URL"), url);
    }

    @JvmStatic
    public static final boolean e() {
        return L().decodeBool(b2("key_aio_guild_tab_daka_popup_showed"), false);
    }

    @JvmStatic
    public static final boolean e0() {
        return L().decodeBool(b2("MMKV_KEY_TROOP_JOIN_GUILD"), false);
    }

    @JvmStatic
    public static final void e1(int version) {
        L().encodeInt(b2("MMKV_KEY_GUILD_ONEPLAY_CONFIG_VERSION"), version);
    }

    @JvmStatic
    public static final boolean f() {
        return L().decodeBool(b2("key_aio_guild_tab_popup_showed"), false);
    }

    @JvmStatic
    public static final int f0() {
        return L().decodeInt(b2("MMKV_KEY_TROOP_JOIN_GUILD_TIMES"), 0);
    }

    @JvmStatic
    public static final void f1(@NotNull String uin, long time) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        L().encodeLong("key_guild_speak_manage_guide_last_time_" + uin, time);
    }

    @JvmStatic
    @Nullable
    public static final ArkHeightCache g(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return (ArkHeightCache) L().decodeParcelable(b2("MMKV_KEY_ARK_HEIGHT" + guildId + channelId), ArkHeightCache.class, null);
    }

    @JvmStatic
    public static final int g0() {
        return entity.decodeInt(b2("MMKV_KEY_TROOP_JOIN_GUILD_VERSION"), 0);
    }

    @JvmStatic
    public static final void g1() {
        L().encodeBool(a2("KEY_GUILD_SUMMON_NEW_GUIDE"), true);
    }

    @JvmStatic
    @Nullable
    public static final String h(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return L().decodeString(b2("key_guild_at_remain_num" + guildId), "");
    }

    @JvmStatic
    public static final int h0() {
        return entity.decodeInt("AUDIO_CAPTURE_VOLUME", 100);
    }

    @JvmStatic
    public static final void h1(long time) {
        L().encodeLong("key_guild_user_online_time", time);
    }

    @JvmStatic
    @Nullable
    public static final String i(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return L().decodeString(b2("key_at_robot_recent_record" + guildId), "");
    }

    @JvmStatic
    public static final void i1() {
        L().encodeBool(a2("MMKV_KEY_FEED_SQUARE_GUIDE_DIALOG"), true);
    }

    @JvmStatic
    @Nullable
    public static final String j(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return L().decodeString(b2("key_at_role_recent_record" + guildId), "");
    }

    @JvmStatic
    public static final boolean j0(int dateVersion) {
        if (dateVersion == entity.decodeInt(b2("key_guild_media_update_tips_data_version"), 0)) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final void j1(boolean mode) {
        L().encodeBool(b2("MMKV_KEY_IS_OPEN_AUDIO_CHANNEL_SPEECH_MODE"), mode);
    }

    @JvmStatic
    public static final int k() {
        return entity.decodeInt(b2("MMKV_KEY_AUDIO_CHANNEL_MODE"), 0);
    }

    @JvmStatic
    public static final int k0(@NotNull String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return entity.decodeInt(b2(userId), 100);
    }

    @JvmStatic
    public static final boolean l0(@NotNull String tinyId, @NotNull String guildId, @NotNull String tittle, @NotNull String bubbleText) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tittle, "tittle");
        Intrinsics.checkNotNullParameter(bubbleText, "bubbleText");
        return L().decodeBool("MMKV_KEY_SHOW_BUBBLE" + tinyId + guildId + tittle + bubbleText, false);
    }

    @JvmStatic
    public static final void l1(@NotNull Set<String> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        entity.encodeStringSet(b2("MMKV_KEY_INBOX_INVISIBLE_OFFICIAL_KEYS"), keys);
    }

    @JvmStatic
    @Nullable
    public static final String m(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return L().decodeString(b2("MMKV_KEY_CHANNEL_OPENS_RECORD" + guildId + channelId), "null");
    }

    @JvmStatic
    @NotNull
    public static final String m0(@NotNull String guildId, @NotNull String key) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(key, "key");
        return key + "_" + guildId;
    }

    @JvmStatic
    @Nullable
    public static final String n(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return L().decodeString(b2("MMKV_KEY_CHANNEL_SPEAKING_RECORD" + guildId + channelId), "null");
    }

    @JvmStatic
    public static final boolean n0() {
        return entity.decodeBool(b2("MMKV_KEY_IS_OPEN_AUDIO_CHANNEL_SPEECH_MODE"), false);
    }

    @JvmStatic
    public static final long o(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return L().decodeLong(b2("MMKV_KEY_CHANNEL_SUBSCRIBE_GRAY_SHOW_TIME" + guildId), 0L);
    }

    @JvmStatic
    public static final boolean o0() {
        return L().decodeBool(a2("has_subscribed_channel_ever"), false);
    }

    @JvmStatic
    public static final long p(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return L().decodeLong(b2("MMKV_KEY_CHANNEL_SUBSCRIBE_GUIDE_SHOW_TIME" + uin), 0L);
    }

    @JvmStatic
    public static final boolean p0(@NotNull String guildId, @NotNull String bannerId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(bannerId, "bannerId");
        return entity.decodeBool(a2("MMKV_KEY_LOCAL_CLOSED_ANNOUNCEMENT_GUILD_ID" + guildId + bannerId), false);
    }

    public static /* synthetic */ void p1(bw bwVar, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        bwVar.o1(num);
    }

    @JvmStatic
    public static final boolean q0(@NotNull String channelId) {
        Set<String> emptySet;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        MMKVOptionEntity mMKVOptionEntity = entity;
        String b26 = b2("MMKV_KEY_SHOWED_BLOCK_ADS_TIPS_CHANNEL");
        emptySet = SetsKt__SetsKt.emptySet();
        return mMKVOptionEntity.decodeStringSet(b26, emptySet).contains(channelId);
    }

    @JvmStatic
    public static final boolean r0() {
        return entity.decodeBool(b2("MMKV_KEY_CHANNEL_SUBSCRIBE_NOT_CONFIRM"), false);
    }

    @JvmStatic
    public static final boolean s0() {
        return entity.decodeBool(b2("MMKV_KEY_CHANNEL_SUBSCRIBE_RED_DOT_HAS_SHOW"), false);
    }

    @JvmStatic
    public static final int t() {
        new ArrayList();
        return L().decodeInt(b2("MMKV_KEY_FEED_DETAIL_WIDTH"), 0);
    }

    @JvmStatic
    public static final boolean t0() {
        return entity.decodeBool(a2("KEY_GUILD_SUMMON_NEW_GUIDE"), false);
    }

    @JvmStatic
    @NotNull
    public static final String u() {
        String decodeString = entity.decodeString(b2("MMKV_KEY_GUILD_COVER_CONFIG_URL"), "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(uinK\u2026LD_COVER_CONFIG_URL), \"\")");
        return decodeString;
    }

    @JvmStatic
    public static final boolean u0() {
        return entity.decodeBool(b2("MMKV_KEY_GPRO_DELAY_INIT"), true);
    }

    @JvmStatic
    public static final int v() {
        return entity.decodeInt(b2("MMKV_KEY_GUILD_COVER_CONFIG_VERSION"), 0);
    }

    @JvmStatic
    public static final boolean v0() {
        return entity.decodeBool(b2("KEY_IS_PLUS_BTN_ROBOT_DOT_HAS_SHOW"), false);
    }

    @JvmStatic
    @NotNull
    public static final String w() {
        String decodeString = entity.decodeString(b2("MMKV_KEY_GUILD_COVER_LIST"), "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(uinK\u2026EY_GUILD_COVER_LIST), \"\")");
        return decodeString;
    }

    @JvmStatic
    public static final boolean w0() {
        return entity.decodeBool(b2("MMKV_KEY_ROBOT_SLASH_PANEL_HAS_USED"), false);
    }

    @JvmStatic
    public static final void w1(@NotNull String authType) {
        Intrinsics.checkNotNullParameter(authType, "authType");
        entity.encodeString(b2("MMKV_KEY_MEDIA_GAME_AUTH"), authType);
    }

    @JvmStatic
    public static final boolean x() {
        return L().decodeBool(b2("key_guild_has_show_create_section_guide"), false);
    }

    @JvmStatic
    public static final boolean x0() {
        return entity.decodeBool(b2("KEY_IS_ROBOT_SLASH_RED_DOT_HAS_SHOW"), false);
    }

    @JvmStatic
    @NotNull
    public static final String y() {
        String decodeString = entity.decodeString(b2("MMKV_KEY_GUILD_ONEPLAY_CONFIG_JSON"), "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(uinK\u2026ONEPLAY_CONFIG_JSON), \"\")");
        return decodeString;
    }

    @JvmStatic
    @NotNull
    public static final String z() {
        String decodeString = entity.decodeString(b2("MMKV_KEY_GUILD_ONEPLAY_CONFIG_URL"), "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(uinK\u2026_ONEPLAY_CONFIG_URL), \"\")");
        return decodeString;
    }

    @JvmStatic
    public static final void z1(@NotNull String channelId, @NotNull String shareInfo) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
        L().encodeString(b2("SP_KEY_MINI_APP_CHANNEL_SHARE_INFO" + channelId), shareInfo);
    }

    public final void A1(int dataVersion) {
        L().encodeInt("key_guild_media_nav_tips_data_version", dataVersion);
    }

    public final void B1(@Nullable Integer times) {
        if (times != null) {
            L().encodeInt("key_guild_media_nav_tips_show_times", times.intValue());
        } else {
            L().encodeInt("key_guild_media_nav_tips_show_times", L().decodeInt("key_guild_media_nav_tips_show_times", 0) + 1);
        }
    }

    public final boolean D(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return L().decodeBool(m0(guildId, b2("key_guild_is_showed_real_name_auth")), false);
    }

    public final void D0(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        entity.encodeString(key, value);
    }

    public final void E0(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        L().encodeString(b2("MMKV_KEY_AI_SEARCH_MODEL_SELECT_TYPE"), type);
    }

    public final int F() {
        return L().decodeInt("key_guild_media_invite_data_version", 0);
    }

    public final long G() {
        return L().decodeLong("key_guild_media_invite_server_mills", 0L);
    }

    public final int H() {
        return L().decodeInt("key_guild_media_invite_show_times", 0);
    }

    @NotNull
    public final String I() {
        String decodeString = L().decodeString("KEY_GUILD_LAST_SELECT_GUILD_ID", "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "getMMKVEntity().decodeSt\u2026LAST_SELECT_GUILD_ID, \"\")");
        return decodeString;
    }

    public final int J() {
        return L().decodeInt("KEY_GUILD_LAST_SELECT_GUILD_TYPE", -1);
    }

    public final int K() {
        return L().decodeInt("key_guild_live_announce_msg_tips_show_times", 0);
    }

    public final void L1(boolean needShow) {
        L().encodeBool(b2("mmkv_key_red_dot_for_little_world_author_entry"), needShow);
    }

    public final int M() {
        return L().decodeInt(b2("MMKV_KEY_MAIN_FRAME_PAGE_TYPE"), 4);
    }

    public final void M0(boolean needRedDot) {
        L().encodeBool(b2("MMKV_KEY_AUDIO_CHANNEL_NEW_MODE_RED_DOT"), needRedDot);
    }

    public final void M1(@NotNull String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        L().encodeBool(key, value);
    }

    public final int N() {
        return L().decodeInt("key_guild_media_announce_msg_tips_show_times", 0);
    }

    public final void N1(@NotNull String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        L().encodeLong(key, value);
    }

    public final boolean O() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD)");
        return from.decodeBool("MMKV_KEY_HAS_SHOW_MEDIA_AIO_GUIDE", false);
    }

    public final boolean Q() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD)");
        return from.decodeBool("MMKV_KEY_MEDIA_CHANNEL_RED_DOT_1", false);
    }

    public final void Q1(boolean state) {
        L().encodeBool(b2("MMKV_KEY_GUILD_SHORT_FEED_DRAFT_MIGRATED_TO_SDK"), state);
    }

    public final boolean R() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD)");
        return from.decodeBool("MMKV_KEY_MEDIA_CHANNEL_RED_DOT_2", false);
    }

    public final void R1(@NotNull String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        L().encodeBool(b2("MMKV_GUILD_FOLDER_GUIDE_FIRST_SHOW"), true);
    }

    public final int T() {
        return L().decodeInt("key_guild_media_nav_tips_data_version", 0);
    }

    public final int U() {
        return L().decodeInt("key_guild_media_nav_tips_show_times", 0);
    }

    public final void U0(boolean hasShow) {
        L().encodeBool(b2("MMKV_KEY_CREATE_POLICY_DIALOG_HAS_SHOW"), hasShow);
    }

    public final void V0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        L().encodeString(b2("MMKV_KEY_DISCOVER_ABTEST"), str);
    }

    public final void W0(boolean value) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD)");
        from.encodeBool("MMKV_KEY_DISCOVER_ALLOW_ASYNC_INFLATE", value);
    }

    public final boolean a0() {
        return L().decodeBool(b2("mmkv_key_red_dot_for_little_world_author_entry"), true);
    }

    public final boolean b0(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return L().decodeBool(key, false);
    }

    @NotNull
    public final String c() {
        String decodeString = L().decodeString(b2("MMKV_KEY_AI_SEARCH_MODEL_SELECT_TYPE"), "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "getMMKVEntity().decodeSt\u2026H_MODEL_SELECT_TYPE), \"\")");
        return decodeString;
    }

    public final long c0(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return L().decodeLong(key, 0L);
    }

    @NotNull
    public final String i0(@NotNull String key, @NotNull String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String decodeString = entity.decodeString(key, defaultValue);
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(key, defaultValue)");
        return decodeString;
    }

    public final void k1(@NotNull String guildId, boolean hasShowed) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        L().encodeBool(m0(guildId, b2("key_guild_is_showed_real_name_auth")), hasShowed);
    }

    public final boolean l() {
        return entity.decodeBool(b2("MMKV_KEY_AUDIO_CHANNEL_NEW_MODE_RED_DOT"), true);
    }

    public final void m1(int dataVersion) {
        L().encodeInt("key_guild_media_invite_data_version", dataVersion);
    }

    public final void n1(long times) {
        L().encodeLong("key_guild_media_invite_server_mills", times);
    }

    public final void o1(@Nullable Integer times) {
        if (times != null) {
            L().encodeInt("key_guild_media_invite_show_times", times.intValue());
        } else {
            L().encodeInt("key_guild_media_invite_show_times", L().decodeInt("key_guild_media_invite_show_times", 0) + 1);
        }
    }

    public final boolean q() {
        return L().decodeBool(b2("MMKV_KEY_CREATE_POLICY_DIALOG_HAS_SHOW"), false);
    }

    public final void q1(@NotNull String selId) {
        Intrinsics.checkNotNullParameter(selId, "selId");
        L().encodeString("KEY_GUILD_LAST_SELECT_GUILD_ID", selId);
    }

    @Nullable
    public final String r() {
        return L().decodeString(b2("MMKV_KEY_DISCOVER_ABTEST"), null);
    }

    public final void r1(int selType) {
        L().encodeInt("KEY_GUILD_LAST_SELECT_GUILD_TYPE", selType);
    }

    public final boolean s() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD)");
        return from.decodeBool("MMKV_KEY_DISCOVER_ALLOW_ASYNC_INFLATE", true);
    }

    public final void s1(int times) {
        L().encodeInt("key_guild_live_announce_msg_tips_show_times", times);
    }

    public final void t1(int pageType) {
        L().encodeInt(b2("MMKV_KEY_MAIN_FRAME_PAGE_TYPE"), pageType);
    }

    public final void u1(int times) {
        L().encodeInt("key_guild_media_announce_msg_tips_show_times", times);
    }

    public final void v1(boolean show) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD)");
        from.encodeBool("MMKV_KEY_HAS_SHOW_MEDIA_AIO_GUIDE", show);
    }

    public final void x1(boolean show) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD)");
        from.encodeBool("MMKV_KEY_MEDIA_CHANNEL_RED_DOT_1", show);
    }

    public final boolean y0() {
        return L().decodeBool(b2("MMKV_KEY_GUILD_SHORT_FEED_DRAFT_MIGRATED_TO_SDK"), false);
    }

    public final void y1(boolean show) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD)");
        from.encodeBool("MMKV_KEY_MEDIA_CHANNEL_RED_DOT_2", show);
    }

    public final boolean z0(@NotNull String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        return L().decodeBool(b2("MMKV_GUILD_FOLDER_GUIDE_FIRST_SHOW"), false);
    }
}
