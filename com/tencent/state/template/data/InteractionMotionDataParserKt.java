package com.tencent.state.template.data;

import android.app.Application;
import android.util.Size;
import bt4.f;
import com.tencent.state.data.Gender;
import com.tencent.state.data.UserCommon;
import com.tencent.state.service.UserFormatKt;
import com.tencent.state.square.Square;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.Resource;
import com.tencent.state.template.data.ActionType;
import com.tencent.state.template.data.Dpi;
import com.tencent.state.template.data.InterPlaceholderInfo;
import com.tencent.state.template.data.InterReceiverInfo;
import com.tencent.state.template.data.InterResourceInfo;
import com.tencent.state.template.data.InterSenderInfo;
import com.tencent.state.template.data.InteractionMotionInfo;
import com.tencent.state.template.data.MotionDpi;
import com.tencent.state.template.data.StyleType;
import fs4.g;
import fs4.h;
import fs4.i;
import fs4.u;
import hs4.b;
import hs4.l;
import hs4.r;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0007*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0007\u001a\u0014\u0010\f\u001a\u00020\u000b*\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\t\u001a\u0014\u0010\f\u001a\u00020\u0010*\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u001a\u0014\u0010\f\u001a\u00020\u0014*\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u001a\u0012\u0010\f\u001a\u00020\u0018*\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0016\u001a\u0014\u0010\f\u001a\u00020\u001c*\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u001a\u0014\u0010\f\u001a\u00020 *\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u001a\u0014\u0010\f\u001a\u00020$*\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\"\u00a8\u0006%"}, d2 = {"Lcom/tencent/state/template/data/StyleType$Companion;", "", "value", "Lcom/tencent/state/template/data/StyleType;", "parseInt", "toInt", "Lcom/tencent/state/template/data/ActionType$Companion;", "Lcom/tencent/state/template/data/ActionType;", "Lcom/tencent/state/template/data/Dpi$Companion;", "Lhs4/b;", "dpi", "Lcom/tencent/state/template/data/Dpi;", "parsePB", "Lcom/tencent/state/template/data/MotionDpi$Companion;", "Lhs4/l;", "motionDpi", "Lcom/tencent/state/template/data/MotionDpi;", "Lcom/tencent/state/template/data/InteractionMotionInfo$Companion;", "Lbt4/f;", "motionInfo", "Lcom/tencent/state/template/data/InteractionMotionInfo;", "Lcom/tencent/state/template/data/InterSenderInfo$Companion;", "Lfs4/i;", "senderInfo", "Lcom/tencent/state/template/data/InterSenderInfo;", "Lcom/tencent/state/template/data/InterPlaceholderInfo$Companion;", "Lfs4/f;", "placeholderInfo", "Lcom/tencent/state/template/data/InterPlaceholderInfo;", "Lcom/tencent/state/template/data/InterReceiverInfo$Companion;", "Lfs4/g;", "receiverInfo", "Lcom/tencent/state/template/data/InterReceiverInfo;", "Lcom/tencent/state/template/data/InterResourceInfo$Companion;", "Lfs4/h;", "resourceInfo", "Lcom/tencent/state/template/data/InterResourceInfo;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionMotionDataParserKt {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[StyleType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[StyleType.STYLE_NONE.ordinal()] = 1;
            iArr[StyleType.STYLE_OLD.ordinal()] = 2;
            iArr[StyleType.STYLE_NEW.ordinal()] = 3;
            int[] iArr2 = new int[ActionType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ActionType.ACTION_EASY.ordinal()] = 1;
            iArr2[ActionType.ACTION_MULTI.ordinal()] = 2;
            iArr2[ActionType.ACTION_NORECORD.ordinal()] = 3;
        }
    }

    public static final StyleType parseInt(StyleType.Companion parseInt, int i3) {
        Intrinsics.checkNotNullParameter(parseInt, "$this$parseInt");
        if (i3 == 0) {
            return StyleType.STYLE_NONE;
        }
        if (i3 == 1) {
            return StyleType.STYLE_OLD;
        }
        if (i3 != 2) {
            return StyleType.STYLE_NONE;
        }
        return StyleType.STYLE_NEW;
    }

    public static final Dpi parsePB(Dpi.Companion parsePB, b bVar) {
        Intrinsics.checkNotNullParameter(parsePB, "$this$parsePB");
        return new Dpi(bVar != null ? bVar.f406127a : 0, bVar != null ? bVar.f406128b : 0);
    }

    public static final int toInt(StyleType toInt) {
        Intrinsics.checkNotNullParameter(toInt, "$this$toInt");
        int i3 = WhenMappings.$EnumSwitchMapping$0[toInt.ordinal()];
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 3) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int toInt(ActionType toInt) {
        Intrinsics.checkNotNullParameter(toInt, "$this$toInt");
        int i3 = WhenMappings.$EnumSwitchMapping$1[toInt.ordinal()];
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 3) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final ActionType parseInt(ActionType.Companion parseInt, int i3) {
        Intrinsics.checkNotNullParameter(parseInt, "$this$parseInt");
        if (i3 == 0) {
            return ActionType.ACTION_EASY;
        }
        if (i3 == 1) {
            return ActionType.ACTION_MULTI;
        }
        if (i3 != 2) {
            return ActionType.ACTION_EASY;
        }
        return ActionType.ACTION_NORECORD;
    }

    public static final MotionDpi parsePB(MotionDpi.Companion parsePB, l lVar) {
        Intrinsics.checkNotNullParameter(parsePB, "$this$parsePB");
        Dpi.Companion companion = Dpi.INSTANCE;
        return new MotionDpi(parsePB(companion, lVar != null ? lVar.f406166a : null), parsePB(companion, lVar != null ? lVar.f406167b : null));
    }

    public static final InteractionMotionInfo parsePB(InteractionMotionInfo.Companion parsePB, f fVar) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(parsePB, "$this$parsePB");
        return new InteractionMotionInfo((fVar == null || (str2 = fVar.f29116a) == null) ? "" : str2, (fVar == null || (str = fVar.f29117b) == null) ? "" : str, fVar != null ? fVar.f29118c : 0, parsePB(MotionDpi.INSTANCE, fVar != null ? fVar.f29119d : null), parseInt(StyleType.INSTANCE, fVar != null ? fVar.f29120e : 0), fVar != null ? fVar.f29121f : null);
    }

    public static final InterSenderInfo parsePB(InterSenderInfo.Companion parsePB, i senderInfo) {
        Intrinsics.checkNotNullParameter(parsePB, "$this$parsePB");
        Intrinsics.checkNotNullParameter(senderInfo, "senderInfo");
        r rVar = senderInfo.f400525a;
        Intrinsics.checkNotNullExpressionValue(rVar, "senderInfo.interactionResource");
        Resource formatActionResource$default = UserFormatKt.formatActionResource$default(rVar, false, senderInfo.f400528d, 2, null);
        l lVar = senderInfo.f400525a.f406194d;
        b bVar = lVar.f406167b;
        b bVar2 = lVar.f406166a;
        Application application = Square.INSTANCE.getApplication();
        formatActionResource$default.setShowSize(new Size(ViewExtensionsKt.calPx(application, bVar.f406127a), ViewExtensionsKt.calPx(application, bVar.f406128b)));
        formatActionResource$default.setRecordSize(new Size(ViewExtensionsKt.calPx(application, bVar2.f406127a), ViewExtensionsKt.calPx(application, bVar2.f406128b)));
        u uVar = senderInfo.f400526b;
        Intrinsics.checkNotNullExpressionValue(uVar, "senderInfo.profile");
        return new InterSenderInfo(formatActionResource$default, CommonDataParserKt.parse(uVar, senderInfo.f400527c), senderInfo.f400527c);
    }

    public static final InterPlaceholderInfo parsePB(InterPlaceholderInfo.Companion parsePB, fs4.f fVar) {
        String str;
        Intrinsics.checkNotNullParameter(parsePB, "$this$parsePB");
        if (fVar == null || (str = fVar.f400517a) == null) {
            str = "";
        }
        return new InterPlaceholderInfo(str, parsePB(Dpi.INSTANCE, fVar != null ? fVar.f400518b : null));
    }

    public static final InterReceiverInfo parsePB(InterReceiverInfo.Companion parsePB, g gVar) {
        UserCommon userCommon;
        u uVar;
        Intrinsics.checkNotNullParameter(parsePB, "$this$parsePB");
        long j3 = gVar != null ? gVar.f400521c : 0L;
        if (gVar == null || (uVar = gVar.f400520b) == null || (userCommon = CommonDataParserKt.parse(uVar, gVar.f400521c)) == null) {
            userCommon = new UserCommon(0L, "", "", Gender.UNKNOWN);
        }
        return new InterReceiverInfo(parsePB(InterPlaceholderInfo.INSTANCE, gVar != null ? gVar.f400519a : null), userCommon, j3);
    }

    public static final InterResourceInfo parsePB(InterResourceInfo.Companion parsePB, h hVar) {
        String str;
        i iVar;
        Intrinsics.checkNotNullParameter(parsePB, "$this$parsePB");
        if (hVar == null || (str = hVar.f400524c) == null) {
            str = "";
        }
        InterSenderInfo.Companion companion = InterSenderInfo.INSTANCE;
        if (hVar == null || (iVar = hVar.f400522a) == null) {
            iVar = new i();
        }
        return new InterResourceInfo(str, parsePB(companion, iVar), parsePB(InterReceiverInfo.INSTANCE, hVar != null ? hVar.f400523b : null));
    }
}
