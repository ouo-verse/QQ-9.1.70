package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.resource.QQFTIconConstant;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileSetStatusViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import ws3.br;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTCompressTitleStatusViewKt {
    public static final void QQFTCompressTitleStatusView(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1948184841);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1948184841, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressTitleStatusView (QQFTCompressTitleStatusView.kt:49)");
        }
        ColumnKt.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), a.f339245a.b(), Alignment.INSTANCE.e(), null, ComposableLambdaKt.composableLambda(startRestartGroup, 622447474, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressTitleStatusViewKt$QQFTCompressTitleStatusView$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(622447474, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressTitleStatusView.<anonymous> (QQFTCompressTitleStatusView.kt:53)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i j3 = ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null);
                    Alignment.Vertical c16 = Alignment.INSTANCE.c();
                    a.d g16 = a.f339245a.g();
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                    RowKt.a(j3, g16, c16, null, null, ComposableLambdaKt.composableLambda(composer3, 172308240, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressTitleStatusViewKt$QQFTCompressTitleStatusView$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            int i16;
                            String str;
                            n nVar2 = nVar;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i16 = (composer5.changed(nVar2) ? 4 : 2) | intValue2;
                            } else {
                                i16 = intValue2;
                            }
                            if ((i16 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(172308240, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressTitleStatusView.<anonymous>.<anonymous> (QQFTCompressTitleStatusView.kt:58)");
                                }
                                i.Companion companion2 = i.INSTANCE;
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion2, 2.0f), composer5, 8, 0);
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("isLoadingData=");
                                m3.append(QQFlashTransferViewModel.this.isLoadingData.getValue().booleanValue());
                                m3.append(" fileSetIsNull=");
                                NBPFeedCommentsView$contentComments$1$1$7$1$2$1$$ExternalSyntheticOutline0.m(m3, QQFlashTransferViewModel.this.fileSet.getValue() == null, kLog, "QQFTTitleStatusCardView");
                                if (QQFlashTransferViewModel.this.isParentCompressFolderDownloadFile.getValue().booleanValue()) {
                                    str = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAASAAAAEgCAMAAAAjXV6yAAAAgVBMVEUAAABgtf9ftf9gt/9ftP9gr/9gtf9ftP9ftf9gtf9ftP9gs/9gtP9ftf9gsv9gtP9ftP////9ouP9htf9suv9quf9uu/9jtv9lt/9wvP/a7v/G5P93wP+x2v/s9/+KyP+j1f9/w//1+/+Tzf+p1/+z3P/2+/+f0v++4f/k8v/R6v+sWTQyAAAAEHRSTlMAYN8g7xCfz78wj0CAr1BwG8/5+AAAFWtJREFUeNrs2l1uhCAYRmEE/KkUfPe/2s5F0zh2AiajY4TzLOEEyEfAAAAAAAAAAABwMZe6N6TQm4qFefJ61zh0ztQozF5HiZ2pTZh0KFtXon7Q4eyXqUbyOsNsKjHrJLaK07qftMI22+pHncjfvtCmD4W2op5R6Nm3tii05vQfhVasXqDQn0UvUeiXs/oQf8+JcVEGM3X2BKLQQ1IGhYwZlEMh45XVfKGggtYLLSppvFBUUduFJpU1Xchqh5YLaZeGC2m/Nl/MdJnhHpd7XWhcbvDJQXiwY5yTI1BxRTsCFcRAoB927BiHYRCGwnAbiISStJWHDBARIe5/yKrt0sXPYo3ff4RPgGyMUiCQ0UIgoykQCBefBDLaCGT0IpDRnUC4GAiEm2YC4RYCGa0EwiUCGa0EwiUCGQUC4TYTaK/llMvWS8v4j9EAykUu3wGJZgjUujioN7SRIaAqTqpomgbnR9ykn6GHDpRd3K9fPasbqw50iKOKphBVoCyu2jWHG1+gb3UYyMEE9F8ZBnL0RH86h4He7Jpxb8IgEMX3FQR6FueczTKz+f0/4EChr48LbfbPMJNnJPagx7ufRxMTd0+mDqgD6oCW6oA21AFtqAPaUAe0oQ5oQx3QhloBsvvRDIMTkenom2i6wPTpzzwcJxHn3GDGva0CsuMgvrm+dwt9+gaSYQQkALLmAegEUd9ffRvJYEtAxj+ICNDBN5MhQNZFbDHevI0aAdL1iwUgi3BzSA/QQal+Z2dAEoJEUX7D6D8BQv3hLRmQEZE8E+LPC2hZfyRg7oCsxEiORnQETB+8Mibz8RW9H1Zl7tiI04lUAEU3SCXwhCzambIjcArbcF3Ufwdib4DMLcQzkmgG5SR5Zp7IHvA5C1UFpYYtArgjjsgoDIhvCAImyHvKQtYogA7xy1rq9ZsIyIqfYz4PxICuo1AfA8M17PBNQcVqTu0LQMuikSTbQgx+FDoskBkPAV6r3wZAI5vMHrQ4hm8MNWtT6BtMYwTeGRz/4eZc35vzgs6q4Ilqrtc/BkCmSM1fDjoRYUpJrsk2NUtN6TBis+kEPq9peiWLtgCDPOrV2Lxa/xAAOUlisvr08AMJWbTogcynCczxrJq+DknXc5j9yHovvOtDjbyYC9I4cQ51K63V7wIgxRhMq9I9Sc2DkK4NM4lg/P0OvZVI5sVEYttLxTQP8bVev33Z0wJ9AXl+aNDJrzWybnidk/5GcmGe2LCW29d8cstV5dfrty8/7JyLltJAEETnF8hJ3CyLuCys+/j/DzTSaa6ddigjIKtSSsj09KtqOvFxPPY5mEcBX7eZOT/wteJMdpVk/FcA6RVFCHcKOaIefJx/XxpRIsoMIJ6BN+JiQ1MhkOgJE+engwO0e1MaOp4VqvQEonkhEOeZBkIOiIgwWY/zb0o3UxB6zaCezsZQRoEInpUzDxU3whVogWSB06EniMJXA9W70p3wbF1UoNO70U56vyvtuRq6pEDXG6sWga6EJNDHwkcQaPIbxY+F4wK1lXts58D2R4FesQvoRrRbq/3LzDr41SPaVvUTjY/rw/w8n0H49qyRZbCyI4PboE6MbFV3bXLnhvXzV5dr/Rgzu+NwZxZShAptvW7eVvyLe1GNW5oLxjxGVsUd2zHIQpIjFrZR4HXxA7ZjY5BoM/3WjE4BHdOCGL4U/0Iiu1hF64rW6AXitmErWot0ODAacS8nH9K3w/yAB/OwK0z8uyWju40demtWzIOIR2nFv4wnDnX/wMAbQZHhgyQsx7xksZ7Nwb7MGz5wtPXk76TdY0A4HpfETS4g2tBMaMG+LdB8BP8yJuMCnKX3Qyp6JTA1weG4hKR3om4gKArke3DElS//hieDFMjZMvBU/Es7kZgP/hyw7WFnemtVAWlwoYqnn07QyDSfAukGJK18G3viZ2kV/zJNRgSGMEGIkHnnSfYr4fRHGajlCSIdFSlLatY+StRLwEXxL340EMSdyvQG7fEne+SO8wZYp2SOJBBHRDOIHk+LjmCe6kUxFP9Sa50VZGuAAL/mkgRueLBLCi0QgFHOwDpXAP4rjOJfWAUlsPJ0OHn/xiUmSfFSWFY1gWpNwi1mikmzdEDwZ4IAo5r4z0ZuQrhEgeozzRzkTR6RVDPNsuJf0him2amphIVrfWyw5zPl9Ke/UWwrWRRxEGXwn0DxL2pEqKE8dasZWfzdAnzdVEvOypsJoLFiVbAK17rMYUtIi1Nt/fi+HPG6CUScKh/do95W/MvsF8npbvMLos4MSBk1EEg9lZcHdeaXZcLO30ppb8j4EwJ9av8N3CboJtC/IdD2cYJte0F03ApcUKBOGLB27e7rImH9KOhgvxxcoM6vFI31sWHOm7VFJ7g8L36K1/YoutQrt6xwrXAS/BEIMh0LviHaccNmKlZhkRrq0Cdh12UiXPQA4Y2odiFW8S+dWwc7KewHB2B590Z3QKBu/DArewuBXtnrWLD/2Cxq+Loa/CGV1eWLZWfJDUjkjULTTIK/C+TxZrVo8jA8A8w47vidZzSLFzRnHOjIurdsj4sqdq4mUYhuuWmYs8LWIY01gQpeXvAv3qt9Q8rAoUPIroaWczIrrZAEX24p0r7XBXpovRKiti43DcdjGxDloR6BBAv+BQXs4xpTCdo8a2F00I9CtvTeLD6YKbesC7S0VGhPtnBhwKjNM8XTDJHDpuJf/DzTYIQV5ACDj0bJy61s0rgVOSoQGeNB8dBQhwX9xx1eLawV/4LKAAO5OKjg5MECIU0QnAlabw5YM0GpJ3jA0toEYbQxkQYo/iVYp045jFdmdsEPFXkS+XTR4SAQsQiktWeOKImGoTh+NKr4IxBgTsjcUq6SzzzwSX0RElcI5ECgNojKZFAVHUJNcdoEKP5ZoEwnMk680zIb+VUl10EgQsIE1Q8GIy0yGJkLzx42wR+BEt/qUUBZvnBycDYgEDkRKMmPXlgzlAdQ/IvIIjjKLtLY5FFAILcjUK6hVcijXI/W/Rf6rhAUJhUvwsU7SGfj8RUtYp3VfxEEskWDB0Hw0gLNP3a9Gf60JkOL8LsstEBXAy/pP46o/IcVqHOBrg4X6OvDAU83gYALFHATqAPvN4GO47Uu0Gt3ddQEaoTtjNjWBdqevVgz16/YqmnSlozV3pZWZnyr6bMWTegtDcW/BLf9doNfQ4ytB58BMZX7J1+snt92WRq+VP57+KfNWJIcxNMxR8Gp0E3mHXYbxb8MFycOJag0zswCzNV9vBU+loSEJHJfQFNf1j+dny/uhdxe2TuBLl/2w2vTOAcX3AX/MrY+AAlcEYtgcJynXfyWmvbtzs2YiRx70CfYvLxNp2f5fG9Ex8zEW1IvjvRjbuo2Bk7RrWHABP9ia0vjZXBwvj5GlEMmJodOLd7Z2NrPFnFh0UU3BjB2Tx3GA68Rngg+2L0MNRX/4tlcfB8KvmIFZ0UbnBNhqV0+qOHZcHTh2UGrmJNytDNaKWAr1gBJFf+CfPCiIYYG/ROCjS7TgQaQLwRSGZKAdjChQXALLsmEm+JfvDHe4ZOmaJud0GEXFeiIAimMOxhjjvOfH/EoGiIhYVCPSz4Yxb8QXhlFWsCA7NFAQUKjZl0+TFojDUgUQcqWRyZXoqR1qfiXvUEI3FSB4MRy28UFianTZS0y13gkxGCLc8NOnBPW9Kn4F2bymCa0ji5Y8sDk6kJn9kM2+q1mwIXyGdUJVPwLjKclqahYiPZ1wzxeWV5a07Tzyzy1mhwF/5IicqKsyYcApDTqnop/aS4IPWB6szuBunLSkAJ9sKG5As44QfNk/FvqluaGm0A3gcBNIIGbQAI3gQT+KYH6y+c6vVSxYDL0/SXKkFz7KLOO7f0GSzWX4l9C8yedBm3hxS139MxGdtPoK5VEv31ot1f8S65BODYYsZ0qD0asAOweqtgM2yuWW8uYA563q5paVKZX2q2Nr+JfbDFE7z9GE02QOxRg38IpH4vtk5FuUcfDsP3McmnxCwDeXlYUm3Kj6x5rjyu33rjgX5xi4HVQpHeOkT/sB3jeVHyApzPLMYGG7alAfU3R9QtCjIzC8EL/0Ly3mIZE8S9+az6kcm0MbuDhCjtcKMvZ+K4QKEyQlaq739OwCRAJI1ocF0bD7Yp/sdsxhpnhjdIbGrePO7h5SW+VqWsYPilQ0weBLE/d/+3eyYRRMV7woFlGy8zOTfEvGEaruxPGe6ahOtwnzeDjx+S+8yaoP/7Sev/xiGgsULAVj5e72Ya5KP7lcOSUSOCUAGeAIJji1e/mvYOGIAwZu6BMaAP2dsULin6ein8hNS9Tz0CqpERlSZ2ERgr0meWSgBqe7j0tFOJ4s8XDl6D4F9woxlfkyhsf71StqpcQqA8TZNkXx/A5F8UAx4jES/EvOZqYnKYC6SQFWg2BcYKkQEt7b2RdWOruGsW/zKB8KuJvjN/Cv9bsBwSBpoq+Lb8jKHTfz8Z8KqW/Eu7XC7D+JAX6sjesfpR1O7fmfHmuKNDrIrLXAplC4dexi+N6Am2mb+heCmRYh7f0pXE9gcIDtjLbLwn09H8INGgBXjBKgV5C3MVxLYFWP3nAhEAvq+/ABc0uiesI9PMHTAiU8dRfHlcRqPKAzRboob88kkB33JwX5K09YDMEOucTpvgXKU500CXE5l3tAZsr0PLUVuyq+Jc7t9xZ97ImVD008A+W5DAE3e3iA/abAj2tPDlftTWm3JviX3xz/LobLz1SkGM0kBHW01bMgZYJXT2FMcB5nkA7y+clmAk40yo+voaz4F/8jmKQAbBgUMzZ4sgy7lOMOPN5j2NAmVkC7cZSVo8q9Gd3Nf3YFPyLnbRTNmmRcTS4S+RvC5Jh9LnyKIL7l0Rz7zidIIutPl9fxh5dE18im9V3Zk7MnOzGDIp/8cXgSEozWSo4eFmSWS0OwEycLQEu7DdmzG61jSCGwiIXbSgtNAxYhiQESi5K3/8BWzPInw9i9hCzrqM2nh2N/s4ZaWPyIm/oBGBqB01aF/S8HmYyMoEa1hiZom0asvCwxh/FV5UJGcVQUVK+ZOIqMEl0zBlBnuWvZEXbtN3qINj583449xzMM8cAn2fwISiqsR3+SG3BTLoiQQyp4MdJa4BXNlWoDNjrJXWpBE3l5TS+neTlwOUU/fwHcq1gYM5TRs3hD9AwJSWckRuSWDGCEO6hpA0Y3PQOmuon5I3Q9AXzzzRxIfp7JIUxKDH4I6FR+VCS8FsRyF7OJacOWJ0Xl0LQCZoQBJx6kpoooku/RnYOf4BdhwlrTbSgoil77akD9vxyKX3EMpWg5L4RVwojr7dF4zr8wZutTtWaBa2AdwUjBwasyWt/B/URKwESq3aJuziAOvyhxsqDFLDGzzirjrC8Y1by3Ag6SR8x+WCDKGteHP5YTeq6axemaBQGqudNgo6GoIZpBbZ3ORX2qh3+WPSjF59G944g8z3ojRvqCQ0IdH1xrpGIj030pvFOniDfQdfL8UrL2CesH1BP0NG/pHu6G9HGeTRj1h1zHnfqIILvxY7DH9dh9i7NZ6eXtM/cFese9xI73Isn8xO8g65tgMi9xPP8+2n7i+J7I+iXEHQXifyP8rKW1PPDdDigyZKRyMibS0gqm9rXtFf5o/kvCz1u243Rz/h0+EO27YLGdtGDZaBSJRp1pH7CaCrH8JAfxc5jL1rgOfwxFyEavyFJSTWubjfKP4lwzoofJmscUMFendVaVQ5/yFnLoJj40TP1nYcaUxWjbObnPyn6x1QRqLajEVQED9BOTf2jsXqX0WkOf8yQZ7Jpmlk2/BaMUbtphhORhIxCWSTNMIOk5V4nlaoOS3OGDAvUUgVWEtr+8rNCcQfD4Y+Zt93muLwVQlIOnBXerO2QESndOSW1F/nkqWSk1QEpFug5sAvvLHAGpZykwx9lNADNXWhaTIgCLPy4Uo3MBq7PZmKvXNC6cAfrUEErVhB4oSCZ7kyHP8pTjuoRFCSiaE7nwjEJCKS9221wT/DCNbjJX+7wTbXkKT8pj3QGf9DY5EhAoyPLImDCBUqCEgXsCnjoofpVF2ELn7jh2/iXDXYOf6CRIhUeCjogO33sKZhAhGethul4pPwGisq6dZfOFOU5/MFYdxH31o3r1mjDhgm8ipZEEmurBww5KaDlJSRqhz8kJMKzIs31kBHA8L1QZhtq6ePuwodPlavsDn+MtQgx2paphqx9GrKHQDhA3HwYaGJh+jB92hCNuQon2ZP7GAmXLjlZTFQbBpXDHw/ky49f3cZEeip9qlVpXhJHE2Ib/0M89EP99u4m3CAwIJRbH0rtfAE+1CZ+CGrCt02XgZCmvWxtGvMKqHsJ+B/iq20QWLpbtUjundQMyGM8std2R8PL9O6Se7qhX+N/jC+36oM0r3TvePe2zTF+NII+Q5/cTPLDNt/i+xV5ftpMPsQVlt5p/zL+slNuu3HDMBClfN2LWwjI//9r4UjswYAg+LBAXxomcVbcoTgzonxZ+2Cbsu7++TdiegL6VFWzZ4rsPHsE9Y91dl8UzUd7oKTDU3EUd0nWUki/bZfz9icbuzfS3ht66y7cBIG78qSAFVpyQ3u0kJyzlW1jK5ZAVT98drPlzs0+vcMC3FwPv+4H2/GN9Jx/WAh0VE7nSdISwDdiMAqgzvVFFhnONxQORkI413+a2dG7+w5w4O4YXMRjXBINnoGFZ/oIuR6YzfjRDX8mavwGExDsn3w3ZN8pHuL4rM31H2bWxnH59tRPVV7uCBpNDMV3DKyjYajaOUf6cIC4IyjH+QIWVMzwMllDNYAy/c3M9q2DYSadjBBOKGKNsiDhwWz9ZUMfkqimTk6BCWEa4Rd5gWJLiAb9TnPbzcxemNdhSFPGhDvHh6kVL/iMRUM8AykWw53/0OaBZFXfYzc9MbUZY4hM/2F3rF+qimrUJ27JR5YsdBqQFDnqEn04EsC8V0U11KL+sA1P9HN9VvuOS6aXKq/gkJgV7mE8oOA0lxS7MB1j9SBlp2ixhIPJU0pLEkDUTyVw2YwTSoyo20ClBl7AWGlALZww5YC8XxZcNPRhLe82vSgqPZ0i9ENoMY91CbSEaDq5AYRyVhGPDOENDKrZqymsIjdxBFJAxLyof1nNcEivoBbH6p5GjcEdHYCMfH48JbsCSsAA3Ik/4z2kGOriC5ekHlERJdXIgEXkllpI5MNXO3aZaazHFlC10ARYVKjFuTP11tzRkhWpOre9Vouxt+OsWdXcmTeW5Gq++bThRT0keejtjlsuR9sti/3drtevx6PY/aNJ+kJz0aL4ti6p+xDb+TiOqz3dnCKe7/Zfxe/VfuIn/rQHhwQAAAAAgv6/doYFAAAAAAB4BQWTmDBW/h9CAAAAAElFTkSuQmCC";
                                } else {
                                    str = QQFTIconConstant.FILE_TYPE_ICONS[4];
                                }
                                String str2 = str;
                                int c17 = h.INSTANCE.c();
                                i u16 = ComposeLayoutPropUpdaterKt.u(companion2, 60.0f);
                                Alignment.Companion companion3 = Alignment.INSTANCE;
                                ImageKt.a(null, null, null, null, null, nVar2.b(u16, companion3.c()), null, c17, null, null, str2, null, null, null, null, null, null, null, null, null, null, composer5, 12845056, 0, 0, 2095967);
                                i b16 = nVar2.b(nVar2.a(ComposeLayoutPropUpdaterKt.n(companion2, 20.0f, 0.0f, 0.0f, 0.0f, 14, null), 1.0f), companion3.c());
                                final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                                ColumnKt.a(b16, null, null, null, ComposableLambdaKt.composableLambda(composer5, 1520070457, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressTitleStatusViewKt.QQFTCompressTitleStatusView.1.1.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar2, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1520070457, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressTitleStatusView.<anonymous>.<anonymous>.<anonymous> (QQFTCompressTitleStatusView.kt:72)");
                                            }
                                            br value = QQFlashTransferViewModel.this.fileSet.getValue();
                                            if (value != null && value.f446201o == 6) {
                                                composer7.startReplaceableGroup(2028078560);
                                                QQFTFileSetStatusViewKt.QQFTFileSetStatusView(14.0f, 20.0f, QQFlashTransferViewModel.this, 0.0f, false, composer7, PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT, 24);
                                                composer7.endReplaceableGroup();
                                            } else if (!QQFlashTransferViewModel.this.isLoadingData.getValue().booleanValue() && QQFlashTransferViewModel.this.fileSet.getValue() == null) {
                                                composer7.startReplaceableGroup(2028079422);
                                                composer7.endReplaceableGroup();
                                            } else {
                                                composer7.startReplaceableGroup(2028078743);
                                                i.Companion companion4 = i.INSTANCE;
                                                i j16 = ComposeLayoutPropUpdaterKt.j(companion4, 0.0f, 1, null);
                                                TextKt.a(QQFlashTransferViewModel.this.pageTitle.getValue(), j16, null, QUIToken.color$default("text_primary"), Float.valueOf(24.0f), null, c.INSTANCE.a(), null, null, null, ai.f(ai.INSTANCE.e()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer7, 1601600, 102236160, 0, 133888932);
                                                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion4, 2.0f), composer7, 8, 0);
                                                QQFTFileSetStatusViewKt.QQFTFileSetStatusView(14.0f, 20.0f, QQFlashTransferViewModel.this, (com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().m() - 32.0f) - 72.0f, false, composer7, PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT, 16);
                                                composer7.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 24584, 14);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196680, 24);
                    com.tencent.kuikly.core.base.h color$default = QUIToken.color$default("bg_bottom_light");
                    ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 18.0f), 10.0f), 21.0f, 6.0f, 0.0f, 0.0f, 12, null), null, h.INSTANCE.c(), null, null, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADYAAAAaBAMAAAAOBbKjAAAALVBMVEUAAAD///////////////////////////////////////////////////////+hSKubAAAADnRSTlMAIN9/v+9Az48QbzCfXxb7c/EAAACXSURBVCjPY6AxyCh997wRu9SWdyDgiE2K6x0EGGCRs4PKPcaUYgYK49K4Di73Fl2K7R0CJKDJiSLJRaNKMeohyT0SQJETeocMFJGlOPVQ5J5PQJJjeYcKHJDk+tDk3mDzN6b/7TDkHiNCGRNcgMrlYZF7BvV3HBa5pxsw/Y3wP3pwoQfcpHfYQSVQzg+H3BMGBo53uMABAA3YSZKR/rVkAAAAAElFTkSuQmCC", null, null, null, null, null, null, null, null, color$default, null, composer3, 12845056, 1073741830, 0, 1571679);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24648, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressTitleStatusViewKt$QQFTCompressTitleStatusView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCompressTitleStatusViewKt.QQFTCompressTitleStatusView(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
