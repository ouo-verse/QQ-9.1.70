package com.tencent.qmethod.monitor.ext.traffic;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.net.wifi.ScanResult;
import com.tencent.ads.data.AdParam;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qmethod.pandoraex.core.ext.netcap.k;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0003\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureDefine;", "", "Lkotlin/text/Regex;", "a", "Lkotlin/text/Regex;", "REGEX_LATITUDE", "b", "REGEX_MAC", "c", "REGEX_MAIL", "d", "REGEX_ID_CARD", "e", "REGEX_MOBILE", "f", "REGEX_NAME", "g", "REGEX_BANKCARD", tl.h.F, "REGEX_ADDRESS", "", "Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureRule;", "i", "Ljava/util/List;", "()Ljava/util/List;", "setRuleList", "(Ljava/util/List;)V", "ruleList", "j", "Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureRule;", "getAppInstallRule", "()Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureRule;", "setAppInstallRule", "(Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureRule;)V", "appInstallRule", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class NetworkCaptureDefine {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Regex REGEX_MAC;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Regex REGEX_MAIL;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Regex REGEX_ID_CARD;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Regex REGEX_MOBILE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final Regex REGEX_NAME;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final Regex REGEX_BANKCARD;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final Regex REGEX_ADDRESS;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static List<NetworkCaptureRule> ruleList;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static NetworkCaptureRule appInstallRule;

    /* renamed from: k, reason: collision with root package name */
    public static final NetworkCaptureDefine f343696k = new NetworkCaptureDefine();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Regex REGEX_LATITUDE = new Regex("[-+]?\\d+\\.\\d{5,}");

    static {
        Regex regex = new Regex("((([A-Fa-f0-9]{2}:){5})|(([A-Fa-f0-9]{2}-){5}))[A-Fa-f0-9]{2}");
        REGEX_MAC = regex;
        Regex regex2 = new Regex("[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+(com|cn|net)");
        REGEX_MAIL = regex2;
        Regex regex3 = new Regex("[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|31)|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}([0-9]|x|X)");
        REGEX_ID_CARD = regex3;
        Regex regex4 = new Regex("^(\\\\+86|86){0,1}((13[0-9]{1})|(15[0-9]{1})|(16[0-9]{1})|(17[3-8]{1})|(18[0-9]{1})|(19[0-9]{1})|(14[5-7]{1}))+\\d{8}$");
        REGEX_MOBILE = regex4;
        Regex regex5 = new Regex("^(\u738b|\u674e|\u5f20|\u5218|\u9648|\u6768|\u9ec4|\u8d75|\u5434|\u5468|\u5f90|\u5b59|\u9a6c|\u6731|\u80e1|\u90ed|\u4f55|\u9ad8|\u6797|\u7f57|\u90d1|\u6881|\u8c22|\u5b8b|\u5510|\u8bb8|\u97e9|\u51af|\u9093|\u66f9|\u5f6d|\u66fe|\u8096|\u7530|\u8463|\u8881|\u6f58|\u4e8e|\u848b|\u8521|\u4f59|\u675c|\u53f6|\u7a0b|\u82cf|\u9b4f|\u5415|\u4e01|\u4efb|\u6c88|\u59da|\u5362|\u59dc|\u5d14|\u949f|\u8c2d|\u9646|\u6c6a|\u8303|\u91d1|\u77f3|\u5ed6|\u8d3e|\u590f|\u97e6|\u5085|\u65b9|\u767d|\u90b9|\u5b5f|\u718a|\u79e6|\u90b1|\u6c5f|\u5c39|\u859b|\u95eb|\u6bb5|\u96f7|\u4faf|\u9f99|\u53f2|\u9ece|\u8d3a|\u987e|\u6bdb|\u90dd|\u9f9a|\u90b5|\u4e07|\u94b1|\u8983|\u6b66|\u6234|\u5b54|\u6c64|\u5e9e|\u6a0a|\u5170|\u6bb7|\u65bd|\u9676|\u6d2a|\u7fdf|\u5b89|\u989c|\u502a|\u4e25|\u725b|\u6e29|\u82a6|\u5b63|\u4fde|\u7ae0|\u9c81|\u845b|\u4f0d|\u7533|\u5c24|\u6bd5|\u8042|\u67f4|\u7126|\u5411|\u67f3|\u90a2|\u5cb3|\u9f50|\u6cbf|\u6885|\u83ab|\u5e84|\u8f9b|\u7ba1|\u795d|\u5de6|\u6d82|\u8c37|\u7941|\u65f6|\u8212|\u803f|\u725f|\u535c|\u8def|\u8a79|\u5173|\u82d7|\u51cc|\u8d39|\u7eaa|\u9773|\u76db|\u7ae5|\u6b27|\u7504|\u9879|\u66f2|\u6210|\u6e38|\u9633|\u88f4|\u5e2d|\u536b|\u67e5|\u5c48|\u9c8d|\u4f4d|\u8983|\u970d|\u7fc1|\u968b|\u690d|\u7518|\u666f|\u8584|\u5355|\u5305|\u53f8|\u67cf|\u5b81|\u67ef|\u962e|\u6842|\u95f5|\u6b27\u9633|\u89e3|\u5f3a|\u4e1b|\u534e|\u8f66|\u5189|\u623f|\u8fb9|\u8f9c|\u5409|\u9976|\u5201|\u77bf|\u621a|\u4e18|\u53e4|\u7c73|\u6c60|\u6ed5|\u664b|\u82d1|\u90ac|\u81e7|\u7545|\u5bab|\u6765|\u5d7a|\u82df|\u5168|\u891a|\u5ec9|\u7b80|\u5a04|\u76d6|\u7b26|\u595a|\u6728|\u7a46|\u515a|\u71d5|\u90ce|\u90b8|\u5180|\u8c08|\u59ec|\u5c60|\u8fde|\u90dc|\u664f|\u683e|\u90c1|\u5546|\u8499|\u8ba1|\u55bb|\u63ed|\u7aa6|\u8fdf|\u5b87|\u6556|\u7cdc|\u9122|\u51b7|\u5353|\u82b1|\u827e|\u84dd|\u90fd|\u5de9|\u7a3d|\u4e95|\u7ec3|\u4ef2|\u4e50|\u865e|\u535e|\u5c01|\u7afa|\u51bc|\u539f|\u5b98|\u8863|\u695a|\u4f5f|\u6817|\u5321|\u5b97|\u5e94|\u53f0|\u5deb|\u97a0|\u50e7|\u6851|\u8346|\u8c0c|\u94f6|\u626c|\u660e|\u6c99|\u8584|\u4f0f|\u5c91|\u4e60|\u80e5|\u4fdd|\u548c|\u853a|\u6c34|\u4e91|\u660c|\u51e4|\u9146|\u5e38|\u76ae|\u5eb7|\u5143|\u5e73|\u8427|\u6e5b|\u79b9|\u65e0|\u8d1d|\u8305|\u9ebb|\u5371|\u9a86|\u652f|\u548e|\u7ecf|\u88d8|\u7f2a|\u5e72|\u5ba3|\u8d32|\u676d|\u8bf8|\u94ae|\u5d47|\u6ed1|\u8363|\u8340|\u7f8a|\u65bc|\u60e0|\u5bb6|\u82ae|\u7fbf|\u50a8|\u6c72|\u90b4|\u677e|\u5bcc|\u4e4c|\u5df4|\u5f13|\u7267|\u9697|\u5c71|\u5b93|\u84ec|\u90d7|\u73ed|\u4ef0|\u79cb|\u4f0a|\u4ec7|\u66b4|\u94ad|\u5389|\u620e|\u7956|\u675f|\u5e78|\u97f6|\u84df|\u5370|\u5bbf|\u6000|\u84b2|\u9102|\u7d22|\u54b8|\u7c4d|\u8d56|\u4e54|\u9634|\u80fd|\u82cd|\u53cc|\u95fb|\u8398|\u8d21|\u9022|\u6276|\u5835|\u5bb0|\u90e6|\u96cd|\u5374|\u74a9|\u6fee|\u5bff|\u901a|\u6248|\u90cf|\u6d66|\u5c1a|\u519c|\u522b|\u960e|\u5145|\u6155|\u8339|\u5ba6|\u9c7c|\u5bb9|\u6613|\u614e|\u6208|\u5e9a|\u7ec8|\u66a8|\u5c45|\u8861|\u6b65|\u6ee1|\u5f18|\u56fd|\u6587|\u5bc7|\u5e7f|\u7984|\u9619|\u4e1c|\u6bb4|\u6bb3|\u6c83|\u5229|\u851a|\u8d8a|\u5914|\u9686|\u5e08|\u538d|\u6643|\u52fe|\u878d|\u8a3e|\u961a|\u90a3|\u7a7a|\u6bcb|\u4e5c|\u517b|\u987b|\u4e30|\u5de2|\u84af|\u76f8|\u540e|\u7ea2|\u6743\u902f|\u76d6\u76ca|\u6853|\u516c|\u4e07\u4fdf|\u53f8\u9a6c|\u4e0a\u5b98|\u590f\u4faf|\u8bf8\u845b|\u95fb\u4eba|\u4e1c\u65b9|\u8d6b\u8fde|\u7687\u752b|\u5c09\u8fdf|\u516c\u7f8a|\u6fb9\u53f0|\u516c\u51b6|\u5b97\u653f|\u6fee\u9633|\u6df3\u4e8e|\u5355\u4e8e|\u592a\u53d4|\u7533\u5c60|\u516c\u5b59|\u4ef2\u5b59|\u8f69\u8f95|\u4ee4\u72d0|\u949f\u79bb|\u5b87\u6587|\u957f\u5b59|\u6155\u5bb9|\u9c9c\u4e8e|\u95fe\u4e18|\u53f8\u5f92|\u53f8\u7a7a|\u4e93\u5b98|\u53f8\u5bc7|\u4ec9|\u7763|\u5b50\u8f66|\u989b\u5b59|\u7aef\u6728|\u5deb\u9a6c|\u516c\u897f|\u6f06\u96d5|\u4e50\u6b63|\u58e4\u9a77|\u516c\u826f|\u62d3\u8dcb|\u5939\u8c37|\u5bb0\u7236|\u8c37\u7cb1|\u6cd5|\u6c5d|\u94a6|\u6bb5\u5e72|\u767e\u91cc|\u4e1c\u90ed|\u5357\u95e8|\u547c\u5ef6|\u5f52\u6d77|\u7f8a\u820c|\u5fae\u751f|\u5e05|\u7f11|\u4ea2|\u51b5|\u90c8|\u7434|\u6881\u4e18|\u5de6\u4e18|\u4e1c\u95e8|\u897f\u95e8|\u4f58|\u4f74|\u4f2f|\u8d4f|\u5357\u5bab|\u58a8|\u54c8|\u8c2f|\u7b2a|\u5e74|\u7231|\u4edd|\u4ee3)\\s*[\\u4e00-\\u9fa5]{1,3}$");
        REGEX_NAME = regex5;
        Regex regex6 = new Regex("(621096|621098|622150|622151|622181|622188|622199|955100|621095|620062|621285|621798|621799|621797|620529|621622|621599|621674|623218|623219|622200|622202|622203|622208|621225|620058|621281|900000|621558|621559|621722|621723|620086|621226|621618|620516|621227|621288|621721|900010|623062|621670|621720|621379|621240|621724|621762|621414|621375|622926|622927|622928|622929|622930|622931|621733|621732|621372|621369|621763|620114|620187|620046|622841|622824|622826|622848|620059|621282|622828|622823|621336|621619|622821|622822|622825|622827|622845|622849|623018|623206|621671|622840|622843|622844|622846|622847|620501|622841|622824|622826|622848|620059|621282|622828|622823|621336|621619|622821|622822|622825|622827|622845|622849|623018|623206|621671|622840|622843|622844|622846|622847|620501|621660|621661|621662|621663|621665|621667|621668|621669|621666|456351|601382|621256|621212|621283|620061|621725|621330|621331|621332|621333|621297|621568|621569|621672|623208|621620|621756|621757|621758|621759|621785|621786|621787|621788|621789|621790|622273|622274|622771|622772|622770|621741|621041|620040|620531|620513|921000|620038|621284|436742|589970|620060|621081|621467|621598|621621|621700|622280|622700|623211|623668|623668)\\d{13}$|^(620200|620302|620402|620403|620404|620406|620407|620409|620410|620411|620412|620502|620503|620405|620408|620512|620602|620604|620607|620611|620612|620704|620706|620707|620708|620709|620710|620609|620712|620713|620714|620802|620711|620904|620905|621001|620902|621103|621105|621106|621107|621102|621203|621204|621205|621206|621207|621208|621209|621210|621302|621303|621202|621305|621306|621307|621309|621311|621313|621211|621315|621304|621402|621404|621405|621406|621407|621408|621409|621410|621502|621317|621511|621602|621603|621604|621605|621608|621609|621610|621611|621612|621613|621614|621615|621616|621617|621607|621606|621804|621807|621813|621814|621817|621901|621904|621905|621906|621907|621908|621909|621910|621911|621912|621913|621915|622002|621903|622004|622005|622006|622007|622008|622010|622011|622012|621914|622015|622016|622003|622018|622019|622020|622102|622103|622104|622105|622013|622111|622114|622017|622110|622303|622304|622305|622306|622307|622308|622309|622314|622315|622317|622302|622402|622403|622404|622313|622504|622505|622509|622513|622517|622502|622604|622605|622606|622510|622703|622715|622806|622902|622903|622706|623002|623006|623008|623011|623012|622904|623015|623100|623202|623301|623400|623500|623602|623803|623901|623014|624100|624200|624301|624402|623700|624000|553242)\\d{12}$|^(62215049|62215050|62215051|62218850|62218851|62218849|45806|53098|45806|53098|53591|49102|377677|5453242|5491031|5544033|53242|53243)\\d{11}$|^(622812|622810|622811|628310|625919|402791|427028|427038|548259|621376|621423|621428|621434|621761|621749|621300|621378|622944|622949|621371|621730|621734|621433|621370|621764|621464|621765|621750|621377|621367|621374|621731|621781|427010|427018|427019|427020|427029|427030|427039|438125|438126|451804|451810|451811|458071|489734|489735|489736|510529|427062|524091|427064|530970|530990|558360|524047|525498|622230|622231|622232|622233|622234|622235|622237|622239|622240|622245|622238|451804|451810|451811|458071|628288|628286|622206|526836|513685|543098|458441|622246|544210|548943|356879|356880|356881|356882|528856|625330|625331|625332|622236|524374|550213|625929|625927|625939|625987|625930|625114|622159|625021|625022|625932|622889|625900|625915|625916|622171|625931|625113|625928|625914|625986|625925|625921|625926|625942|622158|625917|625922|625934|625933|625920|625924|625017|625018|625019|622210|622211|622212|622213|622214|622220|622223|622225|622229|622215|622224|620054|620142|620184|620030|620050|620143|620149|620124|620183|620094|620186|620148|620185|403361|404117|404118|404119|404120|404121|463758|519412|519413|520082|520083|552599|558730|514027|622836|622837|628268|625996|625998|625997|622838|625336|625826|625827|544243|548478|628269|622820|622830|621293|621294|621342|621343|621364|621394|621648|621248|621215|621249|621231|621638|621334|621395|623040|622348|625908|625910|625909|356833|356835|409665|409666|409668|409669|409670|409671|409672|512315|512316|512411|512412|514957|409667|438088|552742|553131|514958|622760|628388|518377|622788|628313|628312|622750|622751|625145|622479|622480|622789|625140|622346|622347|518378|518379|518474|518475|518476|524865|525745|525746|547766|558868|622752|622753|622755|524864|622757|622758|622759|622761|622762|622763|622756|622754|622764|622765|558869|625905|625906|625907|625333|620514|620025|620026|620210|620211|620019|620035|620202|620203|620048|620515|920000|421349|434061|434062|524094|526410|552245|621080|621082|621466|621488|621499|622966|622988|622382|621487|621486|621083|621084|620107|436742193|622280193|625362|625363|628316|628317|356896|356899|356895|436718|436738|436745|436748|489592|531693|532450|532458|544887|552801|557080|558895|559051|622166|622168|622708|625964|625965|625966|628266|628366|622381|622675|622676|622677|622725|622728|436728|453242|491031|544033|622707|625955|625956)\\d{10}$");
        REGEX_BANKCARD = regex6;
        Regex regex7 = new Regex("^(.{3,50})(\u5c0f\u533a|\u6751\u59d4\u4f1a|\u6751|\u8857\u9053|\u793e\u533a|\u8def|\u5927\u9053|\u516c\u5bd3|\u5199\u5b57\u697c|\u5e7f\u573a|\u9152\u5e97|\u5bbe\u9986)(.{3,15})$");
        REGEX_ADDRESS = regex7;
        ruleList = new ArrayList();
        appInstallRule = new NetworkCaptureRule("AppInstall", new String[0], 10, null, 0, false, new Function1<String, Boolean>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine$appInstallRule$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(String str) {
                return Boolean.valueOf(invoke2(str));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(@NotNull String value) {
                boolean startsWith$default;
                Intrinsics.checkParameterIsNotNull(value, "value");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(value, "com.android", false, 2, null);
                return !startsWith$default;
            }
        }, null, new Function0<Set<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine$appInstallRule$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<String> invoke() {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                List<PackageInfo> list = InstalledAppListMonitor.lastPackageInfoList;
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        int i3 = ((PackageInfo) it.next()).applicationInfo.flags;
                    }
                }
                List<ApplicationInfo> list2 = InstalledAppListMonitor.lastApplicationInfoList;
                if (list2 != null) {
                    for (ApplicationInfo applicationInfo : list2) {
                        if ((applicationInfo.flags & 1) == 0) {
                            String str = applicationInfo.packageName;
                            Intrinsics.checkExpressionValueIsNotNull(str, "it.packageName");
                            linkedHashSet.add(str);
                        }
                    }
                }
                LinkedHashSet<String> linkedHashSet2 = k.f344098c;
                Intrinsics.checkExpressionValueIsNotNull(linkedHashSet2, "NetworkCaptureHelper.sGetPackageInfoPkgSet");
                linkedHashSet.addAll(linkedHashSet2);
                linkedHashSet.remove(q.f());
                linkedHashSet.remove("");
                return linkedHashSet;
            }
        }, 184, null);
        ruleList.add(new NetworkCaptureRule("AndroidID", new String[]{"androidid"}, 11, null, 0, false, null, null, new Function0<Set<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine.1
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<String> invoke() {
                Set<String> mutableSetOf;
                String h16 = com.tencent.qmethod.pandoraex.core.b.d().h("device", "SE#G_AID");
                Intrinsics.checkExpressionValueIsNotNull(h16, "ApiCallEngine.getInstanc\u2026                        )");
                mutableSetOf = SetsKt__SetsKt.mutableSetOf(h16);
                return mutableSetOf;
            }
        }, 248, null));
        ruleList.add(new NetworkCaptureRule("SN", new String[]{ReportConstant.COSTREPORT_SN, SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL}, 11, null, 0, false, null, null, new Function0<Set<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine.2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<String> invoke() {
                Set<String> mutableSetOf;
                String h16 = com.tencent.qmethod.pandoraex.core.b.d().h("device", "BU#SER");
                Intrinsics.checkExpressionValueIsNotNull(h16, "ApiCallEngine.getInstanc\u2026                        )");
                mutableSetOf = SetsKt__SetsKt.mutableSetOf(h16);
                return mutableSetOf;
            }
        }, 248, null));
        ruleList.add(new NetworkCaptureRule(Global.TRACKING_IMEI, new String[]{"deviceid", "imei"}, 11, null, 0, false, null, null, new Function0<Set<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine.3
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<String> invoke() {
                Set<String> mutableSetOf;
                String h16 = com.tencent.qmethod.pandoraex.core.b.d().h("device", "BU#SER");
                Intrinsics.checkExpressionValueIsNotNull(h16, "ApiCallEngine.getInstanc\u2026                        )");
                String h17 = com.tencent.qmethod.pandoraex.core.b.d().h("device", "TM#G_DID");
                Intrinsics.checkExpressionValueIsNotNull(h17, "ApiCallEngine.getInstanc\u2026                        )");
                String h18 = com.tencent.qmethod.pandoraex.core.b.d().h("device", "TM#G_DID#I");
                Intrinsics.checkExpressionValueIsNotNull(h18, "ApiCallEngine.getInstanc\u2026                        )");
                String h19 = com.tencent.qmethod.pandoraex.core.b.d().h("device", "TM#G_IM");
                Intrinsics.checkExpressionValueIsNotNull(h19, "ApiCallEngine.getInstanc\u2026                        )");
                String h26 = com.tencent.qmethod.pandoraex.core.b.d().h("device", "TM#G_IM#I");
                Intrinsics.checkExpressionValueIsNotNull(h26, "ApiCallEngine.getInstanc\u2026                        )");
                mutableSetOf = SetsKt__SetsKt.mutableSetOf(h16, h17, h18, h19, h26);
                return mutableSetOf;
            }
        }, 248, null));
        ruleList.add(new NetworkCaptureRule("MacAddress", new String[]{"mac", AdParam.MACADDRESS}, 15, new Regex[]{regex}, 0, false, null, null, new Function0<Set<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine.4
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<String> invoke() {
                Set<String> mutableSetOf;
                String h16 = com.tencent.qmethod.pandoraex.core.b.d().h("network", "NI#G_HW_ADDR");
                Intrinsics.checkExpressionValueIsNotNull(h16, "ApiCallEngine.getInstanc\u2026                        )");
                String h17 = com.tencent.qmethod.pandoraex.core.b.d().h("network", "WI#G_MA_ADDR");
                Intrinsics.checkExpressionValueIsNotNull(h17, "ApiCallEngine.getInstanc\u2026                        )");
                mutableSetOf = SetsKt__SetsKt.mutableSetOf(h16, h17);
                return mutableSetOf;
            }
        }, 240, null));
        ruleList.add(new NetworkCaptureRule(QCircleVideoDeviceInfoUtils.STRATEGY_DEVICE_MODEL, new String[]{"model"}, 11, null, 0, false, null, null, new Function0<Set<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine.5
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<String> invoke() {
                Set<String> mutableSetOf;
                String h16 = com.tencent.qmethod.pandoraex.core.b.d().h("device", "BU#MODEL");
                Intrinsics.checkExpressionValueIsNotNull(h16, "ApiCallEngine.getInstanc\u2026                        )");
                mutableSetOf = SetsKt__SetsKt.mutableSetOf(h16);
                return mutableSetOf;
            }
        }, 248, null));
        ruleList.add(new NetworkCaptureRule("ICCID", new String[]{"iccid"}, 11, null, 0, false, null, null, new Function0<Set<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine.6
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<String> invoke() {
                Set<String> mutableSetOf;
                String h16 = com.tencent.qmethod.pandoraex.core.b.d().h("device", "TM#G_SIM_SE_NUM");
                Intrinsics.checkExpressionValueIsNotNull(h16, "ApiCallEngine.getInstanc\u2026                        )");
                mutableSetOf = SetsKt__SetsKt.mutableSetOf(h16);
                return mutableSetOf;
            }
        }, 248, null));
        ruleList.add(new NetworkCaptureRule("Clipboard", new String[0], 11, null, 0, false, null, null, new Function0<HashSet<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine.7
            @Override // kotlin.jvm.functions.Function0
            public final HashSet<String> invoke() {
                HashSet<String> hashSet = k.f344100e;
                Intrinsics.checkExpressionValueIsNotNull(hashSet, "NetworkCaptureHelper.sClipBoardSet");
                return hashSet;
            }
        }, 248, null));
        ruleList.add(new NetworkCaptureRule("IDCard", new String[]{"idcard", "id_card"}, 5, new Regex[]{regex3}, 0, false, null, null, null, w.CTRL_INDEX, null));
        ruleList.add(new NetworkCaptureRule("CellID", new String[]{s4.c.CELLID}, 3, null, 0, false, null, null, new Function0<Set<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine.8
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<String> invoke() {
                Set<String> mutableSetOf;
                mutableSetOf = SetsKt__SetsKt.mutableSetOf(com.tencent.qmethod.pandoraex.core.b.d().h("location", "GCL#G_CID"), com.tencent.qmethod.pandoraex.core.b.d().h("location", "CCL#G_BASE_STAT_ID"), com.tencent.qmethod.pandoraex.core.b.d().h("location", "CIT#G_CID"), com.tencent.qmethod.pandoraex.core.b.d().h("location", "CIL#G_CI"), com.tencent.qmethod.pandoraex.core.b.d().h("location", "CIW#G_CID"));
                mutableSetOf.remove("");
                return mutableSetOf;
            }
        }, 248, null));
        ruleList.add(new NetworkCaptureRule("BankCard", new String[]{"bankcard"}, 5, new Regex[]{regex6}, 0, false, null, null, null, w.CTRL_INDEX, null));
        ruleList.add(new NetworkCaptureRule("Phone", new String[]{"phone", "telephone"}, 5, new Regex[]{regex4}, 0, false, null, null, null, w.CTRL_INDEX, null));
        ruleList.add(new NetworkCaptureRule("IMSI", new String[]{MobileInfoUtil.IMSI}, 11, new Regex[0], 0, false, null, null, new Function0<Set<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine.9
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<String> invoke() {
                Set<String> mutableSetOf;
                String h16 = com.tencent.qmethod.pandoraex.core.b.d().h("device", "TM#G_SID");
                Intrinsics.checkExpressionValueIsNotNull(h16, "ApiCallEngine.getInstanc\u2026                        )");
                String h17 = com.tencent.qmethod.pandoraex.core.b.d().h("device", "TM#G_SID_I");
                Intrinsics.checkExpressionValueIsNotNull(h17, "ApiCallEngine.getInstanc\u2026                        )");
                mutableSetOf = SetsKt__SetsKt.mutableSetOf(h16, h17);
                return mutableSetOf;
            }
        }, 240, null));
        ruleList.add(new NetworkCaptureRule("HomeAddress", new String[]{"address", "homeaddress"}, 5, new Regex[]{regex7}, 0, false, null, null, null, w.CTRL_INDEX, null));
        ruleList.add(new NetworkCaptureRule("Email", new String[]{"email", "mail"}, 5, new Regex[]{regex2}, 0, false, null, null, null, w.CTRL_INDEX, null));
        ruleList.add(new NetworkCaptureRule("Name", new String[0], 5, new Regex[]{regex5}, 0, false, null, null, null, w.CTRL_INDEX, null));
        ruleList.add(new NetworkCaptureRule("Location", new String[]{"latitude", "longitude"}, 3, new Regex[0], 0, false, null, null, new Function0<Set<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine.10
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<String> invoke() {
                Set<String> mutableSetOf;
                if (a.f343721k.k()) {
                    Location location = LocationMonitor.lastLocation;
                    if (location != null && location.getLatitude() != 0.0d) {
                        mutableSetOf = SetsKt__SetsKt.mutableSetOf(String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()));
                        return mutableSetOf;
                    }
                    return new LinkedHashSet();
                }
                return new LinkedHashSet();
            }
        }, 240, null));
        ruleList.add(new NetworkCaptureRule("Gender", new String[]{"gender", "sex"}, 1, new Regex[0], 0, false, null, null, null, w.CTRL_INDEX, null));
        ruleList.add(new NetworkCaptureRule(NotificationActivity.PASSWORD, new String[]{NotificationActivity.PASSWORD}, 1, new Regex[0], 0, false, null, null, null, w.CTRL_INDEX, null));
        ruleList.add(new NetworkCaptureRule("birthday", new String[]{"birthday", "birth_day"}, 1, new Regex[0], 0, false, null, null, null, w.CTRL_INDEX, null));
        ruleList.add(new NetworkCaptureRule("SSID", new String[]{TPDownloadProxyEnum.USER_SSID}, 11, new Regex[0], 9, false, null, null, new Function0<Set<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine.11
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<String> invoke() {
                Set<String> mutableSetOf;
                String h16 = com.tencent.qmethod.pandoraex.core.b.d().h("network", "WI#G_SSID");
                Intrinsics.checkExpressionValueIsNotNull(h16, "ApiCallEngine.getInstanc\u2026                        )");
                mutableSetOf = SetsKt__SetsKt.mutableSetOf(h16);
                return mutableSetOf;
            }
        }, 224, null));
        ruleList.add(new NetworkCaptureRule("BSSID", new String[]{"bssid"}, 11, new Regex[0], 0, false, null, null, new Function0<Set<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine.12
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<String> invoke() {
                Set<String> mutableSetOf;
                String h16 = com.tencent.qmethod.pandoraex.core.b.d().h("network", "WI#G_BSSID");
                Intrinsics.checkExpressionValueIsNotNull(h16, "ApiCallEngine.getInstanc\u2026                        )");
                mutableSetOf = SetsKt__SetsKt.mutableSetOf(h16);
                return mutableSetOf;
            }
        }, 240, null));
        ruleList.add(new NetworkCaptureRule("OAID", new String[]{"oaid"}, 1, null, 0, false, null, null, new Function0<Set<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine.13
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<String> invoke() {
                Set<String> mutableSetOf;
                String h16 = com.tencent.qmethod.pandoraex.core.b.d().h("device", "OAID#OPPO");
                Intrinsics.checkExpressionValueIsNotNull(h16, "ApiCallEngine.getInstanc\u2026                        )");
                String h17 = com.tencent.qmethod.pandoraex.core.b.d().h("device", "OAID#XIAOMI");
                Intrinsics.checkExpressionValueIsNotNull(h17, "ApiCallEngine.getInstanc\u2026                        )");
                String h18 = com.tencent.qmethod.pandoraex.core.b.d().h("device", "OAID#VIVO");
                Intrinsics.checkExpressionValueIsNotNull(h18, "ApiCallEngine.getInstanc\u2026                        )");
                mutableSetOf = SetsKt__SetsKt.mutableSetOf(h16, h17, h18);
                return mutableSetOf;
            }
        }, 248, null));
        ruleList.add(appInstallRule);
        ruleList.add(new NetworkCaptureRule("AppBroadcast", new String[0], 10, null, 0, false, null, null, new Function0<LinkedHashSet<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine.14
            @Override // kotlin.jvm.functions.Function0
            public final LinkedHashSet<String> invoke() {
                LinkedHashSet<String> linkedHashSet = k.f344097b;
                Intrinsics.checkExpressionValueIsNotNull(linkedHashSet, "NetworkCaptureHelper.sBroadcastPkgSet");
                return linkedHashSet;
            }
        }, 248, null));
        if (a.f343721k.k()) {
            ruleList.add(new NetworkCaptureRule("NearWifiMac", new String[0], 10, new Regex[0], 0, false, null, null, new Function0<Set<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine.15
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Set<String> invoke() {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    List<ScanResult> list = NetworkMonitor.lastScanResults;
                    if (list != null) {
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            String str = ((ScanResult) it.next()).BSSID;
                            Intrinsics.checkExpressionValueIsNotNull(str, "it.BSSID");
                            linkedHashSet.add(str);
                        }
                    }
                    return linkedHashSet;
                }
            }, 240, null));
            ruleList.add(new NetworkCaptureRule("NearWifiSsid", new String[0], 10, new Regex[0], 0, false, null, null, new Function0<Set<String>>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureDefine.16
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Set<String> invoke() {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    List<ScanResult> list = NetworkMonitor.lastScanResults;
                    if (list != null) {
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            String str = ((ScanResult) it.next()).SSID;
                            Intrinsics.checkExpressionValueIsNotNull(str, "it.SSID");
                            linkedHashSet.add(str);
                        }
                    }
                    return linkedHashSet;
                }
            }, 240, null));
            ruleList.add(new NetworkCaptureRule("NearMcc", new String[]{"mcc"}, 1, null, 0, false, null, null, null, 504, null));
            ruleList.add(new NetworkCaptureRule("NearMnc", new String[]{"mnc"}, 1, null, 0, false, null, null, null, 504, null));
            ruleList.add(new NetworkCaptureRule("NearLac", new String[]{"lac"}, 1, null, 0, false, null, null, null, 504, null));
            ruleList.add(new NetworkCaptureRule("NearCid", new String[]{"cid"}, 1, null, 0, false, null, null, null, 504, null));
        }
    }

    NetworkCaptureDefine() {
    }

    @NotNull
    public final List<NetworkCaptureRule> a() {
        return ruleList;
    }
}
