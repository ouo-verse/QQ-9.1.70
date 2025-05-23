package com.tencent.state.square.message;

import com.tencent.state.data.SquareJSConst;
import com.tencent.state.service.VasSquareProfileService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.SquareUserInfo;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ(\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\fJF\u0010\t\u001a\u00020\b2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000ej\b\u0012\u0004\u0012\u00020\u0005`\u000f2&\u0010\u000b\u001a\"\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u000f\u0012\u0004\u0012\u00020\b0\u0010R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/message/StrangerNickManager;", "", "()V", "nickMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", QCircleLpReportDc05507.KEY_CLEAR, "", "getStrangerNick", "uin", "callback", "Lkotlin/Function2;", SquareJSConst.Params.PARAMS_UIN_LIST, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/Function1;", "Lcom/tencent/state/square/data/SquareUserInfo;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class StrangerNickManager {
    private static final String TAG = "StrangerNickManager";
    private final HashMap<String, String> nickMap = new HashMap<>();

    public final void clear() {
        this.nickMap.clear();
    }

    public final void getStrangerNick(final String uin, final Function2<? super String, ? super String, Unit> callback) {
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str = this.nickMap.get(uin);
        if (str == null || str.length() == 0) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(uin);
            VasSquareProfileService.INSTANCE.getUserProfile(arrayListOf, new Function1<ArrayList<SquareUserInfo>, Unit>() { // from class: com.tencent.state.square.message.StrangerNickManager$getStrangerNick$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ArrayList<SquareUserInfo> arrayList) {
                    invoke2(arrayList);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
                
                    if (r0 != null) goto L25;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(ArrayList<SquareUserInfo> arrayList) {
                    SquareUserInfo squareUserInfo;
                    String friendRemarkName;
                    HashMap hashMap;
                    String nick;
                    Object obj;
                    if (arrayList != null) {
                        Iterator<T> it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            } else {
                                obj = it.next();
                                if (Intrinsics.areEqual(((SquareUserInfo) obj).getUin(), uin)) {
                                    break;
                                }
                            }
                        }
                        squareUserInfo = (SquareUserInfo) obj;
                    } else {
                        squareUserInfo = null;
                    }
                    if (squareUserInfo != null && (nick = squareUserInfo.getNick()) != null) {
                        friendRemarkName = nick.length() > 0 ? nick : null;
                    }
                    ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                    String str2 = uin;
                    friendRemarkName = squareCommon.getFriendRemarkName(str2, str2);
                    hashMap = StrangerNickManager.this.nickMap;
                    hashMap.put(uin, friendRemarkName);
                    callback.invoke(uin, friendRemarkName);
                }
            });
        } else {
            if (str.length() == 0) {
                str = SquareBaseKt.getSquareCommon().getFriendRemarkName(uin, uin);
            }
            callback.invoke(uin, str);
        }
    }

    public final void getStrangerNick(ArrayList<String> uinList, final Function1<? super ArrayList<SquareUserInfo>, Unit> callback) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        VasSquareProfileService.INSTANCE.getUserProfile(uinList, new Function1<ArrayList<SquareUserInfo>, Unit>() { // from class: com.tencent.state.square.message.StrangerNickManager$getStrangerNick$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<SquareUserInfo> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<SquareUserInfo> arrayList) {
                HashMap hashMap;
                if (arrayList != null) {
                    for (SquareUserInfo squareUserInfo : arrayList) {
                        hashMap = StrangerNickManager.this.nickMap;
                        hashMap.put(squareUserInfo.getUin(), squareUserInfo.getNick());
                    }
                }
                callback.invoke(arrayList);
            }
        });
    }
}
