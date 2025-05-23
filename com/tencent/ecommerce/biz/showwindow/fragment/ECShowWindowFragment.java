package com.tencent.ecommerce.biz.showwindow.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cg0.a;
import ck0.Category;
import ck0.Product;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.rmonitor.service.ECRMonitorManager;
import com.tencent.ecommerce.base.router.api.IECRouterLauncher;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.component.ECBaseRecyclerView;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.biz.common.ECMsgBox;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.showwindow.ui.adapter.ECShowWindowProductListAdapter;
import com.tencent.ecommerce.biz.showwindow.ui.dialog.ECShowWindowDeleteConfirmDialog;
import com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel;
import com.tencent.ecommerce.biz.util.ECDebugUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import cooperation.qzone.QzoneIPCModule;
import ei0.c;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.Constants;
import org.json.JSONObject;
import ri0.ECAddProductToWindowEvent;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b,\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t*\u0002\u00ee\u0001\u0018\u0000 \u00f4\u00012\u00020\u0001:\u0002\u00f5\u0001B\t\u00a2\u0006\u0006\b\u00f2\u0001\u0010\u00f3\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u001a\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010!\u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020\nH\u0002J\b\u0010#\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\nH\u0002J\u0010\u0010&\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010'\u001a\u00020\nH\u0002J\b\u0010(\u001a\u00020\nH\u0002J\b\u0010)\u001a\u00020\nH\u0002J\b\u0010*\u001a\u00020\nH\u0002J\b\u0010+\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\nH\u0002J\b\u0010-\u001a\u00020\nH\u0002J\b\u0010.\u001a\u00020\nH\u0002J\b\u0010/\u001a\u00020\nH\u0002J\b\u00100\u001a\u00020\nH\u0002J\b\u00101\u001a\u00020\nH\u0002J\b\u00102\u001a\u00020\nH\u0002J\b\u00103\u001a\u00020\nH\u0002J\b\u00104\u001a\u00020\nH\u0002J\u0010\u00106\u001a\u00020\n2\u0006\u00105\u001a\u00020\u0002H\u0002J\b\u00107\u001a\u00020\nH\u0002J\b\u00108\u001a\u00020\nH\u0002J\u0010\u00109\u001a\u00020\n2\u0006\u00105\u001a\u00020\u0002H\u0002J\b\u0010:\u001a\u00020\nH\u0002J\b\u0010;\u001a\u00020\nH\u0002J\b\u0010<\u001a\u00020\nH\u0002J\b\u0010=\u001a\u00020\nH\u0002J\b\u0010>\u001a\u00020\nH\u0002J\b\u0010?\u001a\u00020\nH\u0002J\b\u0010@\u001a\u00020\nH\u0002J\b\u0010A\u001a\u00020\nH\u0002J\b\u0010B\u001a\u00020\nH\u0002J\b\u0010C\u001a\u00020\nH\u0002J\u0010\u0010F\u001a\u00020\n2\u0006\u0010E\u001a\u00020DH\u0002J&\u0010J\u001a\u00020\n2\b\b\u0002\u0010G\u001a\u00020\u00172\b\b\u0002\u0010H\u001a\u00020\u00022\b\b\u0002\u0010I\u001a\u00020\u0002H\u0002J\b\u0010K\u001a\u00020\u0002H\u0002J\b\u0010L\u001a\u00020\nH\u0002J\u0012\u0010N\u001a\u00020\u00172\b\u0010M\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010O\u001a\u00020\u0017H\u0002J\b\u0010P\u001a\u00020\u0002H\u0002J\b\u0010Q\u001a\u00020\u0002H\u0002J\b\u0010R\u001a\u00020\u0002H\u0002J\u0018\u0010V\u001a\u00020\n2\u0006\u0010S\u001a\u00020\u00022\u0006\u0010U\u001a\u00020TH\u0002R\u0016\u0010S\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010ZR\u0016\u0010M\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010ZR\u0016\u0010a\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010`R\u0016\u0010e\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010ZR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010ZR\u0016\u0010m\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010ZR\u0016\u0010n\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010ZR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010y\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010}\u001a\u00020z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010\u0081\u0001\u001a\u00020~8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001a\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001a\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010\u008d\u0001\u001a\u00030\u008a\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001a\u0010\u0091\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0018\u0010\u0093\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0092\u0001\u0010xR\u0018\u0010\u0095\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0094\u0001\u0010xR\u0018\u0010\u0097\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0096\u0001\u0010xR\u001a\u0010\u009b\u0001\u001a\u00030\u0098\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0018\u0010\u009d\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u009c\u0001\u0010xR\u0018\u0010\u009f\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u009e\u0001\u0010xR\u001a\u0010\u00a3\u0001\u001a\u00030\u00a0\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u001a\u0010\u00a7\u0001\u001a\u00030\u00a4\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a5\u0001\u0010\u00a6\u0001R\u001a\u0010\u00a9\u0001\u001a\u00030\u00a4\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u00a6\u0001R\u001a\u0010\u00ab\u0001\u001a\u00030\u00a0\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00aa\u0001\u0010\u00a2\u0001R\u001a\u0010\u00ad\u0001\u001a\u00030\u00a4\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00ac\u0001\u0010\u00a6\u0001R\u0018\u0010\u00af\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u00ae\u0001\u0010xR\u0018\u0010\u00b1\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u00b0\u0001\u0010xR\u001a\u0010\u00b3\u0001\u001a\u00030\u00a4\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b2\u0001\u0010\u00a6\u0001R\u001a\u0010\u00b5\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b4\u0001\u0010\u0090\u0001R\u0018\u0010\u00b7\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u00b6\u0001\u0010xR\u001a\u0010\u00b9\u0001\u001a\u00030\u00a4\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b8\u0001\u0010\u00a6\u0001R\u001a\u0010\u00bb\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00ba\u0001\u0010\u0090\u0001R\u001a\u0010\u00bd\u0001\u001a\u00030\u00a4\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00bc\u0001\u0010\u00a6\u0001R\u001a\u0010\u00bf\u0001\u001a\u00030\u00a4\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00be\u0001\u0010\u00a6\u0001R\u001a\u0010\u00c1\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c0\u0001\u0010\u0090\u0001R\u001a\u0010\u00c3\u0001\u001a\u00030\u0098\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c2\u0001\u0010\u009a\u0001R\u001a\u0010\u00c5\u0001\u001a\u00030\u00a0\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c4\u0001\u0010\u00a2\u0001R\u001a\u0010\u00c7\u0001\u001a\u00030\u0098\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c6\u0001\u0010\u009a\u0001R\u001a\u0010\u00c9\u0001\u001a\u00030\u0098\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c8\u0001\u0010\u009a\u0001R\u001a\u0010\u00cd\u0001\u001a\u00030\u00ca\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00cb\u0001\u0010\u00cc\u0001R\u001a\u0010\u00cf\u0001\u001a\u00030\u00a4\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00ce\u0001\u0010\u00a6\u0001R\u001a\u0010\u00d1\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00d0\u0001\u0010\u0090\u0001R\u0018\u0010\u00d3\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u00d2\u0001\u0010xR\u001a\u0010\u00d5\u0001\u001a\u00030\u0098\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00d4\u0001\u0010\u009a\u0001R\u001a\u0010\u00d7\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00d6\u0001\u0010\u0090\u0001R\u0018\u0010\u00d9\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u00d8\u0001\u0010xR\u001a\u0010\u00db\u0001\u001a\u00030\u00a4\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00da\u0001\u0010\u00a6\u0001R\u001a\u0010\u00dd\u0001\u001a\u00030\u00a4\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00dc\u0001\u0010\u00a6\u0001R\u001a\u0010\u00e1\u0001\u001a\u00030\u00de\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00df\u0001\u0010\u00e0\u0001R\u001c\u0010\u00e5\u0001\u001a\u0005\u0018\u00010\u00e2\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e3\u0001\u0010\u00e4\u0001R\u0018\u0010\u00e7\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00e6\u0001\u0010XR\u0018\u0010\u00eb\u0001\u001a\u00030\u00e8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00e9\u0001\u0010\u00ea\u0001R\u0018\u0010\u00ed\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00ec\u0001\u0010XR\u0018\u0010\u00f1\u0001\u001a\u00030\u00ee\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ef\u0001\u0010\u00f0\u0001\u00a8\u0006\u00f6\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/fragment/ECShowWindowFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "Dh", "Eh", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "getContentLayoutId", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onDestroyView", "", "getBusinessDescription", "onBackPressed", "initArguments", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "bj", "Vi", "Xi", "initViews", "Ui", "Qi", "Yi", "hj", "Wi", "Zi", "cj", "Jj", "aj", "Aj", "Cj", "Ej", "Gj", "Dj", "Fj", "Bj", "qj", "vj", "wj", "jj", "rj", "isVisible", "Ij", "nj", "mj", "Kj", "lj", "uj", "tj", "kj", "xj", "oj", "sj", "pj", "Hj", "Ri", "", "bottomMargin", "Oi", "cookie", FeedManager.LOAD_MORE, "firstScreen", "yj", "gj", "Pi", "mediaName", "Si", "Ti", "ej", "dj", "fj", "isMaster", "Lck0/c;", "product", "ij", "P", "Z", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "mediaId", BdhLogUtil.LogTag.Tag_Req, "sellerUin", ExifInterface.LATITUDE_SOUTH, "T", "I", "windowType", "U", "source", "V", "deliverProductCallbackId", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "W", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "deliverProductCallback", "X", WadlProxyConsts.CHANNEL, "Y", GetAdInfoRequest.SOURCE_FROM, "liveUserId", "", "a0", "J", "liveRoomId", "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECShowWindowViewModel;", "b0", "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECShowWindowViewModel;", "viewModel", "c0", "Landroid/view/View;", "containerView", "Lcom/tencent/ecommerce/biz/common/ECMsgBox;", "d0", "Lcom/tencent/ecommerce/biz/common/ECMsgBox;", "msgBox", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "e0", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "productListView", "Lcom/tencent/ecommerce/biz/showwindow/ui/adapter/ECShowWindowProductListAdapter;", "f0", "Lcom/tencent/ecommerce/biz/showwindow/ui/adapter/ECShowWindowProductListAdapter;", "productListAdapter", "Landroid/widget/GridView;", "g0", "Landroid/widget/GridView;", "categoryGridView", "Lcom/tencent/ecommerce/biz/showwindow/ui/adapter/b;", "h0", "Lcom/tencent/ecommerce/biz/showwindow/ui/adapter/b;", "categoryListAdapter", "Landroid/widget/ImageView;", "i0", "Landroid/widget/ImageView;", "backButton", "j0", "finishedButton", "k0", "addProductButton", "l0", "addProductButtonOld", "Landroid/widget/FrameLayout;", "m0", "Landroid/widget/FrameLayout;", "manageBar", "n0", "manageButton", "o0", "searchBarContainer", "Landroid/widget/LinearLayout;", "p0", "Landroid/widget/LinearLayout;", "searchBar", "Landroid/widget/TextView;", "q0", "Landroid/widget/TextView;", "searchTextView", "r0", "selectedAllNumberTextView", "s0", "searchIconAndText", "t0", "searchCancel", "u0", "editToolBar", "v0", "setTopButton", "w0", "setTopButtonText", "x0", "setTopButtonIcon", "y0", "deleteButton", "z0", "deleteButtonText", "A0", "deleteButtonIcon", "B0", "selectedNumberTextView", "C0", "selectedCategoryTextView", "D0", "categoryIcon", "E0", "categoryPanel", "F0", "categoryButton", "G0", "deleteConfirmDialogContainer", "H0", "emptyContainer", "Lcom/tencent/pts/core/PTSComposer;", "I0", "Lcom/tencent/pts/core/PTSComposer;", "emptyPtsComposer", "J0", "titleTextView", "K0", "selectAllButton", "L0", "isLoadingFooter", "M0", "loadingPage", "N0", "loadingIcon", "O0", "liveEditToolBar", "P0", "liveSelectedNumberTextView", "Q0", "liveConfirmBtn", "Landroid/widget/RelativeLayout;", "R0", "Landroid/widget/RelativeLayout;", "animaContainer", "Lcom/tencent/ecommerce/biz/showwindow/ui/dialog/ECShowWindowDeleteConfirmDialog;", "S0", "Lcom/tencent/ecommerce/biz/showwindow/ui/dialog/ECShowWindowDeleteConfirmDialog;", "deleteConfirmDialog", "T0", "isCurrentNightMode", "Lcom/tencent/ecommerce/base/report/service/k;", "U0", "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTime", "V0", "isProductListEmpty", "com/tencent/ecommerce/biz/showwindow/fragment/ECShowWindowFragment$b", "W0", "Lcom/tencent/ecommerce/biz/showwindow/fragment/ECShowWindowFragment$b;", "addProductEventObserve", "<init>", "()V", "X0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShowWindowFragment extends ECBaseFragment {

    /* renamed from: X0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A0, reason: from kotlin metadata */
    private ImageView deleteButtonIcon;

    /* renamed from: B0, reason: from kotlin metadata */
    private TextView selectedNumberTextView;

    /* renamed from: C0, reason: from kotlin metadata */
    private TextView selectedCategoryTextView;

    /* renamed from: D0, reason: from kotlin metadata */
    private ImageView categoryIcon;

    /* renamed from: E0, reason: from kotlin metadata */
    private FrameLayout categoryPanel;

    /* renamed from: F0, reason: from kotlin metadata */
    private LinearLayout categoryButton;

    /* renamed from: G0, reason: from kotlin metadata */
    private FrameLayout deleteConfirmDialogContainer;

    /* renamed from: H0, reason: from kotlin metadata */
    private FrameLayout emptyContainer;

    /* renamed from: I0, reason: from kotlin metadata */
    private PTSComposer emptyPtsComposer;

    /* renamed from: J0, reason: from kotlin metadata */
    private TextView titleTextView;

    /* renamed from: K0, reason: from kotlin metadata */
    private ImageView selectAllButton;

    /* renamed from: L0, reason: from kotlin metadata */
    private View isLoadingFooter;

    /* renamed from: M0, reason: from kotlin metadata */
    private FrameLayout loadingPage;

    /* renamed from: N0, reason: from kotlin metadata */
    private ImageView loadingIcon;

    /* renamed from: O0, reason: from kotlin metadata */
    private View liveEditToolBar;

    /* renamed from: P0, reason: from kotlin metadata */
    private TextView liveSelectedNumberTextView;

    /* renamed from: Q0, reason: from kotlin metadata */
    private TextView liveConfirmBtn;

    /* renamed from: R0, reason: from kotlin metadata */
    private RelativeLayout animaContainer;

    /* renamed from: S0, reason: from kotlin metadata */
    private ECShowWindowDeleteConfirmDialog deleteConfirmDialog;

    /* renamed from: T0, reason: from kotlin metadata */
    private boolean isCurrentNightMode;

    /* renamed from: U, reason: from kotlin metadata */
    private int source;

    /* renamed from: W, reason: from kotlin metadata */
    private IECSchemeCallback deliverProductCallback;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private long liveRoomId;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ECShowWindowViewModel viewModel;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private View containerView;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private ECMsgBox msgBox;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private ECBaseRecyclerView productListView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private ECShowWindowProductListAdapter productListAdapter;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private GridView categoryGridView;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.ecommerce.biz.showwindow.ui.adapter.b categoryListAdapter;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private ImageView backButton;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private View finishedButton;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private View addProductButton;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private View addProductButtonOld;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private FrameLayout manageBar;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private View manageButton;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private View searchBarContainer;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout searchBar;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private TextView searchTextView;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private TextView selectedAllNumberTextView;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout searchIconAndText;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private TextView searchCancel;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private View editToolBar;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private View setTopButton;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private TextView setTopButtonText;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private ImageView setTopButtonIcon;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private View deleteButton;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private TextView deleteButtonText;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isMaster = true;

    /* renamed from: Q, reason: from kotlin metadata */
    private String mediaId = "";

    /* renamed from: R, reason: from kotlin metadata */
    private String sellerUin = "";

    /* renamed from: S, reason: from kotlin metadata */
    private String mediaName = "";

    /* renamed from: T, reason: from kotlin metadata */
    private int windowType = 1;

    /* renamed from: V, reason: from kotlin metadata */
    private String deliverProductCallbackId = "";

    /* renamed from: X, reason: from kotlin metadata */
    private String channel = "";

    /* renamed from: Y, reason: from kotlin metadata */
    private String sourceFrom = "";

    /* renamed from: Z, reason: from kotlin metadata */
    private String liveUserId = "";

    /* renamed from: U0, reason: from kotlin metadata */
    private final com.tencent.ecommerce.base.report.service.k showPageCostTime = new com.tencent.ecommerce.base.report.service.k(ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_WINDOW);

    /* renamed from: V0, reason: from kotlin metadata */
    private boolean isProductListEmpty = true;

    /* renamed from: W0, reason: from kotlin metadata */
    private final b addProductEventObserve = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/fragment/ECShowWindowFragment$a;", "", "", "windowType", "", "a", "", "AGR_SELLER_UIN", "Ljava/lang/String;", "ARG_LIVE_ROOM_ID", "ARG_LIVE_USER_ID", "ARG_MEDIA_ID", "ARG_MEDIA_NAME", "ARG_WINDOW_TYPE", "DEFAULT_MEDIA_NAME", "EMPTY_PAGE_NAME", "LOAD_MORE_PRE_COUNT", "I", "TAG", "TITLE_MAX_LENGTH", "WINDOW_TYPE_DEFAULT", "WINDOW_TYPE_HONOR_OF_KINGS", "WINDOW_TYPE_LIVE", "WINDOW_TYPE_LIVE_SHOP", "WINDOW_TYPE_UNKNOWN", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.showwindow.fragment.ECShowWindowFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean a(int windowType) {
            if (windowType != 3 && windowType != 4) {
                return false;
            }
            return true;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class aa<T> implements Observer<Boolean> {
        aa() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            a.b("ECShowWindowFragment", "registerNoMoreDataLiveDataObserver " + bool);
            ECShowWindowFragment.mi(ECShowWindowFragment.this).z0(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class ab<T> implements Observer<String> {
        ab() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(String str) {
            if (TextUtils.isEmpty(str)) {
                if (ECShowWindowFragment.this.fj()) {
                    ECShowWindowFragment.qi(ECShowWindowFragment.this).setVisibility(8);
                }
                ECShowWindowFragment.pi(ECShowWindowFragment.this).setGravity(1);
                ECShowWindowFragment.ri(ECShowWindowFragment.this).setText("");
                TextView textView = (TextView) ECShowWindowFragment.this.yh().findViewById(R.id.o1u);
                textView.setText(textView.getResources().getString(R.string.ws7));
                textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6962z));
                return;
            }
            ECShowWindowFragment.qi(ECShowWindowFragment.this).setVisibility(0);
            ECShowWindowFragment.pi(ECShowWindowFragment.this).setGravity(8388611);
            ECShowWindowFragment.ri(ECShowWindowFragment.this).setText(str);
            TextView textView2 = (TextView) ECShowWindowFragment.this.yh().findViewById(R.id.o1u);
            textView2.setText(str);
            textView2.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6942x));
            if (ECShowWindowFragment.this.fj()) {
                ECShowWindowFragment.qi(ECShowWindowFragment.this).setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lck0/c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class ac<T> implements Observer<List<? extends Product>> {
        ac() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<Product> list) {
            if (list.size() == 1) {
                TextView wi5 = ECShowWindowFragment.wi(ECShowWindowFragment.this);
                ECSkin eCSkin = ECSkin.INSTANCE;
                wi5.setTextColor(eCSkin.getColor(R.color.f6942x));
                ECShowWindowFragment.vi(ECShowWindowFragment.this).setImageDrawable(eCSkin.getDrawable(R.drawable.eq7));
            } else {
                TextView wi6 = ECShowWindowFragment.wi(ECShowWindowFragment.this);
                ECSkin eCSkin2 = ECSkin.INSTANCE;
                wi6.setTextColor(eCSkin2.getColor(R.color.f6922v));
                ECShowWindowFragment.vi(ECShowWindowFragment.this).setImageDrawable(eCSkin2.getDrawable(R.drawable.eq6));
            }
            if (list.isEmpty()) {
                ECShowWindowFragment.Yh(ECShowWindowFragment.this).setTextColor(ECShowWindowFragment.this.requireContext().getResources().getColor(R.color.f6922v));
                ECShowWindowFragment.Xh(ECShowWindowFragment.this).setImageResource(R.drawable.ea9);
            } else {
                ECShowWindowFragment.Yh(ECShowWindowFragment.this).setTextColor(ECShowWindowFragment.this.requireContext().getResources().getColor(R.color.f69730));
                ECShowWindowFragment.Xh(ECShowWindowFragment.this).setImageResource(R.drawable.eb7);
            }
            if (list.size() <= ECShowWindowFragment.mi(ECShowWindowFragment.this).getNUM_BACKGOURND_ICON() && (!list.isEmpty())) {
                Context context = ECShowWindowFragment.this.getContext();
                ECShowWindowFragment.ui(ECShowWindowFragment.this).setText(context != null ? context.getString(R.string.wsl, Integer.valueOf(list.size())) : null);
                ECShowWindowFragment.ui(ECShowWindowFragment.this).setTextColor(ECShowWindowFragment.this.requireContext().getResources().getColor(R.color.f6922v));
                ECShowWindowFragment.ui(ECShowWindowFragment.this).setVisibility(0);
            }
            if (list.isEmpty()) {
                ECShowWindowFragment.ui(ECShowWindowFragment.this).setVisibility(8);
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class ad<T> implements Observer<T> {
        public ad() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            int intValue = ((Number) t16).intValue();
            TextView textView = (TextView) ECShowWindowFragment.this.yh().findViewById(R.id.oes);
            StringBuilder sb5 = new StringBuilder();
            sb5.append('(');
            sb5.append(intValue);
            sb5.append(')');
            textView.setText(sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class ae<T> implements Observer<String> {
        ae() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(String str) {
            ECShowWindowFragment.yi(ECShowWindowFragment.this).setText(ECShowWindowFragment.this.requireContext().getResources().getString(R.string.wun, ECShowWindowFragment.this.Si(str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_LONG_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class af implements View.OnLongClickListener {

        /* renamed from: d, reason: collision with root package name */
        public static final af f104601d = new af();

        af() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            String str = "mqqapi://ecommerce/open?target=7&media_id=" + com.tencent.ecommerce.biz.register.b.f103963a.a();
            ECScheme.g(str, null, 2, null);
            a.b("ECShowWindowFragment", "[setupTitleLongClickListener] scheme = " + str);
            EventCollector.getInstance().onViewLongClicked(view);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class ag implements View.OnClickListener {
        ag() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Boolean value = ECShowWindowFragment.zi(ECShowWindowFragment.this).s2().getValue();
            if (value == null) {
                value = Boolean.FALSE;
            }
            if (!value.booleanValue()) {
                Boolean value2 = ECShowWindowFragment.zi(ECShowWindowFragment.this).p2().getValue();
                if (value2 == null) {
                    value2 = Boolean.FALSE;
                }
                ECShowWindowFragment.zi(ECShowWindowFragment.this).m3(!value2.booleanValue());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class ah implements View.OnClickListener {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/showwindow/fragment/ECShowWindowFragment$setupDeleteButtonClickListener$1$1$1", "Lcom/tencent/ecommerce/biz/showwindow/ui/dialog/ECShowWindowDeleteConfirmDialog$IButtonClickListener;", "Landroid/view/View;", "view", "", "onNegativeBtnClick", "onPositiveBtnClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a implements ECShowWindowDeleteConfirmDialog.IButtonClickListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ List f104605b;

            a(List list) {
                this.f104605b = list;
            }

            @Override // com.tencent.ecommerce.biz.showwindow.ui.dialog.ECShowWindowDeleteConfirmDialog.IButtonClickListener
            public void onNegativeBtnClick(View view) {
                ECShowWindowFragment.ai(ECShowWindowFragment.this).setVisibility(8);
                fj0.b.f399473a.d(ECShowWindowFragment.this.channel, 2);
            }

            @Override // com.tencent.ecommerce.biz.showwindow.ui.dialog.ECShowWindowDeleteConfirmDialog.IButtonClickListener
            public void onPositiveBtnClick(View view) {
                ECShowWindowFragment.ai(ECShowWindowFragment.this).setVisibility(8);
                ECShowWindowFragment.zi(ECShowWindowFragment.this).i2(this.f104605b);
                String valueOf = String.valueOf(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount());
                com.tencent.ecommerce.biz.hr.module.e.f102613b.c(valueOf + "_selectProductsFirstPageCacheKey");
                ECShowWindowFragment.zi(ECShowWindowFragment.this).f2(this.f104605b);
                fj0.b.f399473a.d(ECShowWindowFragment.this.channel, 1);
            }
        }

        ah() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            List<Product> value;
            FragmentManager supportFragmentManager;
            FragmentTransaction beginTransaction;
            List<Product> value2 = ECShowWindowFragment.zi(ECShowWindowFragment.this).C2().getValue();
            if ((value2 != null ? value2.size() : 0) > 0 && (value = ECShowWindowFragment.zi(ECShowWindowFragment.this).C2().getValue()) != null) {
                if (ECShowWindowFragment.this.deleteConfirmDialog == null) {
                    ECShowWindowFragment.this.deleteConfirmDialog = new ECShowWindowDeleteConfirmDialog();
                    ECShowWindowDeleteConfirmDialog eCShowWindowDeleteConfirmDialog = ECShowWindowFragment.this.deleteConfirmDialog;
                    if (eCShowWindowDeleteConfirmDialog != null) {
                        eCShowWindowDeleteConfirmDialog.Mh(new a(value));
                    }
                    FragmentActivity activity = ECShowWindowFragment.this.getActivity();
                    if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null) {
                        ECShowWindowDeleteConfirmDialog eCShowWindowDeleteConfirmDialog2 = ECShowWindowFragment.this.deleteConfirmDialog;
                        Intrinsics.checkNotNull(eCShowWindowDeleteConfirmDialog2);
                        FragmentTransaction add = beginTransaction.add(R.id.nza, eCShowWindowDeleteConfirmDialog2);
                        if (add != null) {
                            add.commit();
                        }
                    }
                }
                ECShowWindowFragment.ai(ECShowWindowFragment.this).setVisibility(0);
                fj0.b.f399473a.c(ECShowWindowFragment.this.channel, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class ai implements View.OnClickListener {
        ai() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Context context = ECShowWindowFragment.this.getContext();
            if (context != null) {
                Bundle bundle = new Bundle();
                bundle.putString("arg_query_string", ECShowWindowFragment.ri(ECShowWindowFragment.this).getText().toString());
                bundle.putString("arg_title_text", ECShowWindowFragment.this.Ti());
                IECRouterLauncher a16 = xi0.a.INSTANCE.a();
                ECShowWindowFragment.this.startActivityForResult(a16 != null ? a16.getIntent(context, ECShowWindowSearchFragment.class, bundle) : null, 0);
            }
            ECShowWindowFragment.zi(ECShowWindowFragment.this).m3(false);
            ECShowWindowFragment.zi(ECShowWindowFragment.this).n3(false);
            com.tencent.ecommerce.biz.common.f.f101556a.d(ECShowWindowFragment.this.channel, "window_search_bar_clk");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class aj implements View.OnClickListener {
        aj() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECShowWindowFragment.zi(ECShowWindowFragment.this).o3();
            ECShowWindowFragment.mi(ECShowWindowFragment.this).notifyDataSetChanged();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/showwindow/fragment/ECShowWindowFragment$b", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lri0/a;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements EventObserver<ECAddProductToWindowEvent> {
        b() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECAddProductToWindowEvent event) {
            if (event.isAdded) {
                ECShowWindowFragment.zj(ECShowWindowFragment.this, null, false, true, 3, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECShowWindowFragment.zi(ECShowWindowFragment.this).n3(true);
            fj0.b.f399473a.b(ECShowWindowFragment.this.channel, "window_manage_clk");
            ECShowWindowFragment.zi(ECShowWindowFragment.this).m3(false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECShowWindowFragment.zi(ECShowWindowFragment.this).n3(false);
            ECShowWindowFragment.zi(ECShowWindowFragment.this).h2();
            fj0.b.f399473a.b(ECShowWindowFragment.this.channel, "window_cancel_manage_clk");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ECShowWindowFragment.this.fj() && Intrinsics.areEqual(ECShowWindowFragment.zi(ECShowWindowFragment.this).v2().getValue(), Boolean.TRUE)) {
                ECShowWindowFragment.this.Qi();
            } else {
                ECShowWindowFragment.this.requireActivity().finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECShowWindowFragment.zi(ECShowWindowFragment.this).m3(false);
            ECShowWindowFragment.this.hj();
            fj0.b.f399473a.a(ECShowWindowFragment.this.channel, 1);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECShowWindowFragment.zi(ECShowWindowFragment.this).m3(false);
            ECShowWindowFragment.this.hj();
            fj0.b.f399473a.a(ECShowWindowFragment.this.channel, 1);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECShowWindowFragment.zi(ECShowWindowFragment.this).m3(false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            view.setVisibility(8);
            ECShowWindowFragment.zi(ECShowWindowFragment.this).s3("");
            ECShowWindowFragment.zj(ECShowWindowFragment.this, null, false, false, 7, null);
            ECShowWindowFragment.zi(ECShowWindowFragment.this).n3(false);
            ECShowWindowFragment.zi(ECShowWindowFragment.this).h2();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/showwindow/fragment/ECShowWindowFragment$j", "Lcom/tencent/ecommerce/base/ui/e;", "", "id", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "veiw", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j extends com.tencent.ecommerce.base.ui.e {
        j() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String id5, HashMap<String, String> dataMap, View veiw, PTSComposer ptsComposer) {
            a.b("ECShowWindowFragment", "[onTapEventTriggered] id = " + id5);
            ECShowWindowFragment.this.hj();
            fj0.b.f399473a.a(ECShowWindowFragment.this.channel, 2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/showwindow/fragment/ECShowWindowFragment$k", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class k extends RecyclerView.OnScrollListener {
        k() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                    List<Product> value = ECShowWindowFragment.zi(ECShowWindowFragment.this).A2().getValue();
                    if (value == null) {
                        value = CollectionsKt__CollectionsKt.emptyList();
                    }
                    if (value.size() > findLastCompletelyVisibleItemPosition) {
                        for (int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition(); findFirstCompletelyVisibleItemPosition < findLastCompletelyVisibleItemPosition; findFirstCompletelyVisibleItemPosition++) {
                            ECShowWindowFragment eCShowWindowFragment = ECShowWindowFragment.this;
                            eCShowWindowFragment.ij(eCShowWindowFragment.isMaster, value.get(findFirstCompletelyVisibleItemPosition));
                        }
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            super.onScrolled(recyclerView, dx5, dy5);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                boolean z16 = (ECShowWindowFragment.zi(ECShowWindowFragment.this).getLastCookie().length() > 0) && linearLayoutManager.getItemCount() < 8;
                Boolean value = ECShowWindowFragment.zi(ECShowWindowFragment.this).T2().getValue();
                Boolean bool = Boolean.TRUE;
                if (Intrinsics.areEqual(value, bool)) {
                    return;
                }
                if ((z16 || linearLayoutManager.findFirstVisibleItemPosition() != 0) && !Intrinsics.areEqual(ECShowWindowFragment.zi(ECShowWindowFragment.this).S2().getValue(), bool)) {
                    if (ECShowWindowFragment.mi(ECShowWindowFragment.this).getNUM_BACKGOURND_ICON() - linearLayoutManager.findLastVisibleItemPosition() <= 8) {
                        ECShowWindowFragment.zj(ECShowWindowFragment.this, ECShowWindowFragment.zi(ECShowWindowFragment.this).getLastCookie(), true, false, 4, null);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECShowWindowFragment.this.Jj();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class m<T> implements Observer<T> {
        public m() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            if (((Boolean) t16).booleanValue()) {
                ECShowWindowFragment.si(ECShowWindowFragment.this).setImageResource(R.drawable.e6v);
            } else {
                ECShowWindowFragment.si(ECShowWindowFragment.this).setImageResource(R.drawable.e5s);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class n<T> implements Observer<Boolean> {
        n() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                ECShowWindowFragment.Vh(ECShowWindowFragment.this).setVisibility(0);
                ECShowWindowFragment.Th(ECShowWindowFragment.this).setImageResource(R.drawable.blc);
                ECShowWindowFragment.ti(ECShowWindowFragment.this).setTextColor(ECShowWindowFragment.this.requireContext().getResources().getColor(R.color.f156573l2));
                return;
            }
            ECShowWindowFragment.Vh(ECShowWindowFragment.this).setVisibility(8);
            Boolean value = ECShowWindowFragment.zi(ECShowWindowFragment.this).s2().getValue();
            if (value == null) {
                value = Boolean.FALSE;
            }
            if (value.booleanValue()) {
                ECShowWindowFragment.Th(ECShowWindowFragment.this).setImageResource(R.drawable.bla);
                ECShowWindowFragment.ti(ECShowWindowFragment.this).setTextColor(ECShowWindowFragment.this.requireContext().getResources().getColor(R.color.f156561g9));
            } else {
                ECShowWindowFragment.Th(ECShowWindowFragment.this).setImageResource(R.drawable.bl7);
                ECShowWindowFragment.ti(ECShowWindowFragment.this).setTextColor(ECShowWindowFragment.this.requireContext().getResources().getColor(R.color.f156572l1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class o<T> implements Observer<Boolean> {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\n"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release", "com/tencent/ecommerce/biz/showwindow/fragment/ECShowWindowFragment$registerEditableLiveDataObserver$1$$special$$inlined$apply$lambda$1"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a implements Animator.AnimatorListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Ref.IntRef f104623e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Ref.IntRef f104624f;

            public a(Ref.IntRef intRef, Ref.IntRef intRef2) {
                this.f104623e = intRef;
                this.f104624f = intRef2;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
                ECShowWindowFragment.Ph(ECShowWindowFragment.this).setVisibility(this.f104623e.element);
                ECShowWindowFragment.bi(ECShowWindowFragment.this).setVisibility(this.f104624f.element);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(ECShowWindowFragment.Rh(ECShowWindowFragment.this), (Property<RelativeLayout, Float>) View.TRANSLATION_Y, 0.0f);
                ofFloat.setDuration(300L);
                ofFloat.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
            }
        }

        o() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            int i3;
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 8;
            Ref.IntRef intRef2 = new Ref.IntRef();
            intRef2.element = 8;
            boolean z16 = false;
            if (bool.booleanValue()) {
                ECShowWindowFragment.ei(ECShowWindowFragment.this).setVisibility(0);
                ECShowWindowFragment.Sh(ECShowWindowFragment.this).setVisibility(0);
                ECShowWindowFragment.ji(ECShowWindowFragment.this).setVisibility(8);
                ECShowWindowFragment.ti(ECShowWindowFragment.this).setTextColor(ECShowWindowFragment.this.requireContext().getResources().getColor(R.color.f156561g9));
                ECShowWindowFragment.Th(ECShowWindowFragment.this).setImageResource(R.drawable.bla);
                ECShowWindowFragment.this.Oi(60.0f);
                if (ECShowWindowFragment.this.fj()) {
                    ECShowWindowFragment.Qh(ECShowWindowFragment.this).setVisibility(0);
                    ECShowWindowFragment.ei(ECShowWindowFragment.this).setVisibility(8);
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                intRef.element = 8;
                intRef2.element = i3;
            } else {
                ECShowWindowFragment.ji(ECShowWindowFragment.this).setVisibility(ECShowWindowFragment.this.dj() ? 0 : 8);
                intRef.element = ECShowWindowFragment.this.dj() ? 0 : 8;
                intRef2.element = 8;
                ECShowWindowFragment.ei(ECShowWindowFragment.this).setVisibility(8);
                ECShowWindowFragment.Sh(ECShowWindowFragment.this).setVisibility(0);
                ECShowWindowFragment.ti(ECShowWindowFragment.this).setTextColor(ECShowWindowFragment.this.requireContext().getResources().getColor(R.color.f156572l1));
                ECShowWindowFragment.Th(ECShowWindowFragment.this).setImageResource(R.drawable.bl7);
                ECShowWindowFragment.this.Oi(0.0f);
            }
            if (ECShowWindowFragment.Rh(ECShowWindowFragment.this).getHeight() > 0.001d) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(ECShowWindowFragment.Rh(ECShowWindowFragment.this), (Property<RelativeLayout, Float>) View.TRANSLATION_Y, r1.getHeight());
                ofFloat.setDuration(200L);
                ofFloat.addListener(new a(intRef, intRef2));
                ofFloat.start();
            } else {
                ECShowWindowFragment.Ph(ECShowWindowFragment.this).setVisibility(intRef.element);
                ECShowWindowFragment.bi(ECShowWindowFragment.this).setVisibility(intRef2.element);
            }
            if (ECShowWindowFragment.this.gj() && !bool.booleanValue()) {
                z16 = true;
            }
            ECShowWindowFragment.this.Kj(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class p<T> implements Observer<Integer> {
        p() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            TextView ui5 = ECShowWindowFragment.ui(ECShowWindowFragment.this);
            Context context = ECShowWindowFragment.this.getContext();
            String str = null;
            if (context != null) {
                Object[] objArr = new Object[1];
                List<Product> value = ECShowWindowFragment.zi(ECShowWindowFragment.this).C2().getValue();
                objArr[0] = value != null ? Integer.valueOf(value.size()) : null;
                str = context.getString(R.string.wsl, objArr);
            }
            ui5.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class q<T> implements Observer<Integer> {
        q() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            JSONObject jSONObject = new JSONObject();
            Resources resources = ECShowWindowFragment.this.requireContext().getResources();
            if (num != null && num.intValue() == -1) {
                ECShowWindowFragment.ci(ECShowWindowFragment.this).setVisibility(8);
            } else if (num != null && num.intValue() == 0) {
                jSONObject.put("imageToken", "qecommerce_skin_emptystate_img_wenjian");
                jSONObject.put("cus_text", resources.getString(R.string.wuk));
                jSONObject.put("second_text", resources.getString(R.string.wug));
            } else if (num != null && num.intValue() == 1) {
                jSONObject.put("imageToken", "qecommerce_skin_emptystate_img_sousuo");
                jSONObject.put("cus_text", resources.getString(R.string.wsa));
            } else if (num != null && num.intValue() == 2) {
                jSONObject.put("imageToken", "qecommerce_skin_emptystate_img_wuwangluo");
                jSONObject.put("cus_text", resources.getString(R.string.wui));
            } else if (num != null && num.intValue() == 3) {
                jSONObject.put("imageToken", "qecommerce_skin_emptystate_img_wenjian");
                jSONObject.put("cus_text", resources.getString(R.string.wix));
            }
            if ((num == null || -1 != num.intValue()) && ECShowWindowFragment.this.isProductListEmpty) {
                ECShowWindowFragment.ci(ECShowWindowFragment.this).setVisibility(0);
            }
            ECShowWindowFragment.di(ECShowWindowFragment.this).setData(jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class r<T> implements Observer<Boolean> {
        r() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            a.b("ECShowWindowFragment", "registerIsLoadingLiveDataObserver " + bool);
            ECShowWindowFragment.mi(ECShowWindowFragment.this).B0(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class s<T> implements Observer<Boolean> {
        s() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            ECShowWindowFragment.ii(ECShowWindowFragment.this).setVisibility(bool.booleanValue() ? 0 : 8);
            if (bool.booleanValue()) {
                ECShowWindowFragment.this.Hj();
                ECShowWindowFragment.ci(ECShowWindowFragment.this).setVisibility(8);
            } else {
                ECShowWindowFragment.hi(ECShowWindowFragment.this).clearAnimation();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lck0/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class t<T> implements Observer<List<? extends ck0.a>> {
        t() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<ck0.a> list) {
            ECShowWindowFragment.mi(ECShowWindowFragment.this).A0(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lck0/c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class u<T> implements Observer<List<? extends Product>> {
        u() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<Product> list) {
            a.b("ECShowWindowFragment", "registerLiveDataObserver- " + ECShowWindowFragment.zi(ECShowWindowFragment.this).T2().getValue());
            ECShowWindowFragment.this.isProductListEmpty = list.isEmpty();
            ECShowWindowFragment.mi(ECShowWindowFragment.this).setData(list);
            ECShowWindowFragment.this.Ij(list.isEmpty());
            if (list.isEmpty()) {
                Boolean value = ECShowWindowFragment.zi(ECShowWindowFragment.this).s2().getValue();
                if (value == null) {
                    value = Boolean.FALSE;
                }
                if (value.booleanValue()) {
                    ECShowWindowFragment.zi(ECShowWindowFragment.this).n3(false);
                }
                ECShowWindowFragment.this.Ri();
            }
            ECShowWindowFragment.ji(ECShowWindowFragment.this).setEnabled(!list.isEmpty());
            if (((TextView) ECShowWindowFragment.ji(ECShowWindowFragment.this).findViewById(R.id.f163059o31)) != null) {
                list.isEmpty();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lck0/b;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class v<T> implements Observer<List<? extends Category>> {
        v() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<Category> list) {
            ECShowWindowFragment.Uh(ECShowWindowFragment.this).setData(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lck0/b;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lck0/b;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class w<T> implements Observer<Category> {
        w() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Category category) {
            ECShowWindowFragment.ti(ECShowWindowFragment.this).setText(category.name);
            ECShowWindowFragment.Uh(ECShowWindowFragment.this).notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class x<T> implements Observer<T> {
        public x() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            ((Number) t16).intValue();
            ECShowWindowFragment.this.Pi();
            FragmentActivity activity = ECShowWindowFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class y<T> implements Observer<T> {
        public y() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            Integer num = (Integer) t16;
            TextView gi5 = ECShowWindowFragment.gi(ECShowWindowFragment.this);
            Context context = ECShowWindowFragment.this.getContext();
            gi5.setText(context != null ? context.getString(R.string.wsl, num) : null);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class z<T> implements Observer<T> {
        public z() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            ECShowWindowFragment.fi(ECShowWindowFragment.this).setEnabled(Intrinsics.areEqual((Boolean) t16, Boolean.TRUE));
        }
    }

    private final void Aj() {
        if (this.isMaster) {
            return;
        }
        com.tencent.ecommerce.biz.util.h hVar = com.tencent.ecommerce.biz.util.h.f104868a;
        View view = this.containerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        }
        hVar.a(view, true);
        com.tencent.ecommerce.biz.util.r.f104881b.e(getActivity(), false);
        View view2 = this.isLoadingFooter;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("isLoadingFooter");
        }
        view2.findViewById(R.id.f163122of1).setVisibility(8);
    }

    private final void Bj() {
        if (wg0.a.b()) {
            View view = this.addProductButton;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addProductButton");
            }
            view.setOnLongClickListener(af.f104601d);
        }
    }

    private final void Cj() {
        LinearLayout linearLayout = this.categoryButton;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryButton");
        }
        linearLayout.setOnClickListener(new ag());
    }

    private final void Dj() {
        View view = this.deleteButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteButton");
        }
        view.setOnClickListener(new ah());
    }

    private final void Ej() {
        LinearLayout linearLayout = this.searchBar;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        }
        linearLayout.setOnClickListener(new ai());
    }

    private final void Fj() {
        ImageView imageView = this.selectAllButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectAllButton");
        }
        imageView.setOnClickListener(new aj());
    }

    private final void Gj() {
        View view = this.setTopButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setTopButton");
        }
        view.setOnClickListener(new ECShowWindowFragment$setupSetTopButtonClickListener$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hj() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(800L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
        ImageView imageView = this.loadingIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingIcon");
        }
        imageView.clearAnimation();
        ImageView imageView2 = this.loadingIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingIcon");
        }
        imageView2.startAnimation(rotateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ij(boolean isVisible) {
        FrameLayout frameLayout = this.emptyContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyContainer");
        }
        frameLayout.setVisibility(isVisible ? 0 : 8);
        if (isVisible) {
            ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
            if (eCShowWindowViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (eCShowWindowViewModel.getIsNetworkErrorLastTime()) {
                return;
            }
            if (this.isMaster) {
                ECShowWindowViewModel eCShowWindowViewModel2 = this.viewModel;
                if (eCShowWindowViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                String value = eCShowWindowViewModel2.r2().getValue();
                if (value == null) {
                    value = "";
                }
                if (TextUtils.isEmpty(value)) {
                    ECShowWindowViewModel eCShowWindowViewModel3 = this.viewModel;
                    if (eCShowWindowViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    eCShowWindowViewModel3.t3(0);
                    return;
                }
                ECShowWindowViewModel eCShowWindowViewModel4 = this.viewModel;
                if (eCShowWindowViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                eCShowWindowViewModel4.t3(1);
                return;
            }
            ECShowWindowViewModel eCShowWindowViewModel5 = this.viewModel;
            if (eCShowWindowViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            eCShowWindowViewModel5.t3(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jj() {
        Bundle bundle = new Bundle();
        bundle.putLong("roomId", this.liveRoomId);
        bundle.putString("userId", this.liveUserId);
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel.u3(bundle);
        ei0.c cVar = ei0.c.f396302a;
        ECShowWindowViewModel eCShowWindowViewModel2 = this.viewModel;
        if (eCShowWindowViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cVar.e(this, eCShowWindowViewModel2.B2().getValue(), this.windowType);
        ECShowWindowViewModel eCShowWindowViewModel3 = this.viewModel;
        if (eCShowWindowViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        cVar.f(this, eCShowWindowViewModel3.G2().getValue(), this.windowType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kj(boolean isVisible) {
        List<Product> value;
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        List<Product> value2 = eCShowWindowViewModel.A2().getValue();
        if (value2 != null) {
            ECBaseRecyclerView eCBaseRecyclerView = this.productListView;
            if (eCBaseRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productListView");
            }
            RecyclerView.LayoutManager layoutManager = eCBaseRecyclerView.getLayoutManager();
            if (layoutManager != null) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (findLastVisibleItemPosition - findFirstVisibleItemPosition > 2 && value2.size() > findLastVisibleItemPosition - 1) {
                    int i3 = findLastVisibleItemPosition + 2;
                    ECShowWindowViewModel eCShowWindowViewModel2 = this.viewModel;
                    if (eCShowWindowViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    MutableLiveData<List<Product>> A2 = eCShowWindowViewModel2.A2();
                    if (i3 < ((A2 == null || (value = A2.getValue()) == null) ? 0 : value.size())) {
                        findLastVisibleItemPosition = i3;
                    }
                    List<Product> subList = value2.subList(findFirstVisibleItemPosition, findLastVisibleItemPosition);
                    ECShowWindowViewModel eCShowWindowViewModel3 = this.viewModel;
                    if (eCShowWindowViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    eCShowWindowViewModel3.v3(subList, isVisible);
                }
                ECShowWindowViewModel eCShowWindowViewModel4 = this.viewModel;
                if (eCShowWindowViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                eCShowWindowViewModel4.w3();
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ECShowWindowFragment$updateProductAddBtnVisibility$$inlined$run$lambda$1(null, this, isVisible), 3, null);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }

    public static final /* synthetic */ View Ph(ECShowWindowFragment eCShowWindowFragment) {
        View view = eCShowWindowFragment.addProductButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addProductButton");
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Pi() {
        JSONObject jSONObject = new JSONObject();
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        jSONObject.put("live_product_counts", eCShowWindowViewModel.D2().getValue());
        jSONObject.put("need_update", true);
        jSONObject.put("is_from_mywindow", true);
        IECSchemeCallback iECSchemeCallback = this.deliverProductCallback;
        if (iECSchemeCallback != null) {
            iECSchemeCallback.onCallbackFinished(jSONObject);
        }
    }

    public static final /* synthetic */ View Qh(ECShowWindowFragment eCShowWindowFragment) {
        View view = eCShowWindowFragment.addProductButtonOld;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addProductButtonOld");
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qi() {
        final Context context = getContext();
        if (context != null) {
            final com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(context);
            gVar.Y(context.getResources().getString(R.string.wnd));
            gVar.b0(context.getResources().getString(R.string.wnl));
            gVar.f0(context.getResources().getString(R.string.wnj));
            gVar.d0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECShowWindowFragment$checkOperationSave$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    c cVar = c.f396302a;
                    cVar.l(g.this.X());
                    cVar.k(g.this.S());
                }
            });
            gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECShowWindowFragment$checkOperationSave$$inlined$also$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    c.f396302a.c(g.this.S());
                    this.Pi();
                    FragmentActivity activity = this.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            });
            gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECShowWindowFragment$checkOperationSave$$inlined$also$lambda$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    c.f396302a.c(g.this.X());
                    this.Jj();
                }
            });
            gVar.show();
        }
    }

    public static final /* synthetic */ RelativeLayout Rh(ECShowWindowFragment eCShowWindowFragment) {
        RelativeLayout relativeLayout = eCShowWindowFragment.animaContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animaContainer");
        }
        return relativeLayout;
    }

    public static final /* synthetic */ ImageView Sh(ECShowWindowFragment eCShowWindowFragment) {
        ImageView imageView = eCShowWindowFragment.backButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        }
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Si(String mediaName) {
        if (TextUtils.isEmpty(mediaName) || mediaName == null) {
            return "TA";
        }
        return com.tencent.ecommerce.biz.util.t.f104882a.a(mediaName, 24);
    }

    public static final /* synthetic */ ImageView Th(ECShowWindowFragment eCShowWindowFragment) {
        ImageView imageView = eCShowWindowFragment.categoryIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryIcon");
        }
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Ti() {
        if (ej()) {
            return requireContext().getResources().getString(R.string.wum);
        }
        return "";
    }

    public static final /* synthetic */ com.tencent.ecommerce.biz.showwindow.ui.adapter.b Uh(ECShowWindowFragment eCShowWindowFragment) {
        com.tencent.ecommerce.biz.showwindow.ui.adapter.b bVar = eCShowWindowFragment.categoryListAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryListAdapter");
        }
        return bVar;
    }

    public static final /* synthetic */ FrameLayout Vh(ECShowWindowFragment eCShowWindowFragment) {
        FrameLayout frameLayout = eCShowWindowFragment.categoryPanel;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryPanel");
        }
        return frameLayout;
    }

    private final void Wi() {
        FrameLayout frameLayout = this.categoryPanel;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryPanel");
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin += com.tencent.ecommerce.biz.util.r.f104881b.a(getActivity());
            FrameLayout frameLayout2 = this.categoryPanel;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("categoryPanel");
            }
            frameLayout2.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public static final /* synthetic */ ImageView Xh(ECShowWindowFragment eCShowWindowFragment) {
        ImageView imageView = eCShowWindowFragment.deleteButtonIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteButtonIcon");
        }
        return imageView;
    }

    public static final /* synthetic */ TextView Yh(ECShowWindowFragment eCShowWindowFragment) {
        TextView textView = eCShowWindowFragment.deleteButtonText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteButtonText");
        }
        return textView;
    }

    private final void Yi() {
        Object systemService = requireContext().getSystemService("layout_inflater");
        if (systemService != null) {
            LayoutInflater layoutInflater = (LayoutInflater) systemService;
            ECBaseRecyclerView eCBaseRecyclerView = this.productListView;
            if (eCBaseRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productListView");
            }
            this.isLoadingFooter = layoutInflater.inflate(R.layout.crw, (ViewGroup) eCBaseRecyclerView, false);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    private final void Zi() {
        a.b("ECShowWindowFragment", "[initIsMasterPage] isMaster = " + this.isMaster);
        if (!this.isMaster) {
            View view = this.addProductButton;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addProductButton");
            }
            view.setVisibility(8);
            View view2 = this.addProductButtonOld;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addProductButtonOld");
            }
            view2.setVisibility(8);
            View view3 = this.editToolBar;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editToolBar");
            }
            view3.setVisibility(8);
            View view4 = this.searchBarContainer;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
            }
            view4.setVisibility(8);
            LinearLayout linearLayout = this.searchBar;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            }
            linearLayout.setVisibility(8);
            FrameLayout frameLayout = this.manageBar;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manageBar");
            }
            frameLayout.setVisibility(8);
            View view5 = this.manageButton;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manageButton");
            }
            view5.setVisibility(8);
            FrameLayout frameLayout2 = this.emptyContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyContainer");
            }
            frameLayout2.setVisibility(8);
            TextView textView = this.titleTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            }
            textView.setText(requireContext().getResources().getString(R.string.wun, Si(this.mediaName)));
            return;
        }
        View view6 = this.addProductButton;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addProductButton");
        }
        view6.setVisibility(0);
        View view7 = this.addProductButtonOld;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addProductButtonOld");
        }
        view7.setVisibility(8);
        View view8 = this.manageButton;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageButton");
        }
        view8.setVisibility(0);
        LinearLayout linearLayout2 = this.searchBar;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        }
        linearLayout2.setVisibility(0);
    }

    public static final /* synthetic */ FrameLayout ai(ECShowWindowFragment eCShowWindowFragment) {
        FrameLayout frameLayout = eCShowWindowFragment.deleteConfirmDialogContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteConfirmDialogContainer");
        }
        return frameLayout;
    }

    private final void aj() {
        if (this.isCurrentNightMode) {
            Aj();
        }
    }

    public static final /* synthetic */ View bi(ECShowWindowFragment eCShowWindowFragment) {
        View view = eCShowWindowFragment.editToolBar;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editToolBar");
        }
        return view;
    }

    public static final /* synthetic */ FrameLayout ci(ECShowWindowFragment eCShowWindowFragment) {
        FrameLayout frameLayout = eCShowWindowFragment.emptyContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyContainer");
        }
        return frameLayout;
    }

    private final void cj(View rootView) {
        a.b("ECShowWindowFragment", "[initWindowTypePage], windowType = " + this.windowType);
        if (ej()) {
            View view = this.addProductButton;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addProductButton");
            }
            view.setVisibility(8);
            View view2 = this.addProductButtonOld;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addProductButtonOld");
            }
            view2.setVisibility(8);
            FrameLayout frameLayout = this.manageBar;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manageBar");
            }
            frameLayout.setVisibility(8);
            View view3 = this.manageButton;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manageButton");
            }
            view3.setVisibility(8);
            TextView textView = this.titleTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            }
            textView.setText(requireContext().getResources().getString(R.string.wum));
            ECBaseRecyclerView eCBaseRecyclerView = this.productListView;
            if (eCBaseRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productListView");
            }
            eCBaseRecyclerView.setPadding(0, com.tencent.ecommerce.biz.util.e.c(6.0f), 0, 0);
            return;
        }
        if (fj()) {
            this.isMaster = true;
            ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
            if (eCShowWindowViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            eCShowWindowViewModel.n3(true);
            ECShowWindowViewModel eCShowWindowViewModel2 = this.viewModel;
            if (eCShowWindowViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            eCShowWindowViewModel2.e3(true);
            View inflate = ((ViewStub) rootView.findViewById(R.id.o9c)).inflate();
            this.liveEditToolBar = inflate.findViewById(R.id.o9b);
            this.liveSelectedNumberTextView = (TextView) inflate.findViewById(R.id.odv);
            this.liveConfirmBtn = (TextView) inflate.findViewById(R.id.odu);
            new View(getContext()).setLayoutParams(new ViewGroup.LayoutParams(-1, com.tencent.ecommerce.biz.util.e.c(20.0f)));
            View view4 = this.liveEditToolBar;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liveEditToolBar");
            }
            view4.setVisibility(0);
            View view5 = this.finishedButton;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("finishedButton");
            }
            view5.setVisibility(8);
            FrameLayout frameLayout2 = this.manageBar;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manageBar");
            }
            frameLayout2.setVisibility(8);
            View view6 = this.manageButton;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manageButton");
            }
            view6.setVisibility(8);
            View view7 = this.addProductButton;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addProductButton");
            }
            view7.setVisibility(8);
            View view8 = this.addProductButtonOld;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addProductButtonOld");
            }
            view8.setVisibility(0);
            View view9 = this.editToolBar;
            if (view9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editToolBar");
            }
            view9.setVisibility(8);
            RelativeLayout relativeLayout = this.animaContainer;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animaContainer");
            }
            relativeLayout.setVisibility(8);
            ImageView imageView = this.backButton;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backButton");
            }
            imageView.setVisibility(0);
            TextView textView2 = this.liveConfirmBtn;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liveConfirmBtn");
            }
            textView2.setOnClickListener(new l());
            ei0.c cVar = ei0.c.f396302a;
            cVar.o(this);
            View view10 = this.addProductButton;
            if (view10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addProductButton");
            }
            cVar.i(view10);
            ECBaseRecyclerView eCBaseRecyclerView2 = this.productListView;
            if (eCBaseRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productListView");
            }
            cVar.m(eCBaseRecyclerView2, getArguments());
            TextView textView3 = this.liveConfirmBtn;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liveConfirmBtn");
            }
            cVar.j(textView3);
            LinearLayout linearLayout = this.searchBar;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            }
            TextView textView4 = this.searchTextView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchTextView");
            }
            cVar.p(linearLayout, textView4.getText().toString());
        }
    }

    public static final /* synthetic */ PTSComposer di(ECShowWindowFragment eCShowWindowFragment) {
        PTSComposer pTSComposer = eCShowWindowFragment.emptyPtsComposer;
        if (pTSComposer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyPtsComposer");
        }
        return pTSComposer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean dj() {
        return this.windowType == 1;
    }

    public static final /* synthetic */ View ei(ECShowWindowFragment eCShowWindowFragment) {
        View view = eCShowWindowFragment.finishedButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("finishedButton");
        }
        return view;
    }

    private final boolean ej() {
        return this.windowType == 2;
    }

    public static final /* synthetic */ TextView fi(ECShowWindowFragment eCShowWindowFragment) {
        TextView textView = eCShowWindowFragment.liveConfirmBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveConfirmBtn");
        }
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean fj() {
        return this.windowType == 3;
    }

    public static final /* synthetic */ TextView gi(ECShowWindowFragment eCShowWindowFragment) {
        TextView textView = eCShowWindowFragment.liveSelectedNumberTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveSelectedNumberTextView");
        }
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean gj() {
        return (this.deliverProductCallback == null || fj()) ? false : true;
    }

    public static final /* synthetic */ ImageView hi(ECShowWindowFragment eCShowWindowFragment) {
        ImageView imageView = eCShowWindowFragment.loadingIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingIcon");
        }
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hj() {
        final HashMap hashMap = new HashMap();
        hashMap.put("goods_center_source_from", "1");
        new Function0<Boolean>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECShowWindowFragment$onAddProductButtonClicked$openSelectProductCenter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                return yi0.a.t(Uri.parse(String.valueOf(10)), hashMap, null, null, 12, null);
            }
        }.invoke();
    }

    public static final /* synthetic */ FrameLayout ii(ECShowWindowFragment eCShowWindowFragment) {
        FrameLayout frameLayout = eCShowWindowFragment.loadingPage;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingPage");
        }
        return frameLayout;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(35:1|(1:98)|7|(1:97)|11|(1:96)|17|(1:95)|23|(2:25|(25:27|(4:29|(2:31|(2:33|(20:35|36|(1:91)|42|(1:90)|48|(1:54)|55|(1:89)|61|62|63|(1:69)|70|72|73|(1:79)|80|81|82)))|92|(0))|93|36|(1:38)|91|42|(1:44)|90|48|(3:50|52|54)|55|(1:57)|89|61|62|63|(3:65|67|69)|70|72|73|(3:75|77|79)|80|81|82))|94|(0)|93|36|(0)|91|42|(0)|90|48|(0)|55|(0)|89|61|62|63|(0)|70|72|73|(0)|80|81|82) */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0145, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0146, code lost:
    
        cg0.a.a("ECShowWindowFragment", "[initArguments]", "get source param error = " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0121, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0122, code lost:
    
        cg0.a.a("ECShowWindowFragment", "[initArguments]", r2.toString());
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010b A[Catch: NumberFormatException -> 0x0121, TryCatch #0 {NumberFormatException -> 0x0121, blocks: (B:63:0x0105, B:65:0x010b, B:67:0x0111, B:69:0x011a, B:70:0x011e), top: B:62:0x0105 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012f A[Catch: Exception -> 0x0145, TryCatch #1 {Exception -> 0x0145, blocks: (B:73:0x0129, B:75:0x012f, B:77:0x0135, B:79:0x013e, B:80:0x0142), top: B:72:0x0129 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initArguments() {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z16;
        boolean z17;
        FragmentActivity activity;
        FragmentActivity activity2;
        FragmentActivity activity3;
        FragmentActivity activity4;
        FragmentActivity activity5;
        Intent intent;
        String stringExtra;
        FragmentActivity activity6;
        Intent intent2;
        String stringExtra2;
        Intent intent3;
        Intent intent4;
        String stringExtra3;
        Intent intent5;
        Intent intent6;
        boolean z18;
        boolean isBlank;
        boolean isBlank2;
        Intent intent7;
        Intent intent8;
        Intent intent9;
        FragmentActivity activity7 = getActivity();
        String str5 = "";
        if (activity7 == null || (intent9 = activity7.getIntent()) == null || (str = intent9.getStringExtra("media_id")) == null) {
            str = "";
        }
        this.mediaId = str;
        Bundle arguments = getArguments();
        if (arguments == null || (str2 = arguments.getString("seller_uin")) == null) {
            str2 = "";
        }
        this.sellerUin = str2;
        FragmentActivity activity8 = getActivity();
        if (activity8 == null || (intent8 = activity8.getIntent()) == null || (str3 = intent8.getStringExtra("media_name")) == null) {
            str3 = "";
        }
        this.mediaName = str3;
        FragmentActivity activity9 = getActivity();
        if (activity9 == null || (intent7 = activity9.getIntent()) == null || (str4 = intent7.getStringExtra("scheme_callback_id")) == null) {
            str4 = "";
        }
        this.deliverProductCallbackId = str4;
        this.deliverProductCallback = ug0.a.b(str4);
        String str6 = this.mediaId;
        int i3 = 0;
        int i16 = 1;
        if (str6 != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str6);
            if (!isBlank2) {
                z16 = false;
                if (z16) {
                    String str7 = this.sellerUin;
                    if (str7 != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(str7);
                        if (!isBlank) {
                            z18 = false;
                            if (z18) {
                                z17 = true;
                                this.isMaster = z17;
                                activity = getActivity();
                                if (activity != null || (intent6 = activity.getIntent()) == null || (r2 = intent6.getStringExtra(WadlProxyConsts.CHANNEL)) == null) {
                                    String str8 = "";
                                }
                                this.channel = str8;
                                activity2 = getActivity();
                                if (activity2 != null || (intent5 = activity2.getIntent()) == null || (r2 = intent5.getStringExtra("source_from")) == null) {
                                    String str9 = "";
                                }
                                this.sourceFrom = str9;
                                this.isCurrentNightMode = fg0.a.f398587b.a();
                                activity3 = getActivity();
                                if (activity3 != null && (intent4 = activity3.getIntent()) != null && (stringExtra3 = intent4.getStringExtra("live_user_id")) != null) {
                                    str5 = stringExtra3;
                                }
                                this.liveUserId = str5;
                                activity4 = getActivity();
                                if (activity4 != null || (intent3 = activity4.getIntent()) == null || (r2 = intent3.getStringExtra("live_room_id")) == null) {
                                    String str10 = "0";
                                }
                                this.liveRoomId = Long.parseLong(str10);
                                activity6 = getActivity();
                                if (activity6 != null && (intent2 = activity6.getIntent()) != null && (stringExtra2 = intent2.getStringExtra("window_type")) != null) {
                                    i16 = Integer.parseInt(stringExtra2);
                                }
                                this.windowType = i16;
                                activity5 = getActivity();
                                if (activity5 != null && (intent = activity5.getIntent()) != null && (stringExtra = intent.getStringExtra("source")) != null) {
                                    i3 = Integer.parseInt(stringExtra);
                                }
                                this.source = i3;
                                a.b("ECShowWindowFragment", "[initArguments] mediaId = " + this.mediaId + ", mediaName = " + this.mediaName + ", isMaster = " + this.isMaster + ", deliverProductCallId = " + this.deliverProductCallbackId + ", channel = " + this.channel + ", sourceFrom = " + this.sourceFrom + ", isNightMode = " + this.isCurrentNightMode + ", windowType = " + this.windowType + ", liveUserId = " + this.liveUserId + ", liveRoomId = " + this.liveRoomId);
                            }
                        }
                    }
                    z18 = true;
                    if (z18) {
                    }
                }
                z17 = false;
                this.isMaster = z17;
                activity = getActivity();
                if (activity != null) {
                }
                String str82 = "";
                this.channel = str82;
                activity2 = getActivity();
                if (activity2 != null) {
                }
                String str92 = "";
                this.sourceFrom = str92;
                this.isCurrentNightMode = fg0.a.f398587b.a();
                activity3 = getActivity();
                if (activity3 != null) {
                    str5 = stringExtra3;
                }
                this.liveUserId = str5;
                activity4 = getActivity();
                if (activity4 != null) {
                }
                String str102 = "0";
                this.liveRoomId = Long.parseLong(str102);
                activity6 = getActivity();
                if (activity6 != null) {
                    i16 = Integer.parseInt(stringExtra2);
                }
                this.windowType = i16;
                activity5 = getActivity();
                if (activity5 != null) {
                    i3 = Integer.parseInt(stringExtra);
                }
                this.source = i3;
                a.b("ECShowWindowFragment", "[initArguments] mediaId = " + this.mediaId + ", mediaName = " + this.mediaName + ", isMaster = " + this.isMaster + ", deliverProductCallId = " + this.deliverProductCallbackId + ", channel = " + this.channel + ", sourceFrom = " + this.sourceFrom + ", isNightMode = " + this.isCurrentNightMode + ", windowType = " + this.windowType + ", liveUserId = " + this.liveUserId + ", liveRoomId = " + this.liveRoomId);
            }
        }
        z16 = true;
        if (z16) {
        }
        z17 = false;
        this.isMaster = z17;
        activity = getActivity();
        if (activity != null) {
        }
        String str822 = "";
        this.channel = str822;
        activity2 = getActivity();
        if (activity2 != null) {
        }
        String str922 = "";
        this.sourceFrom = str922;
        this.isCurrentNightMode = fg0.a.f398587b.a();
        activity3 = getActivity();
        if (activity3 != null) {
        }
        this.liveUserId = str5;
        activity4 = getActivity();
        if (activity4 != null) {
        }
        String str1022 = "0";
        this.liveRoomId = Long.parseLong(str1022);
        activity6 = getActivity();
        if (activity6 != null) {
        }
        this.windowType = i16;
        activity5 = getActivity();
        if (activity5 != null) {
        }
        this.source = i3;
        a.b("ECShowWindowFragment", "[initArguments] mediaId = " + this.mediaId + ", mediaName = " + this.mediaName + ", isMaster = " + this.isMaster + ", deliverProductCallId = " + this.deliverProductCallbackId + ", channel = " + this.channel + ", sourceFrom = " + this.sourceFrom + ", isNightMode = " + this.isCurrentNightMode + ", windowType = " + this.windowType + ", liveUserId = " + this.liveUserId + ", liveRoomId = " + this.liveRoomId);
    }

    public static final /* synthetic */ View ji(ECShowWindowFragment eCShowWindowFragment) {
        View view = eCShowWindowFragment.manageButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageButton");
        }
        return view;
    }

    private final void jj() {
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel.R2().observe(getViewLifecycleOwner(), new m());
    }

    private final void kj() {
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel.m2().observe(getViewLifecycleOwner(), new Observer<Boolean>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECShowWindowFragment$registerBackToTopLiveDataObserver$1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(Boolean bool) {
                if (bool.booleanValue()) {
                    ECShowWindowFragment.ni(ECShowWindowFragment.this).post(new Runnable() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECShowWindowFragment$registerBackToTopLiveDataObserver$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            RecyclerView.LayoutManager layoutManager = ECShowWindowFragment.ni(ECShowWindowFragment.this).getLayoutManager();
                            if (layoutManager != null) {
                                layoutManager.scrollToPosition(0);
                            }
                        }
                    });
                }
            }
        });
    }

    public static final /* synthetic */ ECMsgBox li(ECShowWindowFragment eCShowWindowFragment) {
        ECMsgBox eCMsgBox = eCShowWindowFragment.msgBox;
        if (eCMsgBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgBox");
        }
        return eCMsgBox;
    }

    private final void lj() {
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel.p2().observe(getViewLifecycleOwner(), new n());
    }

    public static final /* synthetic */ ECShowWindowProductListAdapter mi(ECShowWindowFragment eCShowWindowFragment) {
        ECShowWindowProductListAdapter eCShowWindowProductListAdapter = eCShowWindowFragment.productListAdapter;
        if (eCShowWindowProductListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productListAdapter");
        }
        return eCShowWindowProductListAdapter;
    }

    private final void mj() {
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel.s2().observe(getViewLifecycleOwner(), new o());
        ECShowWindowViewModel eCShowWindowViewModel2 = this.viewModel;
        if (eCShowWindowViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel2.H2().observe(getViewLifecycleOwner(), new p());
    }

    public static final /* synthetic */ ECBaseRecyclerView ni(ECShowWindowFragment eCShowWindowFragment) {
        ECBaseRecyclerView eCBaseRecyclerView = eCShowWindowFragment.productListView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productListView");
        }
        return eCBaseRecyclerView;
    }

    private final void nj() {
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel.t2().observe(getViewLifecycleOwner(), new q());
    }

    private final void oj() {
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel.T2().observe(getViewLifecycleOwner(), new r());
    }

    public static final /* synthetic */ LinearLayout pi(ECShowWindowFragment eCShowWindowFragment) {
        LinearLayout linearLayout = eCShowWindowFragment.searchBar;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        }
        return linearLayout;
    }

    private final void pj() {
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel.V2().observe(getViewLifecycleOwner(), new s());
    }

    public static final /* synthetic */ TextView qi(ECShowWindowFragment eCShowWindowFragment) {
        TextView textView = eCShowWindowFragment.searchCancel;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchCancel");
        }
        return textView;
    }

    private final void qj() {
        wj();
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel.n2().observe(getViewLifecycleOwner(), new t());
        ECShowWindowViewModel eCShowWindowViewModel2 = this.viewModel;
        if (eCShowWindowViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel2.A2().observe(getViewLifecycleOwner(), new u());
        ECShowWindowViewModel eCShowWindowViewModel3 = this.viewModel;
        if (eCShowWindowViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel3.o2().observe(getViewLifecycleOwner(), new v());
        ECShowWindowViewModel eCShowWindowViewModel4 = this.viewModel;
        if (eCShowWindowViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel4.q2().observe(getViewLifecycleOwner(), new w());
        if (this.isMaster) {
            mj();
        }
        vj();
        lj();
        uj();
        tj();
        kj();
        xj();
        nj();
        oj();
        sj();
        pj();
        if (fj()) {
            rj();
        }
        jj();
    }

    public static final /* synthetic */ TextView ri(ECShowWindowFragment eCShowWindowFragment) {
        TextView textView = eCShowWindowFragment.searchTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchTextView");
        }
        return textView;
    }

    private final void rj() {
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel.D2().observe(getViewLifecycleOwner(), new x());
        ECShowWindowViewModel eCShowWindowViewModel2 = this.viewModel;
        if (eCShowWindowViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel2.H2().observe(getViewLifecycleOwner(), new y());
        ECShowWindowViewModel eCShowWindowViewModel3 = this.viewModel;
        if (eCShowWindowViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel3.v2().observe(getViewLifecycleOwner(), new z());
    }

    public static final /* synthetic */ ImageView si(ECShowWindowFragment eCShowWindowFragment) {
        ImageView imageView = eCShowWindowFragment.selectAllButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectAllButton");
        }
        return imageView;
    }

    private final void sj() {
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel.S2().observe(getViewLifecycleOwner(), new aa());
    }

    public static final /* synthetic */ TextView ti(ECShowWindowFragment eCShowWindowFragment) {
        TextView textView = eCShowWindowFragment.selectedCategoryTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedCategoryTextView");
        }
        return textView;
    }

    private final void tj() {
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel.r2().observe(getViewLifecycleOwner(), new ab());
    }

    public static final /* synthetic */ TextView ui(ECShowWindowFragment eCShowWindowFragment) {
        TextView textView = eCShowWindowFragment.selectedNumberTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedNumberTextView");
        }
        return textView;
    }

    private final void uj() {
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel.C2().observe(getViewLifecycleOwner(), new ac());
    }

    public static final /* synthetic */ ImageView vi(ECShowWindowFragment eCShowWindowFragment) {
        ImageView imageView = eCShowWindowFragment.setTopButtonIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setTopButtonIcon");
        }
        return imageView;
    }

    private final void vj() {
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel.E2().observe(getViewLifecycleOwner(), new ad());
    }

    public static final /* synthetic */ TextView wi(ECShowWindowFragment eCShowWindowFragment) {
        TextView textView = eCShowWindowFragment.setTopButtonText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setTopButtonText");
        }
        return textView;
    }

    private final void wj() {
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel.F2().observe(getViewLifecycleOwner(), new ECShowWindowFragment$registerTotalRspObserver$$inlined$observe$1(this));
    }

    private final void xj() {
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel.J2().observe(getViewLifecycleOwner(), new ae());
    }

    public static final /* synthetic */ TextView yi(ECShowWindowFragment eCShowWindowFragment) {
        TextView textView = eCShowWindowFragment.titleTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        }
        return textView;
    }

    public static final /* synthetic */ ECShowWindowViewModel zi(ECShowWindowFragment eCShowWindowFragment) {
        ECShowWindowViewModel eCShowWindowViewModel = eCShowWindowFragment.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return eCShowWindowViewModel;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Dh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECShowWindowFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.crf;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && data.getBooleanExtra("arg_has_clicked_search_btn", false)) {
            String stringExtra = data.getStringExtra("arg_query_string");
            if (stringExtra != null) {
                ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
                if (eCShowWindowViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                eCShowWindowViewModel.s3(stringExtra);
                zj(this, null, false, false, 7, null);
                if (fj()) {
                    ei0.c cVar = ei0.c.f396302a;
                    LinearLayout linearLayout = this.searchBar;
                    if (linearLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                    }
                    cVar.h(linearLayout, stringExtra);
                    return;
                }
                return;
            }
            return;
        }
        ECShowWindowViewModel eCShowWindowViewModel2 = this.viewModel;
        if (eCShowWindowViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (TextUtils.isEmpty(eCShowWindowViewModel2.r2().getValue())) {
            return;
        }
        ECShowWindowViewModel eCShowWindowViewModel3 = this.viewModel;
        if (eCShowWindowViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel3.s3("");
        zj(this, null, false, false, 7, null);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        if (fj()) {
            ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
            if (eCShowWindowViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (Intrinsics.areEqual(eCShowWindowViewModel.v2().getValue(), Boolean.TRUE)) {
                Qi();
                return true;
            }
        }
        return super.onBackPressed();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(1);
        }
        initArguments();
        ECShowWindowViewModel eCShowWindowViewModel = (ECShowWindowViewModel) new ViewModelProvider(this).get(ECShowWindowViewModel.class);
        Bundle arguments = getArguments();
        if (arguments != null) {
            eCShowWindowViewModel.Q2(arguments);
        }
        eCShowWindowViewModel.f3(gj());
        eCShowWindowViewModel.h3(this.showPageCostTime);
        Unit unit = Unit.INSTANCE;
        this.viewModel = eCShowWindowViewModel;
        com.tencent.ecommerce.biz.util.r.f104881b.e(getActivity(), true);
        LifecycleEventBus.f100688b.d(ThreadMode.ORIGIN, ECAddProductToWindowEvent.class, this.addProductEventObserve);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel.j2();
        wh0.a.f445642d.c(this.isMaster);
        LifecycleEventBus.f100688b.e(this.addProductEventObserve);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.isMaster) {
            com.tencent.ecommerce.biz.common.d.f101554a.b(this.channel, "window_exit", this.windowType);
            ECRMonitorManager.f100953c.b("EC_STAGE_SHOW_WINDOW_HOST");
        } else {
            com.tencent.ecommerce.biz.common.d.f101554a.a(this.channel, this.mediaId, com.tencent.ecommerce.biz.register.b.f103963a.a(), this.sourceFrom, "window_exit_by_customer");
            ECRMonitorManager.f100953c.b("EC_STAGE_SHOW_WINDOW_GUEST");
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.isMaster) {
            com.tencent.ecommerce.biz.common.d.f101554a.c(this.channel, "window_exp", this.windowType);
            ECRMonitorManager.f100953c.c("EC_STAGE_SHOW_WINDOW_HOST");
        } else {
            com.tencent.ecommerce.biz.common.d.f101554a.a(this.channel, this.mediaId, com.tencent.ecommerce.biz.register.b.f103963a.a(), this.sourceFrom, "window_exp_to_customer");
            com.tencent.ecommerce.base.report.service.g.c(this.mediaId);
            ECRMonitorManager.f100953c.c("EC_STAGE_SHOW_WINDOW_GUEST");
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        Ui(view);
        bj(view);
        Vi(view);
        Xi(view);
        Wi();
        Zi();
        cj(view);
        Yi();
        aj();
        qj();
        zj(this, null, false, true, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ij(boolean isMaster, Product product) {
        if (isMaster) {
            wh0.a.f445642d.f(product.getSaasProductId(), product.getSaasTypeStr(), product.getGoodsType());
        } else {
            wh0.a.f445642d.e(product.getSaasProductId(), String.valueOf(product.getGoodsType()), String.valueOf(0));
        }
    }

    private final void yj(String cookie, boolean loadMore, boolean firstScreen) {
        String valueOf;
        if (this.isMaster) {
            Bundle bundle = new Bundle();
            bundle.putLong("roomId", this.liveRoomId);
            bundle.putString("userId", this.liveUserId);
            ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
            if (eCShowWindowViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            ECShowWindowViewModel eCShowWindowViewModel2 = this.viewModel;
            if (eCShowWindowViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            String value = eCShowWindowViewModel2.r2().getValue();
            if (value == null) {
                value = "";
            }
            ECShowWindowViewModel eCShowWindowViewModel3 = this.viewModel;
            if (eCShowWindowViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            Category value2 = eCShowWindowViewModel3.q2().getValue();
            eCShowWindowViewModel.y2(1, value, (value2 == null || (valueOf = String.valueOf(value2.id)) == null) ? "" : valueOf, this.windowType, cookie, loadMore, firstScreen, bundle, this.source);
            return;
        }
        ECShowWindowViewModel eCShowWindowViewModel4 = this.viewModel;
        if (eCShowWindowViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShowWindowViewModel4.I2(1, this.mediaId, this.sellerUin, cookie, loadMore, this.isCurrentNightMode);
    }

    private final void Ui(View rootView) {
        this.backButton = (ImageView) rootView.findViewById(R.id.o18);
        this.finishedButton = rootView.findViewById(R.id.odm);
        this.addProductButton = rootView.findViewById(R.id.o2q);
        this.manageBar = (FrameLayout) rootView.findViewById(R.id.nzf);
        this.manageButton = rootView.findViewById(R.id.f163058o30);
        this.addProductButtonOld = rootView.findViewById(R.id.o2r);
        this.searchBarContainer = rootView.findViewById(R.id.o9u);
        this.searchBar = (LinearLayout) rootView.findViewById(R.id.nzi);
        this.searchTextView = (TextView) rootView.findViewById(R.id.oe8);
        this.searchIconAndText = (LinearLayout) rootView.findViewById(R.id.o3c);
        this.searchCancel = (TextView) rootView.findViewById(R.id.oe7);
        this.editToolBar = rootView.findViewById(R.id.o9_);
        this.selectedNumberTextView = (TextView) rootView.findViewById(R.id.oeb);
        this.selectedAllNumberTextView = (TextView) rootView.findViewById(R.id.oe_);
        this.selectedCategoryTextView = (TextView) rootView.findViewById(R.id.oea);
        this.categoryIcon = (ImageView) rootView.findViewById(R.id.o1a);
        this.categoryPanel = (FrameLayout) rootView.findViewById(R.id.nz_);
        this.categoryButton = (LinearLayout) rootView.findViewById(R.id.o2u);
        this.setTopButton = rootView.findViewById(R.id.o3f);
        this.setTopButtonText = (TextView) rootView.findViewById(R.id.oed);
        this.setTopButtonIcon = (ImageView) rootView.findViewById(R.id.o1w);
        this.deleteButton = rootView.findViewById(R.id.o2y);
        this.deleteButtonText = (TextView) rootView.findViewById(R.id.odj);
        this.deleteButtonIcon = (ImageView) rootView.findViewById(R.id.o1h);
        this.deleteConfirmDialogContainer = (FrameLayout) rootView.findViewById(R.id.nza);
        this.titleTextView = (TextView) rootView.findViewById(R.id.oer);
        this.selectAllButton = (ImageView) rootView.findViewById(R.id.o1v);
        View view = this.manageButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageButton");
        }
        view.setOnClickListener(new c());
        View view2 = this.finishedButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("finishedButton");
        }
        view2.setOnClickListener(new d());
        ImageView imageView = this.backButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        }
        imageView.setOnClickListener(new e());
        ((Button) rootView.findViewById(R.id.o2s)).setOnClickListener(new f());
        View view3 = this.addProductButtonOld;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addProductButtonOld");
        }
        view3.setOnClickListener(new g());
        FrameLayout frameLayout = this.categoryPanel;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryPanel");
        }
        frameLayout.setOnClickListener(new h());
        TextView textView = this.searchCancel;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchCancel");
        }
        textView.setOnClickListener(new i());
        Cj();
        Ej();
        Gj();
        Dj();
        Fj();
        Bj();
        ECDebugUtils eCDebugUtils = ECDebugUtils.f104852b;
        TextView textView2 = this.titleTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        }
        eCDebugUtils.e(textView2);
    }

    private final void Vi(View rootView) {
        this.categoryGridView = (GridView) rootView.findViewById(R.id.o0o);
        Context requireContext = requireContext();
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        this.categoryListAdapter = new com.tencent.ecommerce.biz.showwindow.ui.adapter.b(requireContext, eCShowWindowViewModel);
        GridView gridView = this.categoryGridView;
        if (gridView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryGridView");
        }
        com.tencent.ecommerce.biz.showwindow.ui.adapter.b bVar = this.categoryListAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryListAdapter");
        }
        gridView.setAdapter((ListAdapter) bVar);
    }

    private final void Xi(View rootView) {
        this.emptyContainer = (FrameLayout) rootView.findViewById(R.id.nzb);
        this.emptyPtsComposer = gh0.d.f402041a.b("empty_page_card", ECPTSStyleManager.e("empty_page_card", requireContext()), "", new j());
        PTSItemView pTSItemView = new PTSItemView(requireContext());
        PTSComposer pTSComposer = this.emptyPtsComposer;
        if (pTSComposer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyPtsComposer");
        }
        pTSComposer.layoutToView(pTSItemView);
        FrameLayout frameLayout = this.emptyContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyContainer");
        }
        frameLayout.addView(pTSItemView);
    }

    private final void bj(View rootView) {
        this.productListView = (ECBaseRecyclerView) rootView.findViewById(R.id.f163065o41);
        Context requireContext = requireContext();
        ECShowWindowViewModel eCShowWindowViewModel = this.viewModel;
        if (eCShowWindowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        this.productListAdapter = new ECShowWindowProductListAdapter(requireContext, eCShowWindowViewModel, this.deliverProductCallback, this.isMaster, this.channel, this.mediaId, this.windowType);
        ECBaseRecyclerView eCBaseRecyclerView = this.productListView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productListView");
        }
        ECShowWindowProductListAdapter eCShowWindowProductListAdapter = this.productListAdapter;
        if (eCShowWindowProductListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productListAdapter");
        }
        eCBaseRecyclerView.setAdapter(eCShowWindowProductListAdapter);
        ECBaseRecyclerView eCBaseRecyclerView2 = this.productListView;
        if (eCBaseRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productListView");
        }
        eCBaseRecyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        ECBaseRecyclerView eCBaseRecyclerView3 = this.productListView;
        if (eCBaseRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productListView");
        }
        eCBaseRecyclerView3.addOnScrollListener(new k());
    }

    private final void initViews(View rootView) {
        this.containerView = rootView.findViewById(R.id.nup);
        this.loadingPage = (FrameLayout) rootView.findViewById(R.id.nze);
        this.loadingIcon = (ImageView) rootView.findViewById(R.id.o1l);
        this.animaContainer = (RelativeLayout) rootView.findViewById(R.id.o98);
    }

    static /* synthetic */ void zj(ECShowWindowFragment eCShowWindowFragment, String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        eCShowWindowFragment.yj(str, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ri() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oi(float bottomMargin) {
    }
}
