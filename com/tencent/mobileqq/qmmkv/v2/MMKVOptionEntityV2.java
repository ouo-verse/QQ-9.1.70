package com.tencent.mobileqq.qmmkv.v2;

import android.content.SharedPreferences;
import android.os.Parcelable;
import com.tencent.mobileqq.qmmkv.MMKVHandlerBase;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\b\u0010P\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010R\u001a\u00020\r\u0012\u0006\u0010U\u001a\u00020T\u0012\u0006\u0010X\u001a\u00020W\u00a2\u0006\u0004\bZ\u0010[J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\"\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\u0010\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\tH\u0016J\"\u0010\u0010\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u0012\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0012\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\rH\u0016J$\u0010\u0012\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u0015\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u0015\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\rH\u0016J$\u0010\u0015\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J=\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0016*\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\b\u0010\u000f\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJE\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0016*\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\b\u0010\u000f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001bJ\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u001c\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u001d\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u001d\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0017\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001eH\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010$\u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001f\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001e2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u001f\u0010%J\u0012\u0010&\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010&\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001f\u0010(\u001a\u00020\u000b2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001eH\u0016\u00a2\u0006\u0004\b(\u0010)J'\u0010(\u001a\u00020\u000b2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001e2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b(\u0010*J\u000e\u0010+\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010+\u001a\u00020\u0005J\b\u0010-\u001a\u00020,H\u0016J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\u0010\u0010-\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0014\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010/H\u0016J\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010/2\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u00102\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u00101\u001a\u0004\u0018\u00010\u0003H\u0016J&\u00102\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u00101\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J*\u00105\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001032\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u000103H\u0016J2\u00105\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001032\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u00106\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u00101\u001a\u00020\rH\u0016J\"\u00106\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u00101\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u00107\u001a\u00020!2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u00101\u001a\u00020!H\u0016J\"\u00107\u001a\u00020!2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u00101\u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u00109\u001a\u0002082\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u00101\u001a\u000208H\u0016J\"\u00109\u001a\u0002082\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u00101\u001a\u0002082\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010:\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u00101\u001a\u00020\u0005H\u0016J\"\u0010:\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u00101\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010;\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\u001a\u0010;\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010<\u001a\u00020\u000bH\u0016J\u0012\u0010?\u001a\u00020,2\b\u0010>\u001a\u0004\u0018\u00010=H\u0016J\u0012\u0010@\u001a\u00020,2\b\u0010>\u001a\u0004\u0018\u00010=H\u0016J\u001c\u0010A\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010A\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J$\u0010A\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J$\u0010B\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010B\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\"\u0010D\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u000103H\u0016J*\u0010D\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J*\u0010D\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010E2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010F\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\rH\u0016J\"\u0010F\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010F\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010G\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020!H\u0016J\"\u0010G\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010G\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010H\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u000208H\u0016J\"\u0010H\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u0002082\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010H\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u0002082\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010I\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0016J\"\u0010I\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010I\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010J\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010J\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010K\u001a\u00020\u000bH\u0016J\u0010\u0010K\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010L\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010L\u001a\u00020\u0005H\u0016J\u0010\u0010M\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010M\u001a\u00020,H\u0016R\u0016\u0010N\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010R\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010Y\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "", "", "mmapID", "", "boundToAccount", "mmapKey", "key", "", "value", "Landroid/content/SharedPreferences$Editor;", "putDouble", "", "expireDurationInSecond", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getDouble", "", "putBytes", "getBytes", "Landroid/os/Parcelable;", "putParcelable", "T", "Ljava/lang/Class;", "tClass", "getParcelable", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;)Landroid/os/Parcelable;", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;Z)Landroid/os/Parcelable;", "getValueSize", "getValueActualSize", "", "allKeys", "()[Ljava/lang/String;", "", "count", "totalSize", "actualSize", "(Z)[Ljava/lang/String;", "removeValueForKey", "keys", "removeValuesForKeys", "([Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;", "([Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;", "close", "", "trim", "isAccessible", "", "getAll", "defValue", "getString", "", "defValues", "getStringSet", "getInt", "getLong", "", "getFloat", "getBoolean", "contains", "edit", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "listener", "registerOnSharedPreferenceChangeListener", "unregisterOnSharedPreferenceChangeListener", "putString", "putStringR", "values", "putStringSet", "", "putInt", "putLong", "putFloat", "putBoolean", "remove", QCircleLpReportDc05507.KEY_CLEAR, "commit", "apply", AudioContext.State.CLOSED, "Z", "mmapId", "Ljava/lang/String;", "mode", "I", "Lcom/tencent/mobileqq/qmmkv/MMKVHandlerBase;", "mmkvHandler", "Lcom/tencent/mobileqq/qmmkv/MMKVHandlerBase;", "Lcom/tencent/mobileqq/qmmkv/v2/j;", "retriever", "Lcom/tencent/mobileqq/qmmkv/v2/j;", "<init>", "(Ljava/lang/String;ILcom/tencent/mobileqq/qmmkv/MMKVHandlerBase;Lcom/tencent/mobileqq/qmmkv/v2/j;)V", "library_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class MMKVOptionEntityV2 extends MMKVOptionEntity implements e {
    private volatile boolean closed;
    private final String mmapId;
    private final MMKVHandlerBase mmkvHandler;
    private final int mode;
    private final j retriever;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MMKVOptionEntityV2(@Nullable String str, int i3, @NotNull MMKVHandlerBase mmkvHandler, @NotNull j retriever) {
        super(str, i3, mmkvHandler, retriever);
        Intrinsics.checkNotNullParameter(mmkvHandler, "mmkvHandler");
        Intrinsics.checkNotNullParameter(retriever, "retriever");
        Intrinsics.checkNotNull(str);
        this.mmapId = str;
        this.mode = i3;
        this.mmkvHandler = mmkvHandler;
        this.retriever = retriever;
    }

    public long actualSize(boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("actualSize not accessible");
            return 0L;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        return jVar.c(str, this.mode, false).actualSize();
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @Nullable
    public String[] allKeys() {
        return allKeys(false);
    }

    public void apply(boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("apply not accessible");
            return;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        jVar.c(str, this.mode, boundToAccount).apply();
    }

    @Override // android.content.SharedPreferences.Editor
    @NotNull
    public SharedPreferences.Editor clear() {
        clear(false);
        return this;
    }

    public final boolean close(boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("closeEntity not accessible");
            return false;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        if (jVar.e(str, boundToAccount)) {
            this.closed = true;
        }
        return this.closed;
    }

    public boolean commit(boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("commit not accessible");
            return false;
        }
        if (QMMKV.syncMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onSync(str, true);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, boundToAccount).commit();
        return true;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(@Nullable String key) {
        return contains(key, false);
    }

    public long count(boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("count not accessible");
            return 0L;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        return jVar.c(str, this.mode, boundToAccount).count();
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Map<String, ?> getAll() {
        return getAll(false);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(@Nullable String key, boolean defValue) {
        return getBoolean(key, defValue, false);
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @Nullable
    public byte[] getBytes(@Nullable String key, @Nullable byte[] defaultValue) {
        return getBytes(key, defaultValue, false);
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    public double getDouble(@Nullable String key, double defaultValue) {
        return getDouble(key, defaultValue, false);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(@Nullable String key, float defValue) {
        return getFloat(key, defValue, false);
    }

    @Override // android.content.SharedPreferences
    public int getInt(@Nullable String key, int defValue) {
        return getInt(key, defValue, false);
    }

    @Override // android.content.SharedPreferences
    public long getLong(@Nullable String key, long defValue) {
        return getLong(key, defValue, false);
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @Nullable
    public <T extends Parcelable> T getParcelable(@Nullable String key, @NotNull Class<T> tClass, @Nullable T defaultValue) {
        Intrinsics.checkNotNullParameter(tClass, "tClass");
        return (T) getParcelable(key, tClass, defaultValue, false);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(@Nullable String key, @Nullable String defValue) {
        return getString(key, defValue, false);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(@Nullable String key, @Nullable Set<String> defValues) {
        return getStringSet(key, defValues, false);
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    public int getValueActualSize(@Nullable String key) {
        return getValueActualSize(key, false);
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    public int getValueSize(@Nullable String key) {
        return getValueSize(key, false);
    }

    public boolean isAccessible(boolean boundToAccount) {
        String str = this.mmapId;
        return !(str == null || str.length() == 0);
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @Nullable
    /* renamed from: mmapID, reason: from getter */
    public String getMmapId() {
        return this.mmapId;
    }

    @Nullable
    public String mmapKey(boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("mmapKey not accessible");
            return null;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        return jVar.c(str, this.mode, boundToAccount).mmapKey();
    }

    @Override // android.content.SharedPreferences.Editor
    @NotNull
    public SharedPreferences.Editor putBoolean(@Nullable String key, boolean value) {
        putBoolean(key, value, false);
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putBytes(@Nullable String key, @Nullable byte[] value) {
        return putBytes(key, value, false);
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putDouble(@Nullable String key, double value) {
        return putDouble(key, value, false);
    }

    @Override // android.content.SharedPreferences.Editor
    @NotNull
    public SharedPreferences.Editor putFloat(@Nullable String key, float value) {
        putFloat(key, value, false);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    @NotNull
    public SharedPreferences.Editor putInt(@Nullable String key, int value) {
        putInt(key, value, false);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    @NotNull
    public SharedPreferences.Editor putLong(@Nullable String key, long value) {
        putLong(key, value, false);
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putParcelable(@Nullable String key, @Nullable Parcelable value) {
        return putParcelable(key, value, false);
    }

    @Override // android.content.SharedPreferences.Editor
    @NotNull
    public SharedPreferences.Editor putString(@Nullable String key, @Nullable String value) {
        putString(key, value, false);
        return this;
    }

    public boolean putStringR(@Nullable String key, @Nullable String value, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("putStringR not accessible");
            return false;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, value);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        return jVar.c(str2, this.mode, boundToAccount).putStringR(key, value);
    }

    @Override // android.content.SharedPreferences.Editor
    @NotNull
    public SharedPreferences.Editor putStringSet(@Nullable String key, @Nullable Set<String> values) {
        putStringSet(key, values, false);
        return this;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener listener) {
        if (!isAccessible()) {
            QMMKV.logError("registerOnSharedPreferenceChangeListener not accessible");
            return;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        jVar.c(str, this.mode, false).registerOnSharedPreferenceChangeListener(listener);
    }

    @Override // android.content.SharedPreferences.Editor
    @NotNull
    public SharedPreferences.Editor remove(@Nullable String key) {
        remove(key, false);
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor removeValueForKey(@Nullable String key) {
        return removeValueForKey(key, false);
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor removeValuesForKeys(@Nullable String[] keys) {
        return removeValuesForKeys(keys, false);
    }

    public long totalSize(boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("totalSize not accessible");
            return 0L;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        return jVar.c(str, this.mode, boundToAccount).totalSize();
    }

    @Override // com.tencent.mobileqq.qmmkv.MMKVOptionEntity, com.tencent.mobileqq.qmmkv.v2.e
    public void trim() {
        trim(false);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener listener) {
        if (!isAccessible()) {
            QMMKV.logError("unregisterOnSharedPreferenceChangeListener not accessible");
            return;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        jVar.c(str, this.mode, false).unregisterOnSharedPreferenceChangeListener(listener);
    }

    @Nullable
    public String[] allKeys(boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("allKeys not accessible");
            return null;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        return jVar.c(str, this.mode, boundToAccount).allKeys();
    }

    @NotNull
    public SharedPreferences.Editor clear(boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("clear not accessible");
            return this;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        jVar.c(str, this.mode, boundToAccount).clear();
        return this;
    }

    public boolean contains(@Nullable String key, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("contains not accessible");
            return false;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        return jVar.c(str, this.mode, boundToAccount).contains(key);
    }

    @Nullable
    public final Map<String, ?> getAll(boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("getAll not accessible");
            return null;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        return jVar.c(str, this.mode, boundToAccount).getAll();
    }

    public boolean getBoolean(@Nullable String key, boolean defValue, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("getBoolean not accessible");
            return defValue;
        }
        if (QMMKV.decodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onDecode(str, key);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        return jVar.c(str2, this.mode, boundToAccount).getBoolean(key, defValue);
    }

    @Nullable
    public byte[] getBytes(@Nullable String key, @Nullable byte[] defaultValue, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("getBytes not accessible");
            return defaultValue;
        }
        if (QMMKV.decodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onDecode(str, key);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        return jVar.c(str2, this.mode, boundToAccount).getBytes(key, defaultValue);
    }

    public double getDouble(@Nullable String key, double defaultValue, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("getDouble not accessible");
            return defaultValue;
        }
        if (QMMKV.decodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onDecode(str, key);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        return jVar.c(str2, this.mode, boundToAccount).getDouble(key, defaultValue);
    }

    public float getFloat(@Nullable String key, float defValue, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("getFloat not accessible");
            return defValue;
        }
        if (QMMKV.decodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onDecode(str, key);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        return jVar.c(str2, this.mode, boundToAccount).getFloat(key, defValue);
    }

    public int getInt(@Nullable String key, int defValue, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("getInt not accessible");
            return defValue;
        }
        if (QMMKV.decodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onDecode(str, key);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        return jVar.c(str2, this.mode, boundToAccount).getInt(key, defValue);
    }

    public long getLong(@Nullable String key, long defValue, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("getLong not accessible");
            return defValue;
        }
        if (QMMKV.decodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onDecode(str, key);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        return jVar.c(str2, this.mode, boundToAccount).getLong(key, defValue);
    }

    @Nullable
    public <T extends Parcelable> T getParcelable(@Nullable String key, @NotNull Class<T> tClass, @Nullable T defaultValue, boolean boundToAccount) {
        Intrinsics.checkNotNullParameter(tClass, "tClass");
        if (!isAccessible()) {
            QMMKV.logError("getParcelable not accessible");
            return defaultValue;
        }
        if (QMMKV.decodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onDecode(str, key);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        return (T) jVar.c(str2, this.mode, boundToAccount).getParcelable(key, tClass, defaultValue);
    }

    @Nullable
    public String getString(@Nullable String key, @Nullable String defValue, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("getString not accessible");
            return defValue;
        }
        if (QMMKV.decodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onDecode(str, key);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        return jVar.c(str2, this.mode, boundToAccount).getString(key, defValue);
    }

    @Nullable
    public Set<String> getStringSet(@Nullable String key, @Nullable Set<String> defValues, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("getStringSet not accessible");
            return defValues;
        }
        if (QMMKV.decodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onDecode(str, key);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        return jVar.c(str2, this.mode, boundToAccount).getStringSet(key, defValues);
    }

    public int getValueActualSize(@Nullable String key, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("getValueActualSize not accessible");
            return 0;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        return jVar.c(str, this.mode, boundToAccount).getValueActualSize(key);
    }

    public int getValueSize(@Nullable String key, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("getValueSize not accessible");
            return 0;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        return jVar.c(str, this.mode, boundToAccount).getValueSize(key);
    }

    @Override // com.tencent.mobileqq.qmmkv.MMKVOptionEntity
    public boolean isAccessible() {
        return (this.mmapId == null || this.closed) ? false : true;
    }

    @NotNull
    public SharedPreferences.Editor putBoolean(@Nullable String key, boolean value, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("putBoolean not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, Boolean.valueOf(value));
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, boundToAccount).putBoolean(key, value);
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putBytes(@Nullable String key, @Nullable byte[] value, int expireDurationInSecond) {
        if (!isAccessible()) {
            QMMKV.logError("putBytes not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, value);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, false).putBytes(key, value, expireDurationInSecond);
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putDouble(@Nullable String key, double value, int expireDurationInSecond) {
        if (!isAccessible()) {
            QMMKV.logError("putDouble not accessible");
            return this;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        jVar.c(str, this.mode, false).putDouble(key, value, expireDurationInSecond);
        return this;
    }

    @NotNull
    public SharedPreferences.Editor putFloat(@Nullable String key, float value, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("putFloat not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, Float.valueOf(value));
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, boundToAccount).putFloat(key, value);
        return this;
    }

    @NotNull
    public SharedPreferences.Editor putInt(@Nullable String key, int value, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("putInt not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, Integer.valueOf(value));
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, boundToAccount).putInt(key, value);
        return this;
    }

    @NotNull
    public SharedPreferences.Editor putLong(@Nullable String key, long value, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("putLong not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, Long.valueOf(value));
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, boundToAccount).putLong(key, value);
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putParcelable(@Nullable String key, @Nullable Parcelable value, int expireDurationInSecond) {
        if (!isAccessible()) {
            QMMKV.logError("putParcelable not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, value);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, false).putParcelable(key, value, expireDurationInSecond);
        return this;
    }

    @NotNull
    public SharedPreferences.Editor putString(@Nullable String key, @Nullable String value, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("putString not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, value);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, boundToAccount).putString(key, value);
        return this;
    }

    @NotNull
    public SharedPreferences.Editor putStringSet(@Nullable String key, @Nullable Set<String> values, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("putStringSet not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, values);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, boundToAccount).putStringSet(key, values);
        return this;
    }

    @NotNull
    public SharedPreferences.Editor remove(@Nullable String key, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("remove not accessible");
            return this;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        jVar.c(str, this.mode, boundToAccount).remove(key);
        return this;
    }

    @NotNull
    public SharedPreferences.Editor removeValueForKey(@Nullable String key, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("removeValueForKey not accessible");
            return this;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        jVar.c(str, this.mode, boundToAccount).remove(key);
        return this;
    }

    @NotNull
    public SharedPreferences.Editor removeValuesForKeys(@Nullable String[] keys, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("removeValuesForKeys not accessible");
            return this;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        jVar.c(str, this.mode, boundToAccount).removeValuesForKeys(keys);
        return this;
    }

    public void trim(boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("trim not accessible");
            return;
        }
        j jVar = this.retriever;
        String str = this.mmapId;
        Intrinsics.checkNotNull(str);
        e c16 = jVar.c(str, this.mode, boundToAccount);
        if (c16.totalSize() > 0) {
            c16.trim();
            return;
        }
        QMMKV.logInfo("no need to trim mmapId: " + this.mmapId);
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        apply(false);
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @Nullable
    public String mmapKey() {
        return this.mmapId;
    }

    @NotNull
    public SharedPreferences.Editor putDouble(@Nullable String key, double value, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("putDouble not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, Double.valueOf(value));
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, boundToAccount).putDouble(key, value);
        return this;
    }

    public final boolean close() {
        return close(false);
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return commit(false);
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    public boolean putStringR(@Nullable String key, @Nullable String value) {
        return putStringR(key, value, false);
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putBoolean(@Nullable String key, boolean value, int expireDurationInSecond) {
        if (!isAccessible()) {
            QMMKV.logError("putBoolean not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, Boolean.valueOf(value));
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, false).putBoolean(key, value, expireDurationInSecond);
        return this;
    }

    @NotNull
    public SharedPreferences.Editor putBytes(@Nullable String key, @Nullable byte[] value, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("putBytes not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, value);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, boundToAccount).putBytes(key, value);
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putFloat(@Nullable String key, float value, int expireDurationInSecond) {
        if (!isAccessible()) {
            QMMKV.logError("putFloat not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, Float.valueOf(value));
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, false).putFloat(key, value, expireDurationInSecond);
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putInt(@Nullable String key, int value, int expireDurationInSecond) {
        if (!isAccessible()) {
            QMMKV.logError("putInt not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, Integer.valueOf(value));
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, false).putInt(key, value, expireDurationInSecond);
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putLong(@Nullable String key, long value, int expireDurationInSecond) {
        if (!isAccessible()) {
            QMMKV.logError("putLong not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, Long.valueOf(value));
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, false).putLong(key, value, expireDurationInSecond);
        return this;
    }

    @NotNull
    public SharedPreferences.Editor putParcelable(@Nullable String key, @Nullable Parcelable value, boolean boundToAccount) {
        if (!isAccessible()) {
            QMMKV.logError("putParcelable not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, value);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, boundToAccount).putParcelable(key, value);
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putString(@Nullable String key, @Nullable String value, int expireDurationInSecond) {
        if (!isAccessible()) {
            QMMKV.logError("putString not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, value);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, false).putString(key, value, expireDurationInSecond);
        return this;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.e
    @NotNull
    public SharedPreferences.Editor putStringSet(@Nullable String key, @Nullable Set<String> values, int expireDurationInSecond) {
        if (!isAccessible()) {
            QMMKV.logError("putStringSet not accessible");
            return this;
        }
        if (QMMKV.encodeMonitorOn) {
            MMKVHandlerBase mMKVHandlerBase = this.mmkvHandler;
            String str = this.mmapId;
            Intrinsics.checkNotNull(str);
            mMKVHandlerBase.onEncode(str, key, values);
        }
        j jVar = this.retriever;
        String str2 = this.mmapId;
        Intrinsics.checkNotNull(str2);
        jVar.c(str2, this.mode, false).putStringSet(key, values, expireDurationInSecond);
        return this;
    }

    @Override // android.content.SharedPreferences
    @NotNull
    public SharedPreferences.Editor edit() {
        return this;
    }
}
