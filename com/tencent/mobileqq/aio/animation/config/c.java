package com.tencent.mobileqq.aio.animation.config;

import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.util.NumberUtil;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u001e\u0010\f\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/config/c;", "", "Lorg/xmlpull/v1/XmlPullParser;", "parser", "Lcom/tencent/mobileqq/aio/animation/config/e;", "f", "", "key", "", "defValue", "a", "", "c", "Lcom/tencent/mobileqq/aio/animation/config/f;", "e", "tagName", "Lcom/tencent/mobileqq/aio/animation/config/a;", TransferConfig.ExtendParamFloats.KEY_RULE, "", "g", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final float a(XmlPullParser xmlPullParser, String str, float f16) {
        return NumberUtil.stringToFloat(xmlPullParser.getAttributeValue(null, str), f16);
    }

    static /* synthetic */ float b(c cVar, XmlPullParser xmlPullParser, String str, float f16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f16 = 0.0f;
        }
        return cVar.a(xmlPullParser, str, f16);
    }

    private final int c(XmlPullParser xmlPullParser, String str, int i3) {
        return NumberUtil.stringToInt(xmlPullParser.getAttributeValue(null, str), i3);
    }

    static /* synthetic */ int d(c cVar, XmlPullParser xmlPullParser, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return cVar.c(xmlPullParser, str, i3);
    }

    private final f e(XmlPullParser parser) {
        f fVar = new f();
        fVar.o(parser.getAttributeValue(null, WadlProxyConsts.KEY_JUMP_URL));
        fVar.n(d(this, parser, NodeProps.CUSTOM_PROP_IMAGE_TYPE, 0, 2, null));
        fVar.m(parser.getAttributeValue(null, "imageName"));
        fVar.p(b(this, parser, "radius", 0.0f, 2, null));
        fVar.q(NumberUtil.stringToBoolean(parser.getAttributeValue(null, "repeat")));
        fVar.t(d(this, parser, "w", 0, 2, null));
        fVar.k(d(this, parser, h.F, 0, 2, null));
        fVar.r(d(this, parser, "scaleType", 0, 2, null));
        fVar.s(d(this, parser, "triggerCount", 0, 2, null));
        return fVar;
    }

    private final e f(XmlPullParser parser) {
        String attributeValue = parser.getAttributeValue(null, "particleLifeTime");
        String attributeValue2 = parser.getAttributeValue(null, "disappearTime");
        e eVar = new e();
        eVar.o(attributeValue);
        eVar.n(NumberUtil.stringToLong(attributeValue2, 1000L));
        g i3 = eVar.i();
        i3.i().i(d(this, parser, "emitMode", 0, 2, null));
        i3.i().l(d(this, parser, "emitLifeTime", 0, 2, null));
        i3.i().j(b(this, parser, "emitRate", 0.0f, 2, null));
        i3.i().k(b(this, parser, "gravityScale", 0.0f, 2, null));
        i3.H(b(this, parser, "emitAreaX", 0.0f, 2, null));
        i3.I(b(this, parser, "emitAreaY", 0.0f, 2, null));
        i3.J(b(this, parser, "emitAreaZ", 0.0f, 2, null));
        i3.G(b(this, parser, "emitAreaWidth", 0.0f, 2, null));
        i3.E(b(this, parser, "emitAreaHeight", 0.0f, 2, null));
        i3.F(c(parser, "emitAreaUnit", 1));
        i3.b0(b(this, parser, "speedX", 0.0f, 2, null));
        i3.c0(b(this, parser, "speedY", 0.0f, 2, null));
        i3.a0(b(this, parser, "speedRandom", 0.0f, 2, null));
        i3.Z(d(this, parser, "speedAngleRandom", 0, 2, null));
        i3.C(b(this, parser, "accelerationX", 0.0f, 2, null));
        i3.D(b(this, parser, "accelerationY", 0.0f, 2, null));
        i3.M(d(this, parser, "rotationXSpeed", 0, 2, null));
        i3.Q(d(this, parser, "rotationYSpeed", 0, 2, null));
        i3.U(d(this, parser, "rotationZSpeed", 0, 2, null));
        i3.K(d(this, parser, BasicAnimation.KeyPath.ROTATION_X, 0, 2, null));
        i3.O(d(this, parser, BasicAnimation.KeyPath.ROTATION_Y, 0, 2, null));
        i3.S(d(this, parser, "rotationZ", 0, 2, null));
        i3.L(d(this, parser, "rotationXRandom", 0, 2, null));
        i3.P(d(this, parser, "rotationYRandom", 0, 2, null));
        i3.T(d(this, parser, "rotationZRandom", 0, 2, null));
        i3.N(d(this, parser, "rotationXSpeedRandom", 0, 2, null));
        i3.R(d(this, parser, "rotationYSpeedRandom", 0, 2, null));
        i3.V(d(this, parser, "rotationZSpeedRandom", 0, 2, null));
        i3.W(a(parser, "scale", 1.0f));
        i3.Y(b(this, parser, "scaleSpeed", 0.0f, 2, null));
        i3.X(b(this, parser, "scaleRandom", 0.0f, 2, null));
        return eVar;
    }

    public final void g(@Nullable String tagName, @NotNull XmlPullParser parser, @NotNull a rule) throws IOException, XmlPullParserException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, tagName, parser, rule);
            return;
        }
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(rule, "rule");
        if (tagName != null) {
            switch (tagName.hashCode()) {
                case -2011653733:
                    if (tagName.equals("MaxTriggerCount")) {
                        rule.I(NumberUtil.stringToInt(parser.nextText()));
                        return;
                    }
                    return;
                case -1740380044:
                    if (tagName.equals("ParticleInfo")) {
                        if (rule.i() == null) {
                            rule.B(new ArrayList<>());
                        }
                        ArrayList<e> i3 = rule.i();
                        Intrinsics.checkNotNull(i3);
                        i3.add(f(parser));
                        return;
                    }
                    return;
                case -1100727364:
                    if (tagName.equals("GravityScale")) {
                        rule.d().k(NumberUtil.stringToFloat(parser.nextText()));
                        return;
                    }
                    return;
                case -956736784:
                    if (tagName.equals("FrequencyDuration")) {
                        rule.y(NumberUtil.stringToLong(parser.nextText()) * 1000);
                        return;
                    }
                    return;
                case -202143871:
                    if (tagName.equals("SupportChatType")) {
                        String nextText = parser.nextText();
                        Intrinsics.checkNotNullExpressionValue(nextText, "parser.nextText()");
                        rule.K(nextText);
                        return;
                    }
                    return;
                case 70760763:
                    if (tagName.equals("Image") && rule.i() != null) {
                        ArrayList<e> i16 = rule.i();
                        Intrinsics.checkNotNull(i16);
                        if (!i16.isEmpty()) {
                            ArrayList<e> i17 = rule.i();
                            Intrinsics.checkNotNull(i17);
                            Intrinsics.checkNotNull(rule.i());
                            e eVar = i17.get(r0.size() - 1);
                            Intrinsics.checkNotNullExpressionValue(eVar, "rule.jumpImageList!![rul\u2026jumpImageList!!.size - 1]");
                            e eVar2 = eVar;
                            if (eVar2.g() == null) {
                                eVar2.q(new ArrayList<>());
                            }
                            f e16 = e(parser);
                            e16.l(rule.h());
                            ArrayList<f> g16 = eVar2.g();
                            Intrinsics.checkNotNull(g16);
                            g16.add(e16);
                            return;
                        }
                        return;
                    }
                    return;
                case 1024261129:
                    if (tagName.equals("LifeTime")) {
                        rule.d().l(NumberUtil.stringToInt(parser.nextText()));
                        return;
                    }
                    return;
                case 1064075318:
                    if (tagName.equals("EmitMode")) {
                        rule.d().i(NumberUtil.stringToInt(parser.nextText()));
                        return;
                    }
                    return;
                case 1064211315:
                    if (tagName.equals("EmitRate")) {
                        rule.d().j(NumberUtil.stringToFloat(parser.nextText()));
                        return;
                    }
                    return;
                case 1523095405:
                    if (tagName.equals("CanInterceptTouch")) {
                        rule.u(Intrinsics.areEqual("1", parser.nextText()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
