package com.tencent.qqmini.sdk.launcher.core.proxy.va;

import com.tencent.hippy.qq.module.HippyQQHttpModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0010 \n\u0002\bi\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00f5\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u0003\u0012\b\b\u0002\u0010$\u001a\u00020\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u0012\b\b\u0002\u0010&\u001a\u00020\u0003\u0012\b\b\u0002\u0010'\u001a\u00020\u0003\u0012\b\b\u0002\u0010(\u001a\u00020\u0003\u0012\b\b\u0002\u0010)\u001a\u00020\u0003\u0012\b\b\u0002\u0010*\u001a\u00020\u0003\u0012\b\b\u0002\u0010+\u001a\u00020\u0003\u0012\b\b\u0002\u0010,\u001a\u00020\u0003\u0012\b\b\u0002\u0010-\u001a\u00020\u0003\u0012\b\b\u0002\u0010.\u001a\u00020\u0003\u0012\b\b\u0002\u0010/\u001a\u00020\u0003\u0012\b\b\u0002\u00100\u001a\u00020\u0003\u0012\b\b\u0002\u00101\u001a\u00020\u0003\u0012\b\b\u0002\u00102\u001a\u00020\u0003\u0012\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\u000304\u00a2\u0006\u0002\u00105J\t\u0010k\u001a\u00020\u0003H\u00c6\u0003J\t\u0010l\u001a\u00020\u0003H\u00c6\u0003J\t\u0010m\u001a\u00020\u0003H\u00c6\u0003J\t\u0010n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010o\u001a\u00020\u0003H\u00c6\u0003J\t\u0010p\u001a\u00020\u0003H\u00c6\u0003J\t\u0010q\u001a\u00020\u0003H\u00c6\u0003J\t\u0010r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010s\u001a\u00020\u0003H\u00c6\u0003J\t\u0010t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010u\u001a\u00020\u0003H\u00c6\u0003J\t\u0010v\u001a\u00020\u0003H\u00c6\u0003J\t\u0010w\u001a\u00020\u0003H\u00c6\u0003J\t\u0010x\u001a\u00020\u0003H\u00c6\u0003J\t\u0010y\u001a\u00020\u0003H\u00c6\u0003J\t\u0010z\u001a\u00020\u0003H\u00c6\u0003J\t\u0010{\u001a\u00020\u0003H\u00c6\u0003J\t\u0010|\u001a\u00020\u0003H\u00c6\u0003J\t\u0010}\u001a\u00020\u0003H\u00c6\u0003J\t\u0010~\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u007f\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00020\u000304H\u00c6\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0003H\u00c6\u0003J\u00fa\u0003\u0010\u009c\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u00032\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\u000304H\u00c6\u0001J\u0016\u0010\u009d\u0001\u001a\u00030\u009e\u00012\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u000b\u0010\u00a0\u0001\u001a\u00030\u00a1\u0001H\u00d6\u0001J\n\u0010\u00a2\u0001\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u001f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010 \u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00107R\u0011\u0010\u001e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u00107R\u0011\u0010\u001b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u00107R \u00103\u001a\b\u0012\u0004\u0012\u00020\u000304X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0011\u00101\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u00107R\u0011\u00102\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u00107R\u0011\u00100\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u00107R\u0011\u0010\u001d\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u00107R\u0011\u0010\u001c\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u00107R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u00107R\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u00107R\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u00107R\u0011\u0010\u001a\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u00107R\u0011\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u00107R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u00107R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u00107R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u00107R\u0011\u0010/\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u00107R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u00107R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u00107R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u00107R\u0011\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u00107R\u0011\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u00107R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u00107R\u0011\u0010#\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u00107R\u0011\u0010(\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u00107R\u0011\u0010-\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u00107R\u0011\u0010.\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u00107R\u0011\u0010,\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u00107R\u0011\u0010*\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u00107R\u0011\u0010+\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u00107R\u0011\u0010)\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bZ\u00107R\u0011\u0010$\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b[\u00107R\u0011\u0010&\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u00107R\u0011\u0010%\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b]\u00107R\u0011\u0010'\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u00107R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b_\u00107R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b`\u00107R\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\ba\u00107R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bb\u00107R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bc\u00107R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bd\u00107R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\be\u00107R\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bf\u00107R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bg\u00107R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bh\u00107R\u0011\u0010!\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bi\u00107R\u0011\u0010\"\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bj\u00107\u00a8\u0006\u00a3\u0001"}, d2 = {"Lcom/tencent/qqmini/sdk/launcher/core/proxy/va/VACustomTextConfig;", "", "retainStopText", "", "retainStopLeftBtnText", "retainStopRightBtnText", "retainCancelText", "retainCancelLeftBtnText", "retainCancelRightBtnText", "wlanTipsInQueueText", "wlanTipsInGameText", "wifiTipsInQueueText", "wifiTipsInGameText", "tipsBtnText", "foldedTipsText", "wlanLoadingInQueueText", "wifiLoadingInQueueText", "wlanLoadingInGameText", "wifiLoadingInGameText", "loadingLeftBtnText", "loadingRightBtnText", "wlanStopText", "wifiStopText", "stopLeftBtnText", "stopRightBtnText", "restartText", "restartBtnText", "autoRestartText", HippyQQHttpModule.HTPP_ERROR_TEXT, "errorBtnText", "authText", "authLeftBtnText", "authRightBtnText", "yunGameLoadingText", "yunGameQueueText", "vaInitText", "vaWifiLoadingText", "vaWlanLoadingText", "vaWifiStopText", "vaWlanStopText", "vaRestartText", "vaRetainStopText", "vaRetainStopLeftBtnText", "vaRetainStopRightBtnText", "vaRetainCancelText", "vaRetainCancelLeftBtnText", "vaRetainCancelRightBtnText", "retainDialogBgUrl", "dualChannelDownloadTipsTest", "dualChannelDownloadLeftBtnTest", "dualChannelDownloadRightBtnTest", "defaultDanmakuList", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAuthLeftBtnText", "()Ljava/lang/String;", "getAuthRightBtnText", "getAuthText", "getAutoRestartText", "getDefaultDanmakuList", "()Ljava/util/List;", "setDefaultDanmakuList", "(Ljava/util/List;)V", "getDualChannelDownloadLeftBtnTest", "getDualChannelDownloadRightBtnTest", "getDualChannelDownloadTipsTest", "getErrorBtnText", "getErrorText", "getFoldedTipsText", "getLoadingLeftBtnText", "getLoadingRightBtnText", "getRestartBtnText", "getRestartText", "getRetainCancelLeftBtnText", "getRetainCancelRightBtnText", "getRetainCancelText", "getRetainDialogBgUrl", "getRetainStopLeftBtnText", "getRetainStopRightBtnText", "getRetainStopText", "getStopLeftBtnText", "getStopRightBtnText", "getTipsBtnText", "getVaInitText", "getVaRestartText", "getVaRetainCancelLeftBtnText", "getVaRetainCancelRightBtnText", "getVaRetainCancelText", "getVaRetainStopLeftBtnText", "getVaRetainStopRightBtnText", "getVaRetainStopText", "getVaWifiLoadingText", "getVaWifiStopText", "getVaWlanLoadingText", "getVaWlanStopText", "getWifiLoadingInGameText", "getWifiLoadingInQueueText", "getWifiStopText", "getWifiTipsInGameText", "getWifiTipsInQueueText", "getWlanLoadingInGameText", "getWlanLoadingInQueueText", "getWlanStopText", "getWlanTipsInGameText", "getWlanTipsInQueueText", "getYunGameLoadingText", "getYunGameQueueText", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "lib_minilauncher_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final /* data */ class VACustomTextConfig {

    @NotNull
    private final String authLeftBtnText;

    @NotNull
    private final String authRightBtnText;

    @NotNull
    private final String authText;

    @NotNull
    private final String autoRestartText;

    @NotNull
    private List<String> defaultDanmakuList;

    @NotNull
    private final String dualChannelDownloadLeftBtnTest;

    @NotNull
    private final String dualChannelDownloadRightBtnTest;

    @NotNull
    private final String dualChannelDownloadTipsTest;

    @NotNull
    private final String errorBtnText;

    @NotNull
    private final String errorText;

    @NotNull
    private final String foldedTipsText;

    @NotNull
    private final String loadingLeftBtnText;

    @NotNull
    private final String loadingRightBtnText;

    @NotNull
    private final String restartBtnText;

    @NotNull
    private final String restartText;

    @NotNull
    private final String retainCancelLeftBtnText;

    @NotNull
    private final String retainCancelRightBtnText;

    @NotNull
    private final String retainCancelText;

    @NotNull
    private final String retainDialogBgUrl;

    @NotNull
    private final String retainStopLeftBtnText;

    @NotNull
    private final String retainStopRightBtnText;

    @NotNull
    private final String retainStopText;

    @NotNull
    private final String stopLeftBtnText;

    @NotNull
    private final String stopRightBtnText;

    @NotNull
    private final String tipsBtnText;

    @NotNull
    private final String vaInitText;

    @NotNull
    private final String vaRestartText;

    @NotNull
    private final String vaRetainCancelLeftBtnText;

    @NotNull
    private final String vaRetainCancelRightBtnText;

    @NotNull
    private final String vaRetainCancelText;

    @NotNull
    private final String vaRetainStopLeftBtnText;

    @NotNull
    private final String vaRetainStopRightBtnText;

    @NotNull
    private final String vaRetainStopText;

    @NotNull
    private final String vaWifiLoadingText;

    @NotNull
    private final String vaWifiStopText;

    @NotNull
    private final String vaWlanLoadingText;

    @NotNull
    private final String vaWlanStopText;

    @NotNull
    private final String wifiLoadingInGameText;

    @NotNull
    private final String wifiLoadingInQueueText;

    @NotNull
    private final String wifiStopText;

    @NotNull
    private final String wifiTipsInGameText;

    @NotNull
    private final String wifiTipsInQueueText;

    @NotNull
    private final String wlanLoadingInGameText;

    @NotNull
    private final String wlanLoadingInQueueText;

    @NotNull
    private final String wlanStopText;

    @NotNull
    private final String wlanTipsInGameText;

    @NotNull
    private final String wlanTipsInQueueText;

    @NotNull
    private final String yunGameLoadingText;

    @NotNull
    private final String yunGameQueueText;

    public VACustomTextConfig() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 131071, null);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getRetainStopText() {
        return this.retainStopText;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getWifiTipsInGameText() {
        return this.wifiTipsInGameText;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final String getTipsBtnText() {
        return this.tipsBtnText;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final String getFoldedTipsText() {
        return this.foldedTipsText;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final String getWlanLoadingInQueueText() {
        return this.wlanLoadingInQueueText;
    }

    @NotNull
    /* renamed from: component14, reason: from getter */
    public final String getWifiLoadingInQueueText() {
        return this.wifiLoadingInQueueText;
    }

    @NotNull
    /* renamed from: component15, reason: from getter */
    public final String getWlanLoadingInGameText() {
        return this.wlanLoadingInGameText;
    }

    @NotNull
    /* renamed from: component16, reason: from getter */
    public final String getWifiLoadingInGameText() {
        return this.wifiLoadingInGameText;
    }

    @NotNull
    /* renamed from: component17, reason: from getter */
    public final String getLoadingLeftBtnText() {
        return this.loadingLeftBtnText;
    }

    @NotNull
    /* renamed from: component18, reason: from getter */
    public final String getLoadingRightBtnText() {
        return this.loadingRightBtnText;
    }

    @NotNull
    /* renamed from: component19, reason: from getter */
    public final String getWlanStopText() {
        return this.wlanStopText;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getRetainStopLeftBtnText() {
        return this.retainStopLeftBtnText;
    }

    @NotNull
    /* renamed from: component20, reason: from getter */
    public final String getWifiStopText() {
        return this.wifiStopText;
    }

    @NotNull
    /* renamed from: component21, reason: from getter */
    public final String getStopLeftBtnText() {
        return this.stopLeftBtnText;
    }

    @NotNull
    /* renamed from: component22, reason: from getter */
    public final String getStopRightBtnText() {
        return this.stopRightBtnText;
    }

    @NotNull
    /* renamed from: component23, reason: from getter */
    public final String getRestartText() {
        return this.restartText;
    }

    @NotNull
    /* renamed from: component24, reason: from getter */
    public final String getRestartBtnText() {
        return this.restartBtnText;
    }

    @NotNull
    /* renamed from: component25, reason: from getter */
    public final String getAutoRestartText() {
        return this.autoRestartText;
    }

    @NotNull
    /* renamed from: component26, reason: from getter */
    public final String getErrorText() {
        return this.errorText;
    }

    @NotNull
    /* renamed from: component27, reason: from getter */
    public final String getErrorBtnText() {
        return this.errorBtnText;
    }

    @NotNull
    /* renamed from: component28, reason: from getter */
    public final String getAuthText() {
        return this.authText;
    }

    @NotNull
    /* renamed from: component29, reason: from getter */
    public final String getAuthLeftBtnText() {
        return this.authLeftBtnText;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getRetainStopRightBtnText() {
        return this.retainStopRightBtnText;
    }

    @NotNull
    /* renamed from: component30, reason: from getter */
    public final String getAuthRightBtnText() {
        return this.authRightBtnText;
    }

    @NotNull
    /* renamed from: component31, reason: from getter */
    public final String getYunGameLoadingText() {
        return this.yunGameLoadingText;
    }

    @NotNull
    /* renamed from: component32, reason: from getter */
    public final String getYunGameQueueText() {
        return this.yunGameQueueText;
    }

    @NotNull
    /* renamed from: component33, reason: from getter */
    public final String getVaInitText() {
        return this.vaInitText;
    }

    @NotNull
    /* renamed from: component34, reason: from getter */
    public final String getVaWifiLoadingText() {
        return this.vaWifiLoadingText;
    }

    @NotNull
    /* renamed from: component35, reason: from getter */
    public final String getVaWlanLoadingText() {
        return this.vaWlanLoadingText;
    }

    @NotNull
    /* renamed from: component36, reason: from getter */
    public final String getVaWifiStopText() {
        return this.vaWifiStopText;
    }

    @NotNull
    /* renamed from: component37, reason: from getter */
    public final String getVaWlanStopText() {
        return this.vaWlanStopText;
    }

    @NotNull
    /* renamed from: component38, reason: from getter */
    public final String getVaRestartText() {
        return this.vaRestartText;
    }

    @NotNull
    /* renamed from: component39, reason: from getter */
    public final String getVaRetainStopText() {
        return this.vaRetainStopText;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getRetainCancelText() {
        return this.retainCancelText;
    }

    @NotNull
    /* renamed from: component40, reason: from getter */
    public final String getVaRetainStopLeftBtnText() {
        return this.vaRetainStopLeftBtnText;
    }

    @NotNull
    /* renamed from: component41, reason: from getter */
    public final String getVaRetainStopRightBtnText() {
        return this.vaRetainStopRightBtnText;
    }

    @NotNull
    /* renamed from: component42, reason: from getter */
    public final String getVaRetainCancelText() {
        return this.vaRetainCancelText;
    }

    @NotNull
    /* renamed from: component43, reason: from getter */
    public final String getVaRetainCancelLeftBtnText() {
        return this.vaRetainCancelLeftBtnText;
    }

    @NotNull
    /* renamed from: component44, reason: from getter */
    public final String getVaRetainCancelRightBtnText() {
        return this.vaRetainCancelRightBtnText;
    }

    @NotNull
    /* renamed from: component45, reason: from getter */
    public final String getRetainDialogBgUrl() {
        return this.retainDialogBgUrl;
    }

    @NotNull
    /* renamed from: component46, reason: from getter */
    public final String getDualChannelDownloadTipsTest() {
        return this.dualChannelDownloadTipsTest;
    }

    @NotNull
    /* renamed from: component47, reason: from getter */
    public final String getDualChannelDownloadLeftBtnTest() {
        return this.dualChannelDownloadLeftBtnTest;
    }

    @NotNull
    /* renamed from: component48, reason: from getter */
    public final String getDualChannelDownloadRightBtnTest() {
        return this.dualChannelDownloadRightBtnTest;
    }

    @NotNull
    public final List<String> component49() {
        return this.defaultDanmakuList;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getRetainCancelLeftBtnText() {
        return this.retainCancelLeftBtnText;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getRetainCancelRightBtnText() {
        return this.retainCancelRightBtnText;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getWlanTipsInQueueText() {
        return this.wlanTipsInQueueText;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getWlanTipsInGameText() {
        return this.wlanTipsInGameText;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getWifiTipsInQueueText() {
        return this.wifiTipsInQueueText;
    }

    @NotNull
    public final VACustomTextConfig copy(@NotNull String retainStopText, @NotNull String retainStopLeftBtnText, @NotNull String retainStopRightBtnText, @NotNull String retainCancelText, @NotNull String retainCancelLeftBtnText, @NotNull String retainCancelRightBtnText, @NotNull String wlanTipsInQueueText, @NotNull String wlanTipsInGameText, @NotNull String wifiTipsInQueueText, @NotNull String wifiTipsInGameText, @NotNull String tipsBtnText, @NotNull String foldedTipsText, @NotNull String wlanLoadingInQueueText, @NotNull String wifiLoadingInQueueText, @NotNull String wlanLoadingInGameText, @NotNull String wifiLoadingInGameText, @NotNull String loadingLeftBtnText, @NotNull String loadingRightBtnText, @NotNull String wlanStopText, @NotNull String wifiStopText, @NotNull String stopLeftBtnText, @NotNull String stopRightBtnText, @NotNull String restartText, @NotNull String restartBtnText, @NotNull String autoRestartText, @NotNull String errorText, @NotNull String errorBtnText, @NotNull String authText, @NotNull String authLeftBtnText, @NotNull String authRightBtnText, @NotNull String yunGameLoadingText, @NotNull String yunGameQueueText, @NotNull String vaInitText, @NotNull String vaWifiLoadingText, @NotNull String vaWlanLoadingText, @NotNull String vaWifiStopText, @NotNull String vaWlanStopText, @NotNull String vaRestartText, @NotNull String vaRetainStopText, @NotNull String vaRetainStopLeftBtnText, @NotNull String vaRetainStopRightBtnText, @NotNull String vaRetainCancelText, @NotNull String vaRetainCancelLeftBtnText, @NotNull String vaRetainCancelRightBtnText, @NotNull String retainDialogBgUrl, @NotNull String dualChannelDownloadTipsTest, @NotNull String dualChannelDownloadLeftBtnTest, @NotNull String dualChannelDownloadRightBtnTest, @NotNull List<String> defaultDanmakuList) {
        Intrinsics.checkParameterIsNotNull(retainStopText, "retainStopText");
        Intrinsics.checkParameterIsNotNull(retainStopLeftBtnText, "retainStopLeftBtnText");
        Intrinsics.checkParameterIsNotNull(retainStopRightBtnText, "retainStopRightBtnText");
        Intrinsics.checkParameterIsNotNull(retainCancelText, "retainCancelText");
        Intrinsics.checkParameterIsNotNull(retainCancelLeftBtnText, "retainCancelLeftBtnText");
        Intrinsics.checkParameterIsNotNull(retainCancelRightBtnText, "retainCancelRightBtnText");
        Intrinsics.checkParameterIsNotNull(wlanTipsInQueueText, "wlanTipsInQueueText");
        Intrinsics.checkParameterIsNotNull(wlanTipsInGameText, "wlanTipsInGameText");
        Intrinsics.checkParameterIsNotNull(wifiTipsInQueueText, "wifiTipsInQueueText");
        Intrinsics.checkParameterIsNotNull(wifiTipsInGameText, "wifiTipsInGameText");
        Intrinsics.checkParameterIsNotNull(tipsBtnText, "tipsBtnText");
        Intrinsics.checkParameterIsNotNull(foldedTipsText, "foldedTipsText");
        Intrinsics.checkParameterIsNotNull(wlanLoadingInQueueText, "wlanLoadingInQueueText");
        Intrinsics.checkParameterIsNotNull(wifiLoadingInQueueText, "wifiLoadingInQueueText");
        Intrinsics.checkParameterIsNotNull(wlanLoadingInGameText, "wlanLoadingInGameText");
        Intrinsics.checkParameterIsNotNull(wifiLoadingInGameText, "wifiLoadingInGameText");
        Intrinsics.checkParameterIsNotNull(loadingLeftBtnText, "loadingLeftBtnText");
        Intrinsics.checkParameterIsNotNull(loadingRightBtnText, "loadingRightBtnText");
        Intrinsics.checkParameterIsNotNull(wlanStopText, "wlanStopText");
        Intrinsics.checkParameterIsNotNull(wifiStopText, "wifiStopText");
        Intrinsics.checkParameterIsNotNull(stopLeftBtnText, "stopLeftBtnText");
        Intrinsics.checkParameterIsNotNull(stopRightBtnText, "stopRightBtnText");
        Intrinsics.checkParameterIsNotNull(restartText, "restartText");
        Intrinsics.checkParameterIsNotNull(restartBtnText, "restartBtnText");
        Intrinsics.checkParameterIsNotNull(autoRestartText, "autoRestartText");
        Intrinsics.checkParameterIsNotNull(errorText, "errorText");
        Intrinsics.checkParameterIsNotNull(errorBtnText, "errorBtnText");
        Intrinsics.checkParameterIsNotNull(authText, "authText");
        Intrinsics.checkParameterIsNotNull(authLeftBtnText, "authLeftBtnText");
        Intrinsics.checkParameterIsNotNull(authRightBtnText, "authRightBtnText");
        Intrinsics.checkParameterIsNotNull(yunGameLoadingText, "yunGameLoadingText");
        Intrinsics.checkParameterIsNotNull(yunGameQueueText, "yunGameQueueText");
        Intrinsics.checkParameterIsNotNull(vaInitText, "vaInitText");
        Intrinsics.checkParameterIsNotNull(vaWifiLoadingText, "vaWifiLoadingText");
        Intrinsics.checkParameterIsNotNull(vaWlanLoadingText, "vaWlanLoadingText");
        Intrinsics.checkParameterIsNotNull(vaWifiStopText, "vaWifiStopText");
        Intrinsics.checkParameterIsNotNull(vaWlanStopText, "vaWlanStopText");
        Intrinsics.checkParameterIsNotNull(vaRestartText, "vaRestartText");
        Intrinsics.checkParameterIsNotNull(vaRetainStopText, "vaRetainStopText");
        Intrinsics.checkParameterIsNotNull(vaRetainStopLeftBtnText, "vaRetainStopLeftBtnText");
        Intrinsics.checkParameterIsNotNull(vaRetainStopRightBtnText, "vaRetainStopRightBtnText");
        Intrinsics.checkParameterIsNotNull(vaRetainCancelText, "vaRetainCancelText");
        Intrinsics.checkParameterIsNotNull(vaRetainCancelLeftBtnText, "vaRetainCancelLeftBtnText");
        Intrinsics.checkParameterIsNotNull(vaRetainCancelRightBtnText, "vaRetainCancelRightBtnText");
        Intrinsics.checkParameterIsNotNull(retainDialogBgUrl, "retainDialogBgUrl");
        Intrinsics.checkParameterIsNotNull(dualChannelDownloadTipsTest, "dualChannelDownloadTipsTest");
        Intrinsics.checkParameterIsNotNull(dualChannelDownloadLeftBtnTest, "dualChannelDownloadLeftBtnTest");
        Intrinsics.checkParameterIsNotNull(dualChannelDownloadRightBtnTest, "dualChannelDownloadRightBtnTest");
        Intrinsics.checkParameterIsNotNull(defaultDanmakuList, "defaultDanmakuList");
        return new VACustomTextConfig(retainStopText, retainStopLeftBtnText, retainStopRightBtnText, retainCancelText, retainCancelLeftBtnText, retainCancelRightBtnText, wlanTipsInQueueText, wlanTipsInGameText, wifiTipsInQueueText, wifiTipsInGameText, tipsBtnText, foldedTipsText, wlanLoadingInQueueText, wifiLoadingInQueueText, wlanLoadingInGameText, wifiLoadingInGameText, loadingLeftBtnText, loadingRightBtnText, wlanStopText, wifiStopText, stopLeftBtnText, stopRightBtnText, restartText, restartBtnText, autoRestartText, errorText, errorBtnText, authText, authLeftBtnText, authRightBtnText, yunGameLoadingText, yunGameQueueText, vaInitText, vaWifiLoadingText, vaWlanLoadingText, vaWifiStopText, vaWlanStopText, vaRestartText, vaRetainStopText, vaRetainStopLeftBtnText, vaRetainStopRightBtnText, vaRetainCancelText, vaRetainCancelLeftBtnText, vaRetainCancelRightBtnText, retainDialogBgUrl, dualChannelDownloadTipsTest, dualChannelDownloadLeftBtnTest, dualChannelDownloadRightBtnTest, defaultDanmakuList);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof VACustomTextConfig) {
                VACustomTextConfig vACustomTextConfig = (VACustomTextConfig) other;
                if (!Intrinsics.areEqual(this.retainStopText, vACustomTextConfig.retainStopText) || !Intrinsics.areEqual(this.retainStopLeftBtnText, vACustomTextConfig.retainStopLeftBtnText) || !Intrinsics.areEqual(this.retainStopRightBtnText, vACustomTextConfig.retainStopRightBtnText) || !Intrinsics.areEqual(this.retainCancelText, vACustomTextConfig.retainCancelText) || !Intrinsics.areEqual(this.retainCancelLeftBtnText, vACustomTextConfig.retainCancelLeftBtnText) || !Intrinsics.areEqual(this.retainCancelRightBtnText, vACustomTextConfig.retainCancelRightBtnText) || !Intrinsics.areEqual(this.wlanTipsInQueueText, vACustomTextConfig.wlanTipsInQueueText) || !Intrinsics.areEqual(this.wlanTipsInGameText, vACustomTextConfig.wlanTipsInGameText) || !Intrinsics.areEqual(this.wifiTipsInQueueText, vACustomTextConfig.wifiTipsInQueueText) || !Intrinsics.areEqual(this.wifiTipsInGameText, vACustomTextConfig.wifiTipsInGameText) || !Intrinsics.areEqual(this.tipsBtnText, vACustomTextConfig.tipsBtnText) || !Intrinsics.areEqual(this.foldedTipsText, vACustomTextConfig.foldedTipsText) || !Intrinsics.areEqual(this.wlanLoadingInQueueText, vACustomTextConfig.wlanLoadingInQueueText) || !Intrinsics.areEqual(this.wifiLoadingInQueueText, vACustomTextConfig.wifiLoadingInQueueText) || !Intrinsics.areEqual(this.wlanLoadingInGameText, vACustomTextConfig.wlanLoadingInGameText) || !Intrinsics.areEqual(this.wifiLoadingInGameText, vACustomTextConfig.wifiLoadingInGameText) || !Intrinsics.areEqual(this.loadingLeftBtnText, vACustomTextConfig.loadingLeftBtnText) || !Intrinsics.areEqual(this.loadingRightBtnText, vACustomTextConfig.loadingRightBtnText) || !Intrinsics.areEqual(this.wlanStopText, vACustomTextConfig.wlanStopText) || !Intrinsics.areEqual(this.wifiStopText, vACustomTextConfig.wifiStopText) || !Intrinsics.areEqual(this.stopLeftBtnText, vACustomTextConfig.stopLeftBtnText) || !Intrinsics.areEqual(this.stopRightBtnText, vACustomTextConfig.stopRightBtnText) || !Intrinsics.areEqual(this.restartText, vACustomTextConfig.restartText) || !Intrinsics.areEqual(this.restartBtnText, vACustomTextConfig.restartBtnText) || !Intrinsics.areEqual(this.autoRestartText, vACustomTextConfig.autoRestartText) || !Intrinsics.areEqual(this.errorText, vACustomTextConfig.errorText) || !Intrinsics.areEqual(this.errorBtnText, vACustomTextConfig.errorBtnText) || !Intrinsics.areEqual(this.authText, vACustomTextConfig.authText) || !Intrinsics.areEqual(this.authLeftBtnText, vACustomTextConfig.authLeftBtnText) || !Intrinsics.areEqual(this.authRightBtnText, vACustomTextConfig.authRightBtnText) || !Intrinsics.areEqual(this.yunGameLoadingText, vACustomTextConfig.yunGameLoadingText) || !Intrinsics.areEqual(this.yunGameQueueText, vACustomTextConfig.yunGameQueueText) || !Intrinsics.areEqual(this.vaInitText, vACustomTextConfig.vaInitText) || !Intrinsics.areEqual(this.vaWifiLoadingText, vACustomTextConfig.vaWifiLoadingText) || !Intrinsics.areEqual(this.vaWlanLoadingText, vACustomTextConfig.vaWlanLoadingText) || !Intrinsics.areEqual(this.vaWifiStopText, vACustomTextConfig.vaWifiStopText) || !Intrinsics.areEqual(this.vaWlanStopText, vACustomTextConfig.vaWlanStopText) || !Intrinsics.areEqual(this.vaRestartText, vACustomTextConfig.vaRestartText) || !Intrinsics.areEqual(this.vaRetainStopText, vACustomTextConfig.vaRetainStopText) || !Intrinsics.areEqual(this.vaRetainStopLeftBtnText, vACustomTextConfig.vaRetainStopLeftBtnText) || !Intrinsics.areEqual(this.vaRetainStopRightBtnText, vACustomTextConfig.vaRetainStopRightBtnText) || !Intrinsics.areEqual(this.vaRetainCancelText, vACustomTextConfig.vaRetainCancelText) || !Intrinsics.areEqual(this.vaRetainCancelLeftBtnText, vACustomTextConfig.vaRetainCancelLeftBtnText) || !Intrinsics.areEqual(this.vaRetainCancelRightBtnText, vACustomTextConfig.vaRetainCancelRightBtnText) || !Intrinsics.areEqual(this.retainDialogBgUrl, vACustomTextConfig.retainDialogBgUrl) || !Intrinsics.areEqual(this.dualChannelDownloadTipsTest, vACustomTextConfig.dualChannelDownloadTipsTest) || !Intrinsics.areEqual(this.dualChannelDownloadLeftBtnTest, vACustomTextConfig.dualChannelDownloadLeftBtnTest) || !Intrinsics.areEqual(this.dualChannelDownloadRightBtnTest, vACustomTextConfig.dualChannelDownloadRightBtnTest) || !Intrinsics.areEqual(this.defaultDanmakuList, vACustomTextConfig.defaultDanmakuList)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getAuthLeftBtnText() {
        return this.authLeftBtnText;
    }

    @NotNull
    public final String getAuthRightBtnText() {
        return this.authRightBtnText;
    }

    @NotNull
    public final String getAuthText() {
        return this.authText;
    }

    @NotNull
    public final String getAutoRestartText() {
        return this.autoRestartText;
    }

    @NotNull
    public final List<String> getDefaultDanmakuList() {
        return this.defaultDanmakuList;
    }

    @NotNull
    public final String getDualChannelDownloadLeftBtnTest() {
        return this.dualChannelDownloadLeftBtnTest;
    }

    @NotNull
    public final String getDualChannelDownloadRightBtnTest() {
        return this.dualChannelDownloadRightBtnTest;
    }

    @NotNull
    public final String getDualChannelDownloadTipsTest() {
        return this.dualChannelDownloadTipsTest;
    }

    @NotNull
    public final String getErrorBtnText() {
        return this.errorBtnText;
    }

    @NotNull
    public final String getErrorText() {
        return this.errorText;
    }

    @NotNull
    public final String getFoldedTipsText() {
        return this.foldedTipsText;
    }

    @NotNull
    public final String getLoadingLeftBtnText() {
        return this.loadingLeftBtnText;
    }

    @NotNull
    public final String getLoadingRightBtnText() {
        return this.loadingRightBtnText;
    }

    @NotNull
    public final String getRestartBtnText() {
        return this.restartBtnText;
    }

    @NotNull
    public final String getRestartText() {
        return this.restartText;
    }

    @NotNull
    public final String getRetainCancelLeftBtnText() {
        return this.retainCancelLeftBtnText;
    }

    @NotNull
    public final String getRetainCancelRightBtnText() {
        return this.retainCancelRightBtnText;
    }

    @NotNull
    public final String getRetainCancelText() {
        return this.retainCancelText;
    }

    @NotNull
    public final String getRetainDialogBgUrl() {
        return this.retainDialogBgUrl;
    }

    @NotNull
    public final String getRetainStopLeftBtnText() {
        return this.retainStopLeftBtnText;
    }

    @NotNull
    public final String getRetainStopRightBtnText() {
        return this.retainStopRightBtnText;
    }

    @NotNull
    public final String getRetainStopText() {
        return this.retainStopText;
    }

    @NotNull
    public final String getStopLeftBtnText() {
        return this.stopLeftBtnText;
    }

    @NotNull
    public final String getStopRightBtnText() {
        return this.stopRightBtnText;
    }

    @NotNull
    public final String getTipsBtnText() {
        return this.tipsBtnText;
    }

    @NotNull
    public final String getVaInitText() {
        return this.vaInitText;
    }

    @NotNull
    public final String getVaRestartText() {
        return this.vaRestartText;
    }

    @NotNull
    public final String getVaRetainCancelLeftBtnText() {
        return this.vaRetainCancelLeftBtnText;
    }

    @NotNull
    public final String getVaRetainCancelRightBtnText() {
        return this.vaRetainCancelRightBtnText;
    }

    @NotNull
    public final String getVaRetainCancelText() {
        return this.vaRetainCancelText;
    }

    @NotNull
    public final String getVaRetainStopLeftBtnText() {
        return this.vaRetainStopLeftBtnText;
    }

    @NotNull
    public final String getVaRetainStopRightBtnText() {
        return this.vaRetainStopRightBtnText;
    }

    @NotNull
    public final String getVaRetainStopText() {
        return this.vaRetainStopText;
    }

    @NotNull
    public final String getVaWifiLoadingText() {
        return this.vaWifiLoadingText;
    }

    @NotNull
    public final String getVaWifiStopText() {
        return this.vaWifiStopText;
    }

    @NotNull
    public final String getVaWlanLoadingText() {
        return this.vaWlanLoadingText;
    }

    @NotNull
    public final String getVaWlanStopText() {
        return this.vaWlanStopText;
    }

    @NotNull
    public final String getWifiLoadingInGameText() {
        return this.wifiLoadingInGameText;
    }

    @NotNull
    public final String getWifiLoadingInQueueText() {
        return this.wifiLoadingInQueueText;
    }

    @NotNull
    public final String getWifiStopText() {
        return this.wifiStopText;
    }

    @NotNull
    public final String getWifiTipsInGameText() {
        return this.wifiTipsInGameText;
    }

    @NotNull
    public final String getWifiTipsInQueueText() {
        return this.wifiTipsInQueueText;
    }

    @NotNull
    public final String getWlanLoadingInGameText() {
        return this.wlanLoadingInGameText;
    }

    @NotNull
    public final String getWlanLoadingInQueueText() {
        return this.wlanLoadingInQueueText;
    }

    @NotNull
    public final String getWlanStopText() {
        return this.wlanStopText;
    }

    @NotNull
    public final String getWlanTipsInGameText() {
        return this.wlanTipsInGameText;
    }

    @NotNull
    public final String getWlanTipsInQueueText() {
        return this.wlanTipsInQueueText;
    }

    @NotNull
    public final String getYunGameLoadingText() {
        return this.yunGameLoadingText;
    }

    @NotNull
    public final String getYunGameQueueText() {
        return this.yunGameQueueText;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        int i56;
        int i57;
        int i58;
        int i59;
        int i65;
        int i66;
        int i67;
        int i68;
        int i69;
        int i75;
        int i76;
        int i77;
        int i78;
        int i79;
        int i85;
        int i86;
        int i87;
        int i88;
        int i89;
        int i95;
        int i96;
        int i97;
        int i98;
        int i99;
        int i100;
        int i101;
        int i102;
        int i103;
        int i104;
        int i105;
        int i106;
        String str = this.retainStopText;
        int i107 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i108 = i3 * 31;
        String str2 = this.retainStopLeftBtnText;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i109 = (i108 + i16) * 31;
        String str3 = this.retainStopRightBtnText;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i110 = (i109 + i17) * 31;
        String str4 = this.retainCancelText;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i111 = (i110 + i18) * 31;
        String str5 = this.retainCancelLeftBtnText;
        if (str5 != null) {
            i19 = str5.hashCode();
        } else {
            i19 = 0;
        }
        int i112 = (i111 + i19) * 31;
        String str6 = this.retainCancelRightBtnText;
        if (str6 != null) {
            i26 = str6.hashCode();
        } else {
            i26 = 0;
        }
        int i113 = (i112 + i26) * 31;
        String str7 = this.wlanTipsInQueueText;
        if (str7 != null) {
            i27 = str7.hashCode();
        } else {
            i27 = 0;
        }
        int i114 = (i113 + i27) * 31;
        String str8 = this.wlanTipsInGameText;
        if (str8 != null) {
            i28 = str8.hashCode();
        } else {
            i28 = 0;
        }
        int i115 = (i114 + i28) * 31;
        String str9 = this.wifiTipsInQueueText;
        if (str9 != null) {
            i29 = str9.hashCode();
        } else {
            i29 = 0;
        }
        int i116 = (i115 + i29) * 31;
        String str10 = this.wifiTipsInGameText;
        if (str10 != null) {
            i36 = str10.hashCode();
        } else {
            i36 = 0;
        }
        int i117 = (i116 + i36) * 31;
        String str11 = this.tipsBtnText;
        if (str11 != null) {
            i37 = str11.hashCode();
        } else {
            i37 = 0;
        }
        int i118 = (i117 + i37) * 31;
        String str12 = this.foldedTipsText;
        if (str12 != null) {
            i38 = str12.hashCode();
        } else {
            i38 = 0;
        }
        int i119 = (i118 + i38) * 31;
        String str13 = this.wlanLoadingInQueueText;
        if (str13 != null) {
            i39 = str13.hashCode();
        } else {
            i39 = 0;
        }
        int i120 = (i119 + i39) * 31;
        String str14 = this.wifiLoadingInQueueText;
        if (str14 != null) {
            i46 = str14.hashCode();
        } else {
            i46 = 0;
        }
        int i121 = (i120 + i46) * 31;
        String str15 = this.wlanLoadingInGameText;
        if (str15 != null) {
            i47 = str15.hashCode();
        } else {
            i47 = 0;
        }
        int i122 = (i121 + i47) * 31;
        String str16 = this.wifiLoadingInGameText;
        if (str16 != null) {
            i48 = str16.hashCode();
        } else {
            i48 = 0;
        }
        int i123 = (i122 + i48) * 31;
        String str17 = this.loadingLeftBtnText;
        if (str17 != null) {
            i49 = str17.hashCode();
        } else {
            i49 = 0;
        }
        int i124 = (i123 + i49) * 31;
        String str18 = this.loadingRightBtnText;
        if (str18 != null) {
            i56 = str18.hashCode();
        } else {
            i56 = 0;
        }
        int i125 = (i124 + i56) * 31;
        String str19 = this.wlanStopText;
        if (str19 != null) {
            i57 = str19.hashCode();
        } else {
            i57 = 0;
        }
        int i126 = (i125 + i57) * 31;
        String str20 = this.wifiStopText;
        if (str20 != null) {
            i58 = str20.hashCode();
        } else {
            i58 = 0;
        }
        int i127 = (i126 + i58) * 31;
        String str21 = this.stopLeftBtnText;
        if (str21 != null) {
            i59 = str21.hashCode();
        } else {
            i59 = 0;
        }
        int i128 = (i127 + i59) * 31;
        String str22 = this.stopRightBtnText;
        if (str22 != null) {
            i65 = str22.hashCode();
        } else {
            i65 = 0;
        }
        int i129 = (i128 + i65) * 31;
        String str23 = this.restartText;
        if (str23 != null) {
            i66 = str23.hashCode();
        } else {
            i66 = 0;
        }
        int i130 = (i129 + i66) * 31;
        String str24 = this.restartBtnText;
        if (str24 != null) {
            i67 = str24.hashCode();
        } else {
            i67 = 0;
        }
        int i131 = (i130 + i67) * 31;
        String str25 = this.autoRestartText;
        if (str25 != null) {
            i68 = str25.hashCode();
        } else {
            i68 = 0;
        }
        int i132 = (i131 + i68) * 31;
        String str26 = this.errorText;
        if (str26 != null) {
            i69 = str26.hashCode();
        } else {
            i69 = 0;
        }
        int i133 = (i132 + i69) * 31;
        String str27 = this.errorBtnText;
        if (str27 != null) {
            i75 = str27.hashCode();
        } else {
            i75 = 0;
        }
        int i134 = (i133 + i75) * 31;
        String str28 = this.authText;
        if (str28 != null) {
            i76 = str28.hashCode();
        } else {
            i76 = 0;
        }
        int i135 = (i134 + i76) * 31;
        String str29 = this.authLeftBtnText;
        if (str29 != null) {
            i77 = str29.hashCode();
        } else {
            i77 = 0;
        }
        int i136 = (i135 + i77) * 31;
        String str30 = this.authRightBtnText;
        if (str30 != null) {
            i78 = str30.hashCode();
        } else {
            i78 = 0;
        }
        int i137 = (i136 + i78) * 31;
        String str31 = this.yunGameLoadingText;
        if (str31 != null) {
            i79 = str31.hashCode();
        } else {
            i79 = 0;
        }
        int i138 = (i137 + i79) * 31;
        String str32 = this.yunGameQueueText;
        if (str32 != null) {
            i85 = str32.hashCode();
        } else {
            i85 = 0;
        }
        int i139 = (i138 + i85) * 31;
        String str33 = this.vaInitText;
        if (str33 != null) {
            i86 = str33.hashCode();
        } else {
            i86 = 0;
        }
        int i140 = (i139 + i86) * 31;
        String str34 = this.vaWifiLoadingText;
        if (str34 != null) {
            i87 = str34.hashCode();
        } else {
            i87 = 0;
        }
        int i141 = (i140 + i87) * 31;
        String str35 = this.vaWlanLoadingText;
        if (str35 != null) {
            i88 = str35.hashCode();
        } else {
            i88 = 0;
        }
        int i142 = (i141 + i88) * 31;
        String str36 = this.vaWifiStopText;
        if (str36 != null) {
            i89 = str36.hashCode();
        } else {
            i89 = 0;
        }
        int i143 = (i142 + i89) * 31;
        String str37 = this.vaWlanStopText;
        if (str37 != null) {
            i95 = str37.hashCode();
        } else {
            i95 = 0;
        }
        int i144 = (i143 + i95) * 31;
        String str38 = this.vaRestartText;
        if (str38 != null) {
            i96 = str38.hashCode();
        } else {
            i96 = 0;
        }
        int i145 = (i144 + i96) * 31;
        String str39 = this.vaRetainStopText;
        if (str39 != null) {
            i97 = str39.hashCode();
        } else {
            i97 = 0;
        }
        int i146 = (i145 + i97) * 31;
        String str40 = this.vaRetainStopLeftBtnText;
        if (str40 != null) {
            i98 = str40.hashCode();
        } else {
            i98 = 0;
        }
        int i147 = (i146 + i98) * 31;
        String str41 = this.vaRetainStopRightBtnText;
        if (str41 != null) {
            i99 = str41.hashCode();
        } else {
            i99 = 0;
        }
        int i148 = (i147 + i99) * 31;
        String str42 = this.vaRetainCancelText;
        if (str42 != null) {
            i100 = str42.hashCode();
        } else {
            i100 = 0;
        }
        int i149 = (i148 + i100) * 31;
        String str43 = this.vaRetainCancelLeftBtnText;
        if (str43 != null) {
            i101 = str43.hashCode();
        } else {
            i101 = 0;
        }
        int i150 = (i149 + i101) * 31;
        String str44 = this.vaRetainCancelRightBtnText;
        if (str44 != null) {
            i102 = str44.hashCode();
        } else {
            i102 = 0;
        }
        int i151 = (i150 + i102) * 31;
        String str45 = this.retainDialogBgUrl;
        if (str45 != null) {
            i103 = str45.hashCode();
        } else {
            i103 = 0;
        }
        int i152 = (i151 + i103) * 31;
        String str46 = this.dualChannelDownloadTipsTest;
        if (str46 != null) {
            i104 = str46.hashCode();
        } else {
            i104 = 0;
        }
        int i153 = (i152 + i104) * 31;
        String str47 = this.dualChannelDownloadLeftBtnTest;
        if (str47 != null) {
            i105 = str47.hashCode();
        } else {
            i105 = 0;
        }
        int i154 = (i153 + i105) * 31;
        String str48 = this.dualChannelDownloadRightBtnTest;
        if (str48 != null) {
            i106 = str48.hashCode();
        } else {
            i106 = 0;
        }
        int i155 = (i154 + i106) * 31;
        List<String> list = this.defaultDanmakuList;
        if (list != null) {
            i107 = list.hashCode();
        }
        return i155 + i107;
    }

    public final void setDefaultDanmakuList(@NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.defaultDanmakuList = list;
    }

    @NotNull
    public String toString() {
        return "VACustomTextConfig(retainStopText=" + this.retainStopText + ", retainStopLeftBtnText=" + this.retainStopLeftBtnText + ", retainStopRightBtnText=" + this.retainStopRightBtnText + ", retainCancelText=" + this.retainCancelText + ", retainCancelLeftBtnText=" + this.retainCancelLeftBtnText + ", retainCancelRightBtnText=" + this.retainCancelRightBtnText + ", wlanTipsInQueueText=" + this.wlanTipsInQueueText + ", wlanTipsInGameText=" + this.wlanTipsInGameText + ", wifiTipsInQueueText=" + this.wifiTipsInQueueText + ", wifiTipsInGameText=" + this.wifiTipsInGameText + ", tipsBtnText=" + this.tipsBtnText + ", foldedTipsText=" + this.foldedTipsText + ", wlanLoadingInQueueText=" + this.wlanLoadingInQueueText + ", wifiLoadingInQueueText=" + this.wifiLoadingInQueueText + ", wlanLoadingInGameText=" + this.wlanLoadingInGameText + ", wifiLoadingInGameText=" + this.wifiLoadingInGameText + ", loadingLeftBtnText=" + this.loadingLeftBtnText + ", loadingRightBtnText=" + this.loadingRightBtnText + ", wlanStopText=" + this.wlanStopText + ", wifiStopText=" + this.wifiStopText + ", stopLeftBtnText=" + this.stopLeftBtnText + ", stopRightBtnText=" + this.stopRightBtnText + ", restartText=" + this.restartText + ", restartBtnText=" + this.restartBtnText + ", autoRestartText=" + this.autoRestartText + ", errorText=" + this.errorText + ", errorBtnText=" + this.errorBtnText + ", authText=" + this.authText + ", authLeftBtnText=" + this.authLeftBtnText + ", authRightBtnText=" + this.authRightBtnText + ", yunGameLoadingText=" + this.yunGameLoadingText + ", yunGameQueueText=" + this.yunGameQueueText + ", vaInitText=" + this.vaInitText + ", vaWifiLoadingText=" + this.vaWifiLoadingText + ", vaWlanLoadingText=" + this.vaWlanLoadingText + ", vaWifiStopText=" + this.vaWifiStopText + ", vaWlanStopText=" + this.vaWlanStopText + ", vaRestartText=" + this.vaRestartText + ", vaRetainStopText=" + this.vaRetainStopText + ", vaRetainStopLeftBtnText=" + this.vaRetainStopLeftBtnText + ", vaRetainStopRightBtnText=" + this.vaRetainStopRightBtnText + ", vaRetainCancelText=" + this.vaRetainCancelText + ", vaRetainCancelLeftBtnText=" + this.vaRetainCancelLeftBtnText + ", vaRetainCancelRightBtnText=" + this.vaRetainCancelRightBtnText + ", retainDialogBgUrl=" + this.retainDialogBgUrl + ", dualChannelDownloadTipsTest=" + this.dualChannelDownloadTipsTest + ", dualChannelDownloadLeftBtnTest=" + this.dualChannelDownloadLeftBtnTest + ", dualChannelDownloadRightBtnTest=" + this.dualChannelDownloadRightBtnTest + ", defaultDanmakuList=" + this.defaultDanmakuList + ")";
    }

    public VACustomTextConfig(@NotNull String retainStopText, @NotNull String retainStopLeftBtnText, @NotNull String retainStopRightBtnText, @NotNull String retainCancelText, @NotNull String retainCancelLeftBtnText, @NotNull String retainCancelRightBtnText, @NotNull String wlanTipsInQueueText, @NotNull String wlanTipsInGameText, @NotNull String wifiTipsInQueueText, @NotNull String wifiTipsInGameText, @NotNull String tipsBtnText, @NotNull String foldedTipsText, @NotNull String wlanLoadingInQueueText, @NotNull String wifiLoadingInQueueText, @NotNull String wlanLoadingInGameText, @NotNull String wifiLoadingInGameText, @NotNull String loadingLeftBtnText, @NotNull String loadingRightBtnText, @NotNull String wlanStopText, @NotNull String wifiStopText, @NotNull String stopLeftBtnText, @NotNull String stopRightBtnText, @NotNull String restartText, @NotNull String restartBtnText, @NotNull String autoRestartText, @NotNull String errorText, @NotNull String errorBtnText, @NotNull String authText, @NotNull String authLeftBtnText, @NotNull String authRightBtnText, @NotNull String yunGameLoadingText, @NotNull String yunGameQueueText, @NotNull String vaInitText, @NotNull String vaWifiLoadingText, @NotNull String vaWlanLoadingText, @NotNull String vaWifiStopText, @NotNull String vaWlanStopText, @NotNull String vaRestartText, @NotNull String vaRetainStopText, @NotNull String vaRetainStopLeftBtnText, @NotNull String vaRetainStopRightBtnText, @NotNull String vaRetainCancelText, @NotNull String vaRetainCancelLeftBtnText, @NotNull String vaRetainCancelRightBtnText, @NotNull String retainDialogBgUrl, @NotNull String dualChannelDownloadTipsTest, @NotNull String dualChannelDownloadLeftBtnTest, @NotNull String dualChannelDownloadRightBtnTest, @NotNull List<String> defaultDanmakuList) {
        Intrinsics.checkParameterIsNotNull(retainStopText, "retainStopText");
        Intrinsics.checkParameterIsNotNull(retainStopLeftBtnText, "retainStopLeftBtnText");
        Intrinsics.checkParameterIsNotNull(retainStopRightBtnText, "retainStopRightBtnText");
        Intrinsics.checkParameterIsNotNull(retainCancelText, "retainCancelText");
        Intrinsics.checkParameterIsNotNull(retainCancelLeftBtnText, "retainCancelLeftBtnText");
        Intrinsics.checkParameterIsNotNull(retainCancelRightBtnText, "retainCancelRightBtnText");
        Intrinsics.checkParameterIsNotNull(wlanTipsInQueueText, "wlanTipsInQueueText");
        Intrinsics.checkParameterIsNotNull(wlanTipsInGameText, "wlanTipsInGameText");
        Intrinsics.checkParameterIsNotNull(wifiTipsInQueueText, "wifiTipsInQueueText");
        Intrinsics.checkParameterIsNotNull(wifiTipsInGameText, "wifiTipsInGameText");
        Intrinsics.checkParameterIsNotNull(tipsBtnText, "tipsBtnText");
        Intrinsics.checkParameterIsNotNull(foldedTipsText, "foldedTipsText");
        Intrinsics.checkParameterIsNotNull(wlanLoadingInQueueText, "wlanLoadingInQueueText");
        Intrinsics.checkParameterIsNotNull(wifiLoadingInQueueText, "wifiLoadingInQueueText");
        Intrinsics.checkParameterIsNotNull(wlanLoadingInGameText, "wlanLoadingInGameText");
        Intrinsics.checkParameterIsNotNull(wifiLoadingInGameText, "wifiLoadingInGameText");
        Intrinsics.checkParameterIsNotNull(loadingLeftBtnText, "loadingLeftBtnText");
        Intrinsics.checkParameterIsNotNull(loadingRightBtnText, "loadingRightBtnText");
        Intrinsics.checkParameterIsNotNull(wlanStopText, "wlanStopText");
        Intrinsics.checkParameterIsNotNull(wifiStopText, "wifiStopText");
        Intrinsics.checkParameterIsNotNull(stopLeftBtnText, "stopLeftBtnText");
        Intrinsics.checkParameterIsNotNull(stopRightBtnText, "stopRightBtnText");
        Intrinsics.checkParameterIsNotNull(restartText, "restartText");
        Intrinsics.checkParameterIsNotNull(restartBtnText, "restartBtnText");
        Intrinsics.checkParameterIsNotNull(autoRestartText, "autoRestartText");
        Intrinsics.checkParameterIsNotNull(errorText, "errorText");
        Intrinsics.checkParameterIsNotNull(errorBtnText, "errorBtnText");
        Intrinsics.checkParameterIsNotNull(authText, "authText");
        Intrinsics.checkParameterIsNotNull(authLeftBtnText, "authLeftBtnText");
        Intrinsics.checkParameterIsNotNull(authRightBtnText, "authRightBtnText");
        Intrinsics.checkParameterIsNotNull(yunGameLoadingText, "yunGameLoadingText");
        Intrinsics.checkParameterIsNotNull(yunGameQueueText, "yunGameQueueText");
        Intrinsics.checkParameterIsNotNull(vaInitText, "vaInitText");
        Intrinsics.checkParameterIsNotNull(vaWifiLoadingText, "vaWifiLoadingText");
        Intrinsics.checkParameterIsNotNull(vaWlanLoadingText, "vaWlanLoadingText");
        Intrinsics.checkParameterIsNotNull(vaWifiStopText, "vaWifiStopText");
        Intrinsics.checkParameterIsNotNull(vaWlanStopText, "vaWlanStopText");
        Intrinsics.checkParameterIsNotNull(vaRestartText, "vaRestartText");
        Intrinsics.checkParameterIsNotNull(vaRetainStopText, "vaRetainStopText");
        Intrinsics.checkParameterIsNotNull(vaRetainStopLeftBtnText, "vaRetainStopLeftBtnText");
        Intrinsics.checkParameterIsNotNull(vaRetainStopRightBtnText, "vaRetainStopRightBtnText");
        Intrinsics.checkParameterIsNotNull(vaRetainCancelText, "vaRetainCancelText");
        Intrinsics.checkParameterIsNotNull(vaRetainCancelLeftBtnText, "vaRetainCancelLeftBtnText");
        Intrinsics.checkParameterIsNotNull(vaRetainCancelRightBtnText, "vaRetainCancelRightBtnText");
        Intrinsics.checkParameterIsNotNull(retainDialogBgUrl, "retainDialogBgUrl");
        Intrinsics.checkParameterIsNotNull(dualChannelDownloadTipsTest, "dualChannelDownloadTipsTest");
        Intrinsics.checkParameterIsNotNull(dualChannelDownloadLeftBtnTest, "dualChannelDownloadLeftBtnTest");
        Intrinsics.checkParameterIsNotNull(dualChannelDownloadRightBtnTest, "dualChannelDownloadRightBtnTest");
        Intrinsics.checkParameterIsNotNull(defaultDanmakuList, "defaultDanmakuList");
        this.retainStopText = retainStopText;
        this.retainStopLeftBtnText = retainStopLeftBtnText;
        this.retainStopRightBtnText = retainStopRightBtnText;
        this.retainCancelText = retainCancelText;
        this.retainCancelLeftBtnText = retainCancelLeftBtnText;
        this.retainCancelRightBtnText = retainCancelRightBtnText;
        this.wlanTipsInQueueText = wlanTipsInQueueText;
        this.wlanTipsInGameText = wlanTipsInGameText;
        this.wifiTipsInQueueText = wifiTipsInQueueText;
        this.wifiTipsInGameText = wifiTipsInGameText;
        this.tipsBtnText = tipsBtnText;
        this.foldedTipsText = foldedTipsText;
        this.wlanLoadingInQueueText = wlanLoadingInQueueText;
        this.wifiLoadingInQueueText = wifiLoadingInQueueText;
        this.wlanLoadingInGameText = wlanLoadingInGameText;
        this.wifiLoadingInGameText = wifiLoadingInGameText;
        this.loadingLeftBtnText = loadingLeftBtnText;
        this.loadingRightBtnText = loadingRightBtnText;
        this.wlanStopText = wlanStopText;
        this.wifiStopText = wifiStopText;
        this.stopLeftBtnText = stopLeftBtnText;
        this.stopRightBtnText = stopRightBtnText;
        this.restartText = restartText;
        this.restartBtnText = restartBtnText;
        this.autoRestartText = autoRestartText;
        this.errorText = errorText;
        this.errorBtnText = errorBtnText;
        this.authText = authText;
        this.authLeftBtnText = authLeftBtnText;
        this.authRightBtnText = authRightBtnText;
        this.yunGameLoadingText = yunGameLoadingText;
        this.yunGameQueueText = yunGameQueueText;
        this.vaInitText = vaInitText;
        this.vaWifiLoadingText = vaWifiLoadingText;
        this.vaWlanLoadingText = vaWlanLoadingText;
        this.vaWifiStopText = vaWifiStopText;
        this.vaWlanStopText = vaWlanStopText;
        this.vaRestartText = vaRestartText;
        this.vaRetainStopText = vaRetainStopText;
        this.vaRetainStopLeftBtnText = vaRetainStopLeftBtnText;
        this.vaRetainStopRightBtnText = vaRetainStopRightBtnText;
        this.vaRetainCancelText = vaRetainCancelText;
        this.vaRetainCancelLeftBtnText = vaRetainCancelLeftBtnText;
        this.vaRetainCancelRightBtnText = vaRetainCancelRightBtnText;
        this.retainDialogBgUrl = retainDialogBgUrl;
        this.dualChannelDownloadTipsTest = dualChannelDownloadTipsTest;
        this.dualChannelDownloadLeftBtnTest = dualChannelDownloadLeftBtnTest;
        this.dualChannelDownloadRightBtnTest = dualChannelDownloadRightBtnTest;
        this.defaultDanmakuList = defaultDanmakuList;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ VACustomTextConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, String str36, String str37, String str38, String str39, String str40, String str41, String str42, String str43, String str44, String str45, String str46, String str47, String str48, List list, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(r2, r4, r6, r3, r5, r7, r8, r10, r9, r11, r12, r13, r14, r100, r15, r16, r17, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r18, r31, r98, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r47, r46, r1);
        String str49;
        List list2;
        String str50 = (i3 & 1) != 0 ? "\u90fd\u4e0b\u5230\u8fd9\u513f\u4e86, \u548b\u820d\u5f97\u8d70\u54c7\uff01\u9a6c\u4e0a\u80fd\u9886\u793c\u5305\u5566~" : str;
        String str51 = (i3 & 2) != 0 ? "\u4e0d\u4e86" : str2;
        String str52 = (i3 & 4) != 0 ? "\u7ee7\u7eed\u4e0b\u8f7d\u9886\u597d\u793c" : str3;
        String str53 = (i3 & 8) == 0 ? str4 : "\u90fd\u4e0b\u5230\u8fd9\u513f\u4e86, \u548b\u820d\u5f97\u8d70\u54c7\uff01\u9a6c\u4e0a\u80fd\u9886\u793c\u5305\u5566~";
        String str54 = (i3 & 16) == 0 ? str5 : "\u4e0d\u4e86";
        String str55 = (i3 & 32) == 0 ? str6 : "\u7ee7\u7eed\u4e0b\u8f7d\u9886\u597d\u793c";
        String str56 = (i3 & 64) != 0 ? "\u63a8\u8350\u52a0\u8f7d\u9ad8\u6e05\u8d44\u6e90\u5305\uff0c\u65e0\u9700\u6392\u961f\u5373\u5f00\u5373\u73a9" : str7;
        String str57 = (i3 & 128) != 0 ? "\u63a8\u8350\u52a0\u8f7d\u6c38\u4e45\u8d44\u6e90\uff0c\u7701\u6d41\u91cf\uff0c\u66f4\u9ad8\u6e05\uff01" : str8;
        String str58 = (i3 & 256) == 0 ? str9 : "\u63a8\u8350\u52a0\u8f7d\u9ad8\u6e05\u8d44\u6e90\u5305\uff0c\u65e0\u9700\u6392\u961f\u5373\u5f00\u5373\u73a9";
        String str59 = (i3 & 512) == 0 ? str10 : "\u63a8\u8350\u52a0\u8f7d\u6c38\u4e45\u8d44\u6e90\uff0c\u7701\u6d41\u91cf\uff0c\u66f4\u9ad8\u6e05\uff01";
        String str60 = (i3 & 1024) != 0 ? "\u7acb\u5373\u52a0\u8f7d" : str11;
        String str61 = (i3 & 2048) != 0 ? "\u8d44\u6e90" : str12;
        String str62 = (i3 & 4096) != 0 ? "\u9ad8\u6e05\u8d44\u6e90\u5305\u6b63\u5728\u52a0\u8f7d\u4e2d\uff0c\u8fdb\u5ea6%d%% (%s)..." : str13;
        String str63 = (i3 & 8192) != 0 ? "\u9ad8\u6e05\u8d44\u6e90\u5305\u6b63\u5728\u52a0\u8f7d\u4e2d\uff0c\u8fdb\u5ea6%d%% ..." : str14;
        String str64 = (i3 & 16384) != 0 ? "\u9ad8\u6e05\u8d44\u6e90\u5305\u6b63\u5728\u52a0\u8f7d\u4e2d\uff0c\u8fdb\u5ea6%d%% (%s)..." : str15;
        String str65 = (i3 & 32768) != 0 ? "\u9ad8\u6e05\u8d44\u6e90\u5305\u6b63\u5728\u52a0\u8f7d\u4e2d\uff0c\u8fdb\u5ea6%d%% ..." : str16;
        String str66 = (i3 & 65536) != 0 ? "\u53d6\u6d88" : str17;
        String str67 = (i3 & 131072) != 0 ? "\u6682\u505c" : str18;
        String str68 = (i3 & 262144) != 0 ? "\u9ad8\u6e05\u8d44\u6e90\u5305\u5df2\u6682\u505c\u52a0\u8f7d\uff0c\u8fdb\u5ea6%d%% (%s)..." : str19;
        String str69 = (i3 & 524288) != 0 ? "\u9ad8\u6e05\u8d44\u6e90\u5305\u5df2\u6682\u505c\u52a0\u8f7d\uff0c\u8fdb\u5ea6%d%% ..." : str20;
        String str70 = (i3 & 1048576) != 0 ? "\u53d6\u6d88" : str21;
        String str71 = (i3 & 2097152) != 0 ? "\u7ee7\u7eed" : str22;
        String str72 = (i3 & 4194304) != 0 ? "\u9ad8\u6e05\u8d44\u6e90\u5df2\u52a0\u8f7d\u5b8c\u6210\uff0c\u91cd\u542f\u4f53\u9a8c\u9ad8\u6e05\u7248\u672c" : str23;
        String str73 = (i3 & 8388608) != 0 ? "\u7acb\u5373\u91cd\u542f" : str24;
        String str74 = (i3 & 16777216) != 0 ? "\u9ad8\u6e05\u8d44\u6e90\u5df2\u52a0\u8f7d\u5b8c\u6210\uff0c\u6b63\u5728\u91cd\u542f\u4f53\u9a8c\u9ad8\u6e05\u7248\u672c..." : str25;
        String str75 = (i3 & 33554432) != 0 ? "\u51fa\u9519\u4e86\uff0c\u8bf7\u91cd\u65b0\u5c1d\u8bd5" : str26;
        String str76 = (i3 & 67108864) != 0 ? "\u91cd\u8bd5" : str27;
        String str77 = (i3 & 134217728) != 0 ? "\u786e\u5b9a\u8981\u9000\u51fa\u6e38\u620f\u5417\uff1f" : str28;
        String str78 = (i3 & 268435456) != 0 ? "\u786e\u5b9a" : str29;
        String str79 = (i3 & 536870912) == 0 ? str30 : "\u53d6\u6d88";
        String str80 = (i3 & 1073741824) != 0 ? "\u52a0\u8f7d\u4e2d%d%%" : str31;
        String str81 = (i3 & Integer.MIN_VALUE) != 0 ? "\u6e38\u620f\u592a\u706b\u7206\u5566\uff0c" : str32;
        String str82 = (i16 & 1) != 0 ? "\u7545\u4eab\u201c\u8239\u65b0\u201d\u519c\u573a\u4f53\u9a8c\uff0c\u7b49\u4e0d\u4e86\u4e00\u70b9\uff01" : str33;
        String str83 = (i16 & 2) != 0 ? "\u519c\u573a\u52aa\u529b\u66f4\u65b0\u4e2d\uff0c\u8fdb\u5ea6%d%%" : str34;
        String str84 = (i16 & 4) != 0 ? "\u661f\u5b9d\u519c\u573a\u8d44\u6e90\u66f4\u65b0\u4e2d\uff0c\u8fdb\u5ea6%d%% (%s)" : str35;
        String str85 = (i16 & 8) != 0 ? "\u519c\u573a\u66f4\u65b0\u5df2\u6682\u505c\uff0c\u8fdb\u5ea6%d%%" : str36;
        String str86 = (i16 & 16) != 0 ? "\u519c\u573a\u66f4\u65b0\u5df2\u6682\u505c\uff0c\u8fdb\u5ea6%d%% (%s)" : str37;
        String str87 = (i16 & 32) != 0 ? "\u5df2\u4e3a\u661f\u5b9d\u5b8c\u6210\u66f4\u65b0\uff0c\u91cd\u542f\u7ee7\u7eed\u5077\u83dc\u4e4b\u65c5\u5427\uff01" : str38;
        String str88 = (i16 & 64) != 0 ? "\u661f\u5b9d\u9a6c\u4e0a\u53d8\u201c\u65b0\u201d\u5b9d\uff0c\u518d\u7b49\u4e00\u4f1a\u513f\u53ed\uff01" : str39;
        String str89 = str81;
        String str90 = (i16 & 128) != 0 ? "\u72e0\u5fc3\u62d2\u7edd" : str40;
        String str91 = (i16 & 256) != 0 ? "\u7ed9\u4e2a\u673a\u4f1a" : str41;
        String str92 = (i16 & 512) != 0 ? "\u53ea\u5dee\u4e00\u70b9\u70b9\u4e86\uff0c\u6c42\u6c42\u518d\u7ed9\u661f\u5b9d\u4e00\u70b9\u65f6\u95f4" : str42;
        String str93 = (i16 & 1024) != 0 ? "\u72e0\u5fc3\u62d2\u7edd" : str43;
        String str94 = (i16 & 2048) != 0 ? "\u7ed9\u4e2a\u673a\u4f1a" : str44;
        String str95 = (i16 & 4096) != 0 ? "https://minigame.gtimg.cn/game/static/letsgo/e6d07ba229c0060ecd366ceb0a56fa3a.png" : str45;
        String str96 = (i16 & 8192) != 0 ? "\u5f53\u524d\u4e0b\u8f7d\u901f\u5ea6\u8f83\u6162\uff0c\u5efa\u8bae\u5f00\u542fWiFi+\u6d41\u91cf\u53cc\u901a\u9053\u9ad8\u901f\u4e0b\u8f7d" : str46;
        String str97 = (i16 & 16384) != 0 ? "\u6682\u4e0d\u5f00\u542f" : str47;
        String str98 = (i16 & 32768) != 0 ? "\u7acb\u5373\u52a0\u901f" : str48;
        if ((i16 & 65536) != 0) {
            ArrayList arrayList = new ArrayList();
            str49 = str97;
            arrayList.add("\u5468\u672b\u4ea7\u91cf\u7ffb\u500d\uff0c\u9002\u5408\u79cd\u690d\u91d1\u5e01\u578b\u4f5c\u7269");
            arrayList.add("\u6709\u7684\u4f5c\u7269\u4ea7\u51fa\u91d1\u5e01\u591a\uff0c\u6709\u7684\u4ea7\u51fa\u7ecf\u9a8c\u591a");
            arrayList.add("0\u70b9\u81f38\u70b9\u4e0d\u80fd\u62ff\u53d6\uff0c\u8fd9\u6bb5\u65f6\u95f4\u4f60\u7684\u4f5c\u7269\u5f88\u5b89\u5168");
            arrayList.add("\u5199\u53e5\u6e29\u99a8\u7684\u201c\u5bc4\u8bed\u201d\uff0c\u8ba9\u597d\u53cb\u5e2e\u4f60\u591a\u591a\u7948\u798f\u5427");
            arrayList.add("\u7a3b\u8349\u4eba\u5904\u53ef\u4ee5\u7559\u8a00\uff0c\u5199\u4e0b\u60f3\u8bf4\u7684\u8bdd\u5427");
            arrayList.add("\u591a\u591a\u62dc\u8bbf\u964c\u751f\u4eba\u7684\u519c\u573a\uff0c\u80fd\u627e\u5230\u4f18\u8d28\u7684\u79cd\u83dc\u642d\u5b50");
            arrayList.add("\u804a\u5929\u9891\u9053\u53d1\u9001\u201c\u519c\u573a\u597d\u53cbdd\"\uff0c\u80fd\u6536\u83b7\u8d85\u591a\u519c\u573a\u597d\u53cb");
            arrayList.add("\u901a\u8fc7\u65f6\u949f\u53ef\u4ee5\u9009\u62e9\u6210\u719f\u65f6\u95f4\u7684\u663e\u793a\u65b9\u5f0f");
            arrayList.add("\u5347\u7ea7\u644a\u4f4d\u80fd\u628a\u4f5c\u7269\u5356\u51fa\u66f4\u9ad8\u7684\u4ef7\u683c");
            arrayList.add("\u5347\u7ea7\u519c\u573a\u5c0f\u5c4b\u80fd\u89e3\u9501\u65b0\u7684\u4f5c\u7269\u3001\u589e\u52a0\u53ef\u5f00\u57a6\u7684\u571f\u5730");
            arrayList.add("\u519c\u573a\u5c0f\u5c4b\u5230\u8fbe\u89c4\u5b9a\u7b49\u7ea7\u53ef\u4ee5\u89e3\u9501\u7267\u573a\u3001\u9493\u9c7c\u7b49\u65b0\u73a9\u6cd5");
            arrayList.add("\u53bb\u597d\u53cb\u7684\u519c\u573a\u53ef\u4ee5\u62ff\u53d6\u6210\u719f\u7684\u4f5c\u7269\uff0c\u4f46\u6bcf\u5929\u6709\u6b21\u6570\u9650\u5236\u54e6");
            list2 = arrayList;
        } else {
            str49 = str97;
            list2 = list;
        }
    }
}
