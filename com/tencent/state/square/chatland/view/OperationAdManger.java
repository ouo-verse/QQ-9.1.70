package com.tencent.state.square.chatland.view;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.template.data.OperationAd;
import com.tencent.state.template.data.OperationAdVideo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003H\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J$\u0010\u0015\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0018R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/square/chatland/view/OperationAdManger;", "", ParseCommon.CONTAINER, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/state/square/chatland/view/IViewContainer;", "(Ljava/lang/ref/WeakReference;)V", "ads", "", "Lcom/tencent/state/template/data/OperationAd;", "chatLandOperationAdBgView", "Lcom/tencent/state/square/chatland/view/ChatLandOperationAdBgView;", "chatLandOperationAdVideoView", "Lcom/tencent/state/square/chatland/view/ChatLandOperationAdVideoView;", "ctx", "Landroid/content/Context;", "currentAd", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "", "destroy", "getVideoLocation", "Landroid/graphics/Rect;", "init", "onVisibilityChanged", NodeProps.VISIBLE, "", "isFragment", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class OperationAdManger {
    private static final String TAG = "OperationAdManger";
    private List<OperationAd> ads;
    private ChatLandOperationAdBgView chatLandOperationAdBgView;
    private ChatLandOperationAdVideoView chatLandOperationAdVideoView;
    private final WeakReference<IViewContainer> container;
    private WeakReference<Context> ctx;
    private OperationAd currentAd;

    public OperationAdManger(WeakReference<IViewContainer> container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.container = container;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createView() {
        OperationAd operationAd;
        Unit unit;
        Object obj;
        final long serverTime = Square.INSTANCE.getConfig().getCommonUtils().getServerTime();
        List<OperationAd> list = this.ads;
        Object obj2 = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                OperationAd operationAd2 = (OperationAd) obj;
                if (operationAd2.getStartTs() <= serverTime && operationAd2.getEndTs() >= serverTime) {
                    break;
                }
            }
            operationAd = (OperationAd) obj;
        } else {
            operationAd = null;
        }
        this.currentAd = operationAd;
        if (operationAd != null) {
            createView(this.ctx);
            ChatLandOperationAdVideoView chatLandOperationAdVideoView = this.chatLandOperationAdVideoView;
            if (chatLandOperationAdVideoView != null) {
                chatLandOperationAdVideoView.update(operationAd);
            }
            ChatLandOperationAdBgView chatLandOperationAdBgView = this.chatLandOperationAdBgView;
            if (chatLandOperationAdBgView != null) {
                chatLandOperationAdBgView.update(operationAd);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        ChatLandOperationAdVideoView chatLandOperationAdVideoView2 = this.chatLandOperationAdVideoView;
        if (chatLandOperationAdVideoView2 != null) {
            chatLandOperationAdVideoView2.hide();
        }
        ChatLandOperationAdBgView chatLandOperationAdBgView2 = this.chatLandOperationAdBgView;
        if (chatLandOperationAdBgView2 != null) {
            chatLandOperationAdBgView2.hide();
        }
        List<OperationAd> list2 = this.ads;
        if (list2 != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj3 : list2) {
                if (((OperationAd) obj3).getStartTs() > serverTime) {
                    arrayList.add(obj3);
                }
            }
            Iterator it5 = arrayList.iterator();
            if (it5.hasNext()) {
                obj2 = it5.next();
                if (it5.hasNext()) {
                    long startTs = ((OperationAd) obj2).getStartTs();
                    do {
                        Object next = it5.next();
                        long startTs2 = ((OperationAd) next).getStartTs();
                        if (startTs > startTs2) {
                            obj2 = next;
                            startTs = startTs2;
                        }
                    } while (it5.hasNext());
                }
            }
            final OperationAd operationAd3 = (OperationAd) obj2;
            if (operationAd3 != null) {
                SquareBaseKt.getSquareThread().postOnUiDelayed((operationAd3.getStartTs() - serverTime) * 1000, new Function0<Unit>() { // from class: com.tencent.state.square.chatland.view.OperationAdManger$createView$$inlined$run$lambda$1
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
                        WeakReference weakReference;
                        ChatLandOperationAdVideoView chatLandOperationAdVideoView3;
                        ChatLandOperationAdBgView chatLandOperationAdBgView3;
                        this.currentAd = OperationAd.this;
                        OperationAdManger operationAdManger = this;
                        weakReference = operationAdManger.ctx;
                        operationAdManger.createView(weakReference);
                        chatLandOperationAdVideoView3 = this.chatLandOperationAdVideoView;
                        if (chatLandOperationAdVideoView3 != null) {
                            chatLandOperationAdVideoView3.update(OperationAd.this);
                        }
                        chatLandOperationAdBgView3 = this.chatLandOperationAdBgView;
                        if (chatLandOperationAdBgView3 != null) {
                            chatLandOperationAdBgView3.update(OperationAd.this);
                        }
                    }
                });
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    public final void destroy() {
        ChatLandOperationAdBgView chatLandOperationAdBgView = this.chatLandOperationAdBgView;
        if (chatLandOperationAdBgView != null) {
            chatLandOperationAdBgView.destroy();
        }
        ChatLandOperationAdVideoView chatLandOperationAdVideoView = this.chatLandOperationAdVideoView;
        if (chatLandOperationAdVideoView != null) {
            chatLandOperationAdVideoView.destroy();
        }
    }

    public final Rect getVideoLocation() {
        OperationAdVideo video;
        OperationAd operationAd = this.currentAd;
        if (operationAd == null || (video = operationAd.getVideo()) == null) {
            return null;
        }
        return video.getItemPosition();
    }

    public final void init(WeakReference<Context> ctx, List<OperationAd> ads) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (ads == null || ads.isEmpty()) {
            return;
        }
        this.ctx = ctx;
        this.ads = ads;
        createView();
    }

    public final void onVisibilityChanged(boolean visible, boolean isFragment) {
        ChatLandOperationAdVideoView chatLandOperationAdVideoView = this.chatLandOperationAdVideoView;
        if (chatLandOperationAdVideoView == null || !chatLandOperationAdVideoView.checkViewVisible()) {
            return;
        }
        if (visible) {
            ChatLandOperationAdVideoView chatLandOperationAdVideoView2 = this.chatLandOperationAdVideoView;
            if (chatLandOperationAdVideoView2 != null) {
                chatLandOperationAdVideoView2.resume(isFragment);
                return;
            }
            return;
        }
        ChatLandOperationAdVideoView chatLandOperationAdVideoView3 = this.chatLandOperationAdVideoView;
        if (chatLandOperationAdVideoView3 != null) {
            chatLandOperationAdVideoView3.pause(isFragment);
        }
    }

    public static /* synthetic */ void onVisibilityChanged$default(OperationAdManger operationAdManger, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        operationAdManger.onVisibilityChanged(z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createView(WeakReference<Context> ctx) {
        Context context;
        if (ctx == null || (context = ctx.get()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "ctx?.get() ?: return");
        IViewContainer iViewContainer = this.container.get();
        if (iViewContainer != null) {
            Intrinsics.checkNotNullExpressionValue(iViewContainer, "container.get() ?: return");
            if (this.chatLandOperationAdVideoView == null) {
                ChatLandOperationAdVideoView chatLandOperationAdVideoView = new ChatLandOperationAdVideoView(context, null, 0, new IVideoListener() { // from class: com.tencent.state.square.chatland.view.OperationAdManger$createView$4
                    @Override // com.tencent.state.square.chatland.view.IVideoListener
                    public void onPlayEnd() {
                        SquareBaseKt.getSquareLog().i("OperationAdManger", "IVideoListener = onPlayEnd");
                        OperationAdManger.this.createView();
                    }

                    @Override // com.tencent.state.square.chatland.view.IVideoListener
                    public void onPrepared() {
                        SquareBaseKt.getSquareLog().i("OperationAdManger", "IVideoListener = onPrepared");
                    }
                }, 6, null);
                iViewContainer.addToMap(chatLandOperationAdVideoView);
                this.chatLandOperationAdVideoView = chatLandOperationAdVideoView;
            }
            if (this.chatLandOperationAdBgView == null) {
                ChatLandOperationAdBgView chatLandOperationAdBgView = new ChatLandOperationAdBgView(context, null, 0, 6, null);
                iViewContainer.addToMap(chatLandOperationAdBgView);
                this.chatLandOperationAdBgView = chatLandOperationAdBgView;
            }
        }
    }
}
